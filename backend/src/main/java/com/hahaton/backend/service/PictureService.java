package com.hahaton.backend.service;

import com.hahaton.backend.model.Picture;

public interface PictureService {

    Long postPicture(byte[] data);
    Picture getPicture(Long pictureId);

}
