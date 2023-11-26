package com.hahaton.backend.dto.event;


import com.hahaton.backend.dto.comment.CommentDto;
import com.hahaton.backend.dto.organization.OrganizationDto;
import com.hahaton.backend.dto.organization.OrganizationShortDto;
import com.hahaton.backend.model.Category;
import com.hahaton.backend.model.Location;
import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.status.ModerationStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private Long id;

    private String title;

    private String text;

    private String status;

    private String category;

    private OrganizationShortDto author;

    private Location location;

    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private String eventsDate;

    private Long pictureId;

    private List<CommentDto> commentDtoList;





}
