package com.hahaton.backend.model.survey;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "survey_options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "survey_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Survey survey;

    @Column(name = "option_text")
    private String optionText;


}
