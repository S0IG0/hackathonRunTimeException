package com.hahaton.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserShortDto {
    private Long id;


    @NotBlank(message = "name may not be blank or null")
    @Size(max = 250, min = 1)
    private String name;

    @NotBlank (message = "surname may not be blank or null")
    @Size(max = 250, min = 1)
    private String surname;


}
