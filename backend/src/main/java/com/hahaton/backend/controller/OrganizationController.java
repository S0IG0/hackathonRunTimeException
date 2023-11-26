package com.hahaton.backend.controller;

import com.hahaton.backend.dto.news.NewNewsDto;
import com.hahaton.backend.dto.news.NewsDto;
import com.hahaton.backend.dto.user.NewUserDto;
import com.hahaton.backend.dto.user.UserDto;
import com.hahaton.backend.repository.NewsRepository;
import com.hahaton.backend.service.NewsService;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Slf4j
@RequestMapping(path = "/organization")
@AllArgsConstructor
public class OrganizationController {
    private final NewsService newsService;

    @PostMapping("/{organizationId}/news")
    ResponseEntity<NewsDto> createNews(
            @PathVariable @Positive Long organizationId,
            @RequestBody @Validated NewNewsDto newNewsDto) {
        log.info("News post accepted: {}", newNewsDto);
        return new ResponseEntity<>(newsService.postNews(newNewsDto, organizationId), HttpStatus.CREATED);
    }




}
