package com.hahaton.backend.mongodb;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "images")
public class Image {
    @Id
    private Long id;
    private byte[] data;

    // геттеры и сеттеры
}