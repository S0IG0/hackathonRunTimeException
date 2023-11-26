package com.hahaton.backend.controller;


import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.comment.NewCommentDto;
import com.hahaton.backend.dto.user.UserDto;
import com.hahaton.backend.service.CommentService;
import com.hahaton.backend.service.UserService;
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
@RequestMapping(path = "/users")
@AllArgsConstructor
public class PrivateController {
    private final UserService userService;
    private final CommentService commentService;

    @DeleteMapping("/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable @Positive Long userId) {
        log.info("Delete user by owner request accepted, id={}", userId);
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUser(@PathVariable @Positive Long userId) {
        log.info("Get user request accepted, id={}", userId);
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }
    @PostMapping("/users/news/{newsId}/comment/{userId}")
    ResponseEntity<CommentDto> addCommentToNews(@PathVariable("newsId") @Positive Long newsId,
                                                @PathVariable("userId") @Positive Long userId,
                                                @RequestBody NewCommentDto newCommentDto){
        log.info("Add comment to news with id={}, from user with id={}", newsId, userId);
        return new ResponseEntity<>(commentService.addCommentToNews(newCommentDto, newsId, userId), HttpStatus.OK);
    }
    @PostMapping("/users/event/{eventId}/comment/{userId}")
    ResponseEntity<CommentDto> addCommentToEvent(@PathVariable("eventId") @Positive Long eventId,
                                                @PathVariable("userId") @Positive Long userId,
                                                @RequestBody NewCommentDto newCommentDto){
        log.info("Add comment to event with id={}, from user with id={}", eventId, userId);
        return new ResponseEntity<>(commentService.addCommentToNews(newCommentDto, eventId, userId), HttpStatus.OK);
    }
    @PostMapping("/users/request/{requestId}/comment/{userId}")
    ResponseEntity<CommentDto> addCommentToRequest(@PathVariable("requestId") @Positive Long requestId,
                                                @PathVariable("userId") @Positive Long userId,
                                                @RequestBody NewCommentDto newCommentDto){
        log.info("Add comment to request with id={}, from user with id={}", requestId, userId);
        return new ResponseEntity<>(commentService.addCommentToNews(newCommentDto, requestId, userId), HttpStatus.OK);
    }

}
