package com.hahaton.backend.dto.news;


import com.hahaton.backend.dto.survey.NewSurveyDto;
import com.hahaton.backend.model.Location;
import com.hahaton.backend.model.survey.Survey;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewNewsDto {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @NotBlank(message = "title may not be blank or null")
    @Size(max = 254, min = 1)
    private String title;

    private Location location;

    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private String date;

    private byte[] picture;

    @NotBlank(message = "news text may not be blank or null")
    private String text;

    private NewSurveyDto survey;

    @NotBlank(message = "category may not be blank or null")
    private String category;
}
