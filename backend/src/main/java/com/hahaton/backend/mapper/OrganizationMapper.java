package com.hahaton.backend.mapper;

import com.hahaton.backend.dto.organization.NewOrganizationDto;
import com.hahaton.backend.dto.organization.OrganizationDto;
import com.hahaton.backend.dto.organization.OrganizationShortDto;
import com.hahaton.backend.model.role.Organization;

public class OrganizationMapper {

    public static Organization toOrganization(NewOrganizationDto newOrganizationDto) {
        return Organization.builder()
                .id(newOrganizationDto.getInn())
                .email(newOrganizationDto.getEmail())
                .name(newOrganizationDto.getName())
                .password(newOrganizationDto.getPassword())
                .address(newOrganizationDto.getPassword())
                .build();
    }

    public static OrganizationShortDto toShortDto(Organization organization) {
        return OrganizationShortDto.builder()
                .inn(organization.getId())
                .name(organization.getName())
                .build();
    }

    public static OrganizationDto toDto(Organization organization) {
        return OrganizationDto.builder()
                .inn(organization.getId())
                .email(organization.getEmail())
                .name(organization.getName())
                .address(organization.getAddress())
                .build();
    }

}
