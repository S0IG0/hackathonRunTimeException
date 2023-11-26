package com.hahaton.backend.dto.survey;


import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.survey.Option;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SurveyDto {

    private Long id;

    private String description;

    private Organization organization;

    private List<OptionDto> options;


}
