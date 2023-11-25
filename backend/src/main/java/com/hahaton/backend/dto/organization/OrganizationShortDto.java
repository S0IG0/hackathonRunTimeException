package com.hahaton.backend.dto.organization;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrganizationShortDto {
    @NotNull(message = "inn may not be null")
    @Positive
    private Long inn;

    @NotBlank(message = "name may not be blank or null")
    @Size(max = 250, min = 1)
    private String name;


}
