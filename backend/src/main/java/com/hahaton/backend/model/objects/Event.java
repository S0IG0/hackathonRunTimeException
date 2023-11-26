package com.hahaton.backend.model.objects;


import com.hahaton.backend.model.Category;
import com.hahaton.backend.model.Location;
import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.status.ModerationStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "author_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Organization organization;

    @Column(name = "event_date")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private LocalDateTime eventsDate;

    @JoinColumn(name = "location_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Location location;

    @Column(name = "event_title")
    private String eventTitle;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "picture_id")
    private Long pictureId;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ModerationStatus status;
}

