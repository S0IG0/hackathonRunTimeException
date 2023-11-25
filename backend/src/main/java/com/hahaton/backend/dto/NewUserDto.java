package com.hahaton.backend.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUserDto {
    private Long id;

    @Email(message = "email may not have incorrect format, be blank or null")
    @NotBlank
    @Size(max = 254, min = 6)
    private String email;

    @NotBlank(message = "name may not be blank or null")
    @Size(max = 250, min = 1)
    private String name;

    @NotBlank (message = "surname may not be blank or null")
    @Size(max = 250, min = 1)
    private String surname;


    @NotBlank (message = "address may not be blank or null")
    @Size(max = 250, min = 8)
    private String address;

}
