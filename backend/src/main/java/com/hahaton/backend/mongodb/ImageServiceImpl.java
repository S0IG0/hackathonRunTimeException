package com.hahaton.backend.mongodb;

import com.hahaton.backend.exception.ImageException;
import com.hahaton.backend.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@Slf4j
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public Long putImage(MultipartFile file) {
        try {
            Image image = new Image();
            image.setId(1L);//todo: refactor hardcoded id
            image.setData(file.getBytes());
            return imageRepository.save(image).getId();
        } catch (IOException e) {
            throw new ImageException(e.getMessage());
        }
    }

    @Override
    public Image getImage(Long imageId) {
        Image image = imageRepository.findById(imageId).orElseThrow(
                () -> new NotFoundException("no such image")
        );
        return image;
    }
}
