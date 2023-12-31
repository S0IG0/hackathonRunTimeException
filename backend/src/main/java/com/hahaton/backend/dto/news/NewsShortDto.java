package com.hahaton.backend.dto.news;


import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.survey.NewSurveyDto;
import com.hahaton.backend.model.Location;
import com.hahaton.backend.model.role.Organization;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsShortDto {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private Long id;

    @NotBlank(message = "title may not be blank or null")
    @Size(max = 254, min = 1)
    private String title;

    private Organization author;

    private Location location;

    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private String date;

    private byte[] picture;

    @NotBlank(message = "news text may not be blank or null")
    private String text;

    private String status;

    @NotBlank(message = "category may not be blank or null")
    private String category;


}
