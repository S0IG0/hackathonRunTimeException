package com.hahaton.backend.service;


import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.news.NewNewsDto;
import com.hahaton.backend.dto.news.NewsDto;
import com.hahaton.backend.dto.news.NewsShortDto;
import com.hahaton.backend.dto.survey.SurveyDto;
import com.hahaton.backend.exception.ConflictException;
import com.hahaton.backend.exception.NotFoundException;
import com.hahaton.backend.mapper.NewsMapper;
import com.hahaton.backend.model.Category;
import com.hahaton.backend.model.objects.News;
import com.hahaton.backend.repository.NewsRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final SurveyService surveyService;
    private final CommentService commentService;
    private final LocationService locationService;

    @Override
    public NewsDto postNews(NewNewsDto newNewsDto, Long organizationId) {
        try {
            SurveyDto surveyDto = surveyService.createSurvey(newNewsDto.getSurvey(), organizationId);
            News news = NewsMapper.toNews(newNewsDto, surveyDto.getId(), surveyDto.getOrganization());
            locationService.saveLocation(newNewsDto.getLocation());
            News savedNews = newsRepository.save(news);
            List<CommentDto> commentDtos = commentService.getNewsComments(savedNews.getId());
            NewsDto newsDto = NewsMapper.toDto(savedNews, surveyDto, commentDtos);
            log.info("saved news: {}", newsDto);
            return newsDto;
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }

    @Override
    public List<NewsShortDto> getNewsByCategory(Category category, PageRequest pageRequest) {
        List<News> newsList;
        if (category.equals(Category.All)) {
            newsList = newsRepository.findAll(pageRequest).toList();
        } else {
            newsList = newsRepository.findAllByCategory(category, pageRequest);
        }

        List<NewsShortDto> shortDtos = new ArrayList<>();
        for (News news :
                newsList) {
            shortDtos.add(NewsMapper.toShortDto(news));
        }
        return shortDtos;
    }

    @Override
    public NewsDto getNewsById(Long newsId) {
        News news = newsRepository.findById(newsId).orElseThrow(
                () -> new NotFoundException("no such organization")
        );
        SurveyDto surveyDto = surveyService.getSurveyDto(news.getSurveyId());
        List<CommentDto> commentDtos = commentService.getNewsComments(news.getId());
        NewsDto newsDto = NewsMapper.toDto(news, surveyDto, commentDtos);
        log.info("found news: {}", newsDto);
        return newsDto;
    }
}
