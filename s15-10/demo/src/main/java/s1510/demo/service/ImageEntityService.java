package s1510.demo.service;

import s1510.demo.dtos.response.ImageEntityResponse;
import s1510.demo.model.ImageEntity;

public interface ImageEntityService {

    ImageEntityResponse persistImage(ImageEntity image);
    ImageEntityResponse deleteImage(ImageEntity image);
}
