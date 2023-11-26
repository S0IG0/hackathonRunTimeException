package com.hahaton.backend.dto.comment;

import com.hahaton.backend.dto.user.UserShortDto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private Long id;

    private String text;

    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private String commentDate;

    private UserShortDto commentAuthor;

}
