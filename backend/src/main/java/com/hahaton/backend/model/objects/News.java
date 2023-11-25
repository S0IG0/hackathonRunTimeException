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
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "author_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Organization organization;

    @Column(name = "news_date")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private LocalDateTime newsDate;

    @JoinColumn(name = "location_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Location location;

    @Column(name = "news_text")
    private String newsText;

    @Column(name = "news_title")
    private String newsTitle;

    @Column(name = "picture_id")
    private Long pictureId;

    @Column(name = "survey_id")
    private Long surveyId;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ModerationStatus status;

}
