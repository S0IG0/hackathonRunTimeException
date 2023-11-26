package com.hahaton.backend.dto.event;

import com.hahaton.backend.model.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewEventDto {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @NotBlank(message = "title may not be blank or null")
    @Size(max = 254, min = 1)
    private String title;

    @NotBlank(message = "title may not be blank or null")
    private String text;

    private String category;

    private Location location;

    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private String eventsDate;

    private Long pictureId;

}
