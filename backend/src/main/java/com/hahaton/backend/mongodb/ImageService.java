package com.hahaton.backend.mongodb;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    Long putImage(MultipartFile file);
    Image getImage(Long imageId);

}
