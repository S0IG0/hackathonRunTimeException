package com.hahaton.backend.dto.survey;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionDto {
    private Long id;

    private String description;

    private Integer votes;

}
