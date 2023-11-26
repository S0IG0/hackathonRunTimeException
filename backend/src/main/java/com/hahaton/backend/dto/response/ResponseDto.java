package com.hahaton.backend.dto.response;

import com.hahaton.backend.model.objects.Rating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {
    private Long id;

    @NotBlank(message = "response may not be blank or null")
    @Size(max = 254, min = 1)
    private String text;

    private byte[] picture;

    private List<Rating> ratings;
}
