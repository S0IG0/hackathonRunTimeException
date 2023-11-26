package com.hahaton.backend.repository;

import com.hahaton.backend.model.survey.Answer;
import com.hahaton.backend.model.survey.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(nativeQuery = true, value =
    "SELECT COUNT(*) FROM survey_answers WHERE option_id = :optionId ")
    Integer getVotes(Long optionId);
}
