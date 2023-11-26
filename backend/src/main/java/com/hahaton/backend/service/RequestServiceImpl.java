package com.hahaton.backend.service;

import com.hahaton.backend.dto.organization.OrganizationShortDto;
import com.hahaton.backend.dto.request.NewRequestDto;
import com.hahaton.backend.dto.request.RequestDto;
import com.hahaton.backend.dto.user.UserShortDto;
import com.hahaton.backend.exception.ConflictException;
import com.hahaton.backend.exception.NotFoundException;
import com.hahaton.backend.mapper.OrganizationMapper;
import com.hahaton.backend.mapper.RequestMapper;
import com.hahaton.backend.mapper.UserMapper;
import com.hahaton.backend.model.Picture;
import com.hahaton.backend.model.objects.Request;
import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.role.User;
import com.hahaton.backend.repository.OrganizationRepository;
import com.hahaton.backend.repository.PictureRepository;
import com.hahaton.backend.repository.RequestRepository;
import com.hahaton.backend.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class RequestServiceImpl implements RequestService{
    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final PictureRepository pictureRepository;

    @Override
    public RequestDto postRequest(NewRequestDto newRequestDto, Long userId, Long organizationId, Long pictureId) {
        try{
            User user = userRepository.findById(userId).orElseThrow(
                    () -> new NotFoundException("no such user")
            );
            Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                    () -> new NotFoundException("no such organization")
            );
            Request request = RequestMapper.toRequest(newRequestDto, user, organization, pictureId);
            UserShortDto userShortDto = UserMapper.toUserShortDto(user);
            OrganizationShortDto organizationShortDto = OrganizationMapper.toShortDto(organization);
            return null;
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }
}
