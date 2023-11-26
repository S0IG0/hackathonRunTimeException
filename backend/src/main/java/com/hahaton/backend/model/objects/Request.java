package com.hahaton.backend.model.objects;


import com.hahaton.backend.model.role.Organization;
import com.hahaton.backend.model.role.User;
import com.hahaton.backend.model.status.RequestStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @JoinColumn(name = "receiver_id")
    @OneToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Organization organization;

    @Column(name = "picture_id")
    private Long pictureId;

    @JoinColumn(name = "initiator_id")
    @OneToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private User user;

    @Column(name = "request_date")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private LocalDateTime requestDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RequestStatus status;


}
