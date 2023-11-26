package com.hahaton.backend.service;

import com.hahaton.backend.dto.survey.NewSurveyDto;
import com.hahaton.backend.dto.survey.SurveyDto;

public interface SurveyService {

    SurveyDto createSurvey(NewSurveyDto newSurveyDto,  Long organizationId);
    SurveyDto getSurveyDto(Long surveyId);
}
