package com.hahaton.backend.model.objects;

import com.hahaton.backend.model.role.User;
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
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private User user;

    @Column(name = "text")
    private String text;

    @Column(name = "news_id")
    private Long newsId;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "comment_date")
    @org.hibernate.annotations.Generated(GenerationTime.INSERT)
    private LocalDateTime commentDate;


}
