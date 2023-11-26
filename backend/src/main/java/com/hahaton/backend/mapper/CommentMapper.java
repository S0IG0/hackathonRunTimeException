package com.hahaton.backend.mapper;

import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.comment.NewCommentDto;
import com.hahaton.backend.dto.news.NewsShortDto;
import com.hahaton.backend.dto.user.UserShortDto;
import com.hahaton.backend.model.objects.Comment;
import com.hahaton.backend.model.role.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentMapper {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static CommentDto toDto(Comment comment) {
        UserShortDto commentAuthor = UserMapper.toUserShortDto(comment.getUser());
        return CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .commentDate(comment.getCommentDate().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)))
                .commentAuthor(commentAuthor)
                .build();
    }

    public static Comment toComment(NewCommentDto newCommentDto, User user) {
        return Comment.builder()
                .text(newCommentDto.getText())
                .user(user)
                .build();

//        return Comment.builder()
//                .id(commentDto.getId())
//                .text(commentDto.getText())
//                .commentDate(LocalDateTime.parse(commentDto.getCommentDate()))
//                .user(user).build();
    }
}
