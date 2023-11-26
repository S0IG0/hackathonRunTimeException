package com.hahaton.backend.service;

import com.hahaton.backend.dto.news.NewNewsDto;
import com.hahaton.backend.dto.news.NewsDto;
import com.hahaton.backend.dto.news.NewsShortDto;
import com.hahaton.backend.model.Category;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface NewsService {
    NewsDto postNews (NewNewsDto newNewsDto, Long organizationId);
    List<NewsShortDto> getNewsByCategory (Category category, PageRequest pageRequest);
    NewsDto getNewsById (Long newsId);

}
