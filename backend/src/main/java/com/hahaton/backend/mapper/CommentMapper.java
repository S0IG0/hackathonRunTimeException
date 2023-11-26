package com.hahaton.backend.mapper;

import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.user.UserShortDto;
import com.hahaton.backend.model.objects.Comment;

import java.time.format.DateTimeFormatter;

public class CommentMapper {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static CommentDto toDto (Comment comment) {
        UserShortDto commentAuthor = UserMapper.toUserShortDto(comment.getUser());
        return CommentDto.builder()
                .id(comment.getId())
                .text(comment.getText())
                .commentDate(comment.getEventsDate().format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)))
                .commentAuthor(commentAuthor)
                .build();
    }
}
