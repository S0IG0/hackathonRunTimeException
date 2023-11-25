package com.hahaton.backend.model.survey;


import com.hahaton.backend.model.role.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "survey_answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "option_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Option option;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private User user;

}
