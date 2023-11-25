package com.hahaton.backend.model.objects;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "responses")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "request_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Request request;

    @Column(name = "text")
    private String text;

    @Column(name = "picture_id")
    private Long pictureId;
}
