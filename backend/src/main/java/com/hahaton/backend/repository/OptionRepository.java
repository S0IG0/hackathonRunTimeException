package com.hahaton.backend.repository;

import com.hahaton.backend.model.survey.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {
    List<Option> findAllBySurveyId(Long surveyId);
}
