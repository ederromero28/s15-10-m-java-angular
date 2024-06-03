package s1510.demo.dtos.response;

import org.springframework.context.annotation.Profile;
import s1510.demo.model.ImageEntity;

@Profile(value = {"dev", "prod", "test"})

public record ImageEntityResponse(Long id,
                                  String imageInternalId,
                                  String url,
                                  String imageName) {

    public ImageEntityResponse(ImageEntity image) {
        this(image.getId(), image.getImage_id(), image.getUrl(), image.getImage_name());
    }
}
