package com.hahaton.backend.dto.event;

import com.hahaton.backend.model.Location;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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

    @NotBlank(message = "category may not be blank or null")
    private String category;

    @NotNull(message = "location may not be blank or null")
    private Location location;

    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private String eventsDate;

    private MultipartFile picture;

}
