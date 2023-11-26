package com.hahaton.backend.service;

import com.hahaton.backend.dto.survey.NewSurveyDto;
import com.hahaton.backend.dto.survey.OptionDto;
import com.hahaton.backend.dto.survey.SurveyDto;
import com.hahaton.backend.exception.ConflictException;
import com.hahaton.backend.exception.NotFoundException;
import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.survey.Option;
import com.hahaton.backend.model.survey.Survey;
import com.hahaton.backend.repository.AnswerRepository;
import com.hahaton.backend.repository.OptionRepository;
import com.hahaton.backend.repository.OrganizationRepository;
import com.hahaton.backend.repository.SurveyRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;
    private final OptionRepository optionRepository;
    private final OrganizationRepository organizationRepository;
    private final AnswerRepository answerRepository;


    @Override
    public SurveyDto createSurvey(NewSurveyDto newSurveyDto, Long organizationId) {
        try {
            Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                    () -> new NotFoundException("no such organization")
            );
            Survey survey = surveyRepository.save(
                    Survey.builder()
                            .description(newSurveyDto.getDescription())
                            .organization(organization)
                            .build()
            );
            log.info("saved survey: {}", survey);
            List<Option> savedOptions = saveOptions(newSurveyDto, survey);
            List<OptionDto> optionDtos = getOptionDtos(savedOptions);

            SurveyDto surveyDto = getSurveyDto(survey, optionDtos);
            return surveyDto;
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }

    private static SurveyDto getSurveyDto(Survey survey, List<OptionDto> optionDtos) {
        SurveyDto surveyDto = SurveyDto.builder()
                .id(survey.getId())
                .description(survey.getDescription())
                .organization(survey.getOrganization())
                .options(optionDtos)
                .build();

        log.info("formed surveyDto {}", surveyDto);
        return surveyDto;
    }

    private List<OptionDto> getOptionDtos(List<Option> savedOptions) {
        List<OptionDto> optionDtos = new ArrayList<>();
        for (Option option :
                savedOptions) {
            Integer votes = answerRepository.getVotes(option.getId());
            optionDtos.add(OptionDto.builder()
                    .id(option.getId())
                    .description(option.getOptionText())
                    .votes(votes)
                    .build());
        }
        log.info("found OptionDtos: {}", optionDtos);
        return optionDtos;
    }

    private List<Option> saveOptions(NewSurveyDto newSurveyDto, Survey survey) {
        List<Option> options = new ArrayList<>();
        for (String option :
                newSurveyDto.getOptions()) {
            options.add(Option.builder()
                    .survey(survey)
                    .optionText(option)
                    .build());
        }
        List<Option> savedOptions = optionRepository.saveAll(options);
        log.info("saved options {}", savedOptions);
        return savedOptions;
    }

    @Override
    public SurveyDto getSurveyDto(Long surveyId) {
        try {
            Survey survey = surveyRepository.findById(surveyId).orElseThrow(
                    () -> new NotFoundException("no such survey")
            );
            List <Option> optionsList = optionRepository.findAllBySurveyId(surveyId);
            List<OptionDto> optionDtoList = getOptionDtos(optionsList);
            return getSurveyDto(survey, optionDtoList);


        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }
}
