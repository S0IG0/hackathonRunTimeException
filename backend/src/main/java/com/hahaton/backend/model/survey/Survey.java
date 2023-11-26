package com.hahaton.backend.model.survey;

import com.hahaton.backend.model.role.Organization;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "author_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Organization organization;


}
