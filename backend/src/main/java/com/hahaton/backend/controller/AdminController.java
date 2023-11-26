package com.hahaton.backend.controller;


import com.hahaton.backend.dto.news.NewsShortDto;
import com.hahaton.backend.dto.organization.NewOrganizationDto;
import com.hahaton.backend.dto.organization.OrganizationDto;
import com.hahaton.backend.model.Category;
import com.hahaton.backend.model.status.ModerationStatus;
import com.hahaton.backend.service.NewsService;
import com.hahaton.backend.service.OrganizationService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@Slf4j
@RequestMapping(path = "/admin")
@AllArgsConstructor
public class AdminController {
    private final OrganizationService organizationService;
    private final NewsService newsService;

    @PostMapping("/register-organization")
    ResponseEntity<OrganizationDto> createOrganization(@RequestBody @Validated NewOrganizationDto newOrganizationDto) {
        log.info("Organization post accepted: {}", newOrganizationDto);
        return new ResponseEntity<>(organizationService.postOrganization(newOrganizationDto), HttpStatus.CREATED);
    }

    @PostMapping("/moderation-news/{id}")
    ResponseEntity<Void> moderateNews(
            @PathVariable @Positive Long id,
            @RequestParam Boolean approved
    ) {
        log.info("Moderation news with id: {} and approved: {} post accepted", id, approved);
        newsService.moderateNews(id, approved);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/news")
    ResponseEntity<List<NewsShortDto>> getNewsByStatus(
            @RequestParam(required = false, defaultValue = "") String status,
            @RequestParam(required = false, defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(required = false, defaultValue = "10") @PositiveOrZero Integer size
    ) {
        ModerationStatus moderationStatus = ModerationStatus.getByRuName(status);
        log.info("Get news by status bu admin request accepted : {}", status);
        return ResponseEntity.ok(newsService.getNewsByStatus(moderationStatus, PageRequest.of(page, size)));
    }


}
