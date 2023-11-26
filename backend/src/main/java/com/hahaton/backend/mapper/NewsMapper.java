package com.hahaton.backend.mapper;

import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.news.NewNewsDto;
import com.hahaton.backend.dto.news.NewsDto;
import com.hahaton.backend.dto.news.NewsShortDto;
import com.hahaton.backend.dto.survey.SurveyDto;
import com.hahaton.backend.model.Category;
import com.hahaton.backend.model.objects.Comment;
import com.hahaton.backend.model.objects.News;
import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.status.ModerationStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NewsMapper {
    private static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";


    public static News toNews(NewNewsDto newNewsDto, Long surveyId, Organization organization, Long pictureId) {
        return News.builder()
                .organization(organization)
                .status(ModerationStatus.PENDING)
                .newsTitle(newNewsDto.getTitle())
                .location(newNewsDto.getLocation())
                .newsDate(LocalDateTime.parse(newNewsDto.getDate(), DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)))
                .pictureId(pictureId)
                .newsText(newNewsDto.getText())
                .surveyId(surveyId)
                .category(Category.getByRuName(newNewsDto.getCategory()))
                .build();
    }

    public static NewsDto toDto (News news, SurveyDto surveyDto, List<CommentDto> comments, byte[] data) {
        return NewsDto.builder()
                .id(news.getId())
                .title(news.getNewsTitle())
                .author(news.getOrganization())
                .location(news.getLocation())
                .date(news.getNewsDate().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)))
                .picture(data)
                .text(news.getNewsText())
                .survey(surveyDto)
                .status(news.getStatus().getRuName())
                .category(news.getCategory().getRuName())
                .comments(comments)
                .build();
    }

    public static NewsShortDto toShortDto (News news, byte[] data) {
        return NewsShortDto.builder()
                .id(news.getId())
                .title(news.getNewsTitle())
                .author(news.getOrganization())
                .location(news.getLocation())
                .date(news.getNewsDate().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)))
                .picture(data)
                .text(news.getNewsText())
                .status(news.getStatus().getRuName())
                .category(news.getCategory().getRuName())
                .build();
    }

}
