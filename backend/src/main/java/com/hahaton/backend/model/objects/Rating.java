package com.hahaton.backend.model.objects;


import com.hahaton.backend.model.role.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "response_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Response response;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private User user;

    @Column(name = "rating")
    private Integer rating;
}
