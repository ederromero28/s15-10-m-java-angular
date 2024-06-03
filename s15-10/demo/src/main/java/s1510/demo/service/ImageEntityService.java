package s1510.demo.service;

import org.springframework.context.annotation.Profile;
import s1510.demo.dtos.response.ImageEntityResponse;
import s1510.demo.model.ImageEntity;

@Profile(value = {"dev", "prod", "test"})
public interface ImageEntityService {

    ImageEntityResponse persistImage(ImageEntity image);

    ImageEntityResponse deleteImage(ImageEntity image);
}
