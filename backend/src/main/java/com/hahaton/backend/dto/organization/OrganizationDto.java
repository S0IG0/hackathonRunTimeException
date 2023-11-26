package com.hahaton.backend.dto.organization;


import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationDto {
    @NotNull(message = "inn may not be null")
    @Positive
    private Long inn;

    @Email
    @NotBlank(message = "email may not be blank or null")
    @Size(max = 254, min = 6)
    private String email;

    @NotBlank(message = "name may not be blank or null")
    @Size(max = 250, min = 1)
    private String name;

    @NotBlank(message = "address may not be blank or null")
    @Size(max = 250, min = 8)
    private String address;


}
