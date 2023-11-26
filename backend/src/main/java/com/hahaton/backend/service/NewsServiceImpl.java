package com.hahaton.backend.service;


import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.news.NewNewsDto;
import com.hahaton.backend.dto.news.NewsDto;
import com.hahaton.backend.dto.news.NewsShortDto;
import com.hahaton.backend.dto.survey.SurveyDto;
import com.hahaton.backend.exception.ConflictException;
import com.hahaton.backend.exception.NotFoundException;
import com.hahaton.backend.exception.ValidationException;
import com.hahaton.backend.mapper.NewsMapper;
import com.hahaton.backend.model.Category;
import com.hahaton.backend.model.Location;
import com.hahaton.backend.model.Picture;
import com.hahaton.backend.model.objects.News;
import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.status.ModerationStatus;
import com.hahaton.backend.model.survey.Survey;
import com.hahaton.backend.repository.NewsRepository;
import com.hahaton.backend.repository.OrganizationRepository;
import com.hahaton.backend.repository.SurveyRepository;
import jakarta.annotation.PostConstruct;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private final PictureService pictureService;
    private final SurveyRepository surveyRepository;
    private final OrganizationRepository organizationRepository;

    @Override
    public NewsDto postNews(NewNewsDto newNewsDto, Long organizationId) {
        try {
            SurveyDto surveyDto = surveyService.createSurvey(newNewsDto.getSurvey(), organizationId);
            Long pictureId = pictureService.postPicture(newNewsDto.getPicture());
            News news = NewsMapper.toNews(newNewsDto, surveyDto.getId(), surveyDto.getOrganization(), pictureId);
            locationService.saveLocation(newNewsDto.getLocation());
            News savedNews = newsRepository.save(news);
            List<CommentDto> commentDtos = commentService.getNewsComments(savedNews.getId());
            NewsDto newsDto = NewsMapper.toDto(savedNews, surveyDto, commentDtos, pictureService.getPicture(news.getPictureId()).getData());
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
            if (news.getStatus().equals(ModerationStatus.PUBLISHED)) {
                shortDtos.add(NewsMapper.toShortDto(news, pictureService.getPicture(news.getPictureId()).getData()));
            }

        }
        return shortDtos;
    }

    @Override
    public NewsDto getNewsById(Long newsId) {
        News news = newsRepository.findById(newsId).orElseThrow(
                () -> new NotFoundException("no such organization")
        );
        if (!news.getStatus().equals(ModerationStatus.PUBLISHED)) {
            throw new NotFoundException("Эта новость не опубликована");
        }
        SurveyDto surveyDto = surveyService.getSurveyDto(news.getSurveyId());
        List<CommentDto> commentDtos = commentService.getNewsComments(news.getId());
        NewsDto newsDto = NewsMapper.toDto(news, surveyDto, commentDtos, pictureService.getPicture(news.getPictureId()).getData());
        log.info("found news: {}", newsDto);
        return newsDto;
    }

    @Override
    public void moderateNews(Long newsId, boolean approved) {
        News news = newsRepository.findById(newsId).orElseThrow(
                () -> new NotFoundException("no such organization")
        );
        if (!news.getStatus().equals(ModerationStatus.PENDING)) {
            throw new ValidationException("новость нельзя модерировать, её статус не ожидание");
        }
        if (approved) {
            news.setStatus(ModerationStatus.PUBLISHED);
        } else {
            news.setStatus(ModerationStatus.REJECTED);
        }
        newsRepository.save(news);
    }

    @Override
    public List<NewsShortDto> getNewsByStatus(ModerationStatus status, PageRequest pageRequest) {
        List<News> newsList;

        newsList = newsRepository.findAllByStatus(status, pageRequest);

        List<NewsShortDto> shortDtos = new ArrayList<>();
        for (News news :
                newsList) {

            shortDtos.add(NewsMapper.toShortDto(news, pictureService.getPicture(news.getPictureId()).getData()));
        }
        return shortDtos;
    }

    @PostConstruct
    public void putInNews() throws IOException {
        for (Long i = 1L; i < 10; i++) {
            FileInputStream input = new FileInputStream("src/main/pictures/Дорога.jpg");
            byte[] data = input.readAllBytes();
            pictureService.postPicture(data);
        }
        for (Long i = 1L; i < 10; i++) {
            organizationRepository.save(Organization.builder()
                    .address("Адрес")
                    .email(i +"aka@mail.ru")
                    .name("ЖЭК")
                    .password("123123123")
                    .id(i)
                    .build());
        }


        surveyRepository.save(Survey.builder()
                        .id(1L)
                        .description("Текст опроса")
                        .organization(organizationRepository.findById(1L).orElseThrow())
                .build());

        for (Long i = 1L; i < 10; i++) {
            Location location = locationService.saveLocation(Location.builder()
                    .address("Адрес Локации " + i)
                    .lat((float) (55.754167 + i * 0.001))
                    .lon((float) (37.62 + i * 0.001))
                    .build());
            News news = News.builder()
                    .id(i)
                    .newsText("Текст новости " + i)
                    .newsTitle("Заголовок новости " + i)
                    .status(ModerationStatus.PUBLISHED)
                    .organization(organizationRepository.findById(i).orElseThrow())
                    .location(location)
                    .category(Category.LIGHT)
                    .pictureId(i)
                    .surveyId(1L)
                    .build();
            newsRepository.save(news);
        }
    }
}
