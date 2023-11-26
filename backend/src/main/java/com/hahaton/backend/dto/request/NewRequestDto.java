package com.hahaton.backend.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewRequestDto {
    @NotBlank(message = "title may not be blank or null")
    @Size(max = 250, min = 1)
    private String title;

    @NotBlank(message = "request may not be blank or null")
    @Size(max = 250, min = 1)
    private String text;

    private byte[] picture;
}
