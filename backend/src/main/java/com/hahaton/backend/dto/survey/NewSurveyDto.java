package com.hahaton.backend.dto.survey;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewSurveyDto {

    @NotBlank(message = "description may not be blank or null")
    @Size(max = 254, min = 1)
    private String description;

    @NotNull(message = "options list may not be null")
    private List<String> options;

    @NotBlank(message = "title may not be blank or null")
    @Size(max = 254, min = 1)
    private String title;

}
