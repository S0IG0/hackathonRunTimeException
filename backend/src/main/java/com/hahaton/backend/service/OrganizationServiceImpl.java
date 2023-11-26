package com.hahaton.backend.service;

import com.hahaton.backend.dto.organization.NewOrganizationDto;
import com.hahaton.backend.dto.organization.OrganizationDto;
import com.hahaton.backend.exception.ConflictException;
import com.hahaton.backend.mapper.OrganizationMapper;
import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.repository.OrganizationRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{
    private final OrganizationRepository organizationRepository;


    @Override
    public OrganizationDto postOrganization(NewOrganizationDto newOrganizationDto) {
        try {

            Organization organization =  organizationRepository.save(OrganizationMapper.toOrganization(newOrganizationDto));
            OrganizationDto savedOrganization = OrganizationMapper.toDto(organization);
            log.info("Organization saved {}", savedOrganization);
            return savedOrganization;
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }
}
