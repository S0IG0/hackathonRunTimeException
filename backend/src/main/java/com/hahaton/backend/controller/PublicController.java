package com.hahaton.backend.controller;


import com.hahaton.backend.dto.news.NewsDto;
import com.hahaton.backend.dto.news.NewsShortDto;
import com.hahaton.backend.dto.user.NewUserDto;
import com.hahaton.backend.dto.user.UserDto;
import com.hahaton.backend.model.Category;
import com.hahaton.backend.mongodb.ImageService;
import com.hahaton.backend.service.NewsService;
import com.hahaton.backend.service.UserService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Validated
@Slf4j
@RequestMapping(path = "/")
@AllArgsConstructor
public class PublicController {
    private final UserService userService;
    private final NewsService newsService;
    private final ImageService imageService;

    @PostMapping("user/register")
    ResponseEntity<UserDto> createUser(@RequestBody @Validated NewUserDto newUserDto) {
        log.info("User post accepted: {}", newUserDto);
        return new ResponseEntity<>(userService.postUser(newUserDto), HttpStatus.CREATED);
    }

    @GetMapping("news")
    ResponseEntity<List<NewsShortDto>> getNewsByCategory(
            @RequestParam(required = false, defaultValue = "") String category,
            @RequestParam(required = false, defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(required = false, defaultValue = "10") @PositiveOrZero Integer size
    ) {
        Category checkedCategory = Category.All;
        if (!category.isEmpty()) {
            checkedCategory = Category.getByRuName(category);
        }
        log.info("Get news request accepted by category: {}", category);

        return ResponseEntity.ok(newsService.getNewsByCategory(checkedCategory, PageRequest.of(page, size)));
    }

    @GetMapping("news/{newsId}")
    ResponseEntity<NewsDto> getNewsById(
            @PathVariable @Positive Long newsId
    ) {

        log.info("Get news by id request accepted: {}", newsId);

        return ResponseEntity.ok(newsService.getNewsById(newsId));
    }

    @PostMapping("image")
    ResponseEntity<Long> postImage (
            @RequestBody MultipartFile file
    ) {
        Long id = imageService.putImage(file);
        return ResponseEntity.ok(id);
    }


}
