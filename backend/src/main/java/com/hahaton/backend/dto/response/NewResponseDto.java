package com.hahaton.backend.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewResponseDto {
    @NotBlank(message = "response may not be blank or null")
    @Size(max = 254, min = 1)
    private String text;

    private byte[] picture;
}
