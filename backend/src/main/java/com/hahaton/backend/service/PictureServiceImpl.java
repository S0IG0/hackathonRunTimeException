package com.hahaton.backend.service;

import com.hahaton.backend.exception.NotFoundException;
import com.hahaton.backend.model.Picture;
import com.hahaton.backend.repository.PictureRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;

    @Override
    public Long postPicture(byte[] data) {
        Picture savedPicture = pictureRepository.save(Picture.builder()
                .data(data)
                .build());
        return savedPicture.getId();
    }

    @Override
    public Picture getPicture(Long pictureId) {
        return pictureRepository.findById(pictureId).orElseThrow(
                () -> new NotFoundException("no such image")
        );
    }
}
