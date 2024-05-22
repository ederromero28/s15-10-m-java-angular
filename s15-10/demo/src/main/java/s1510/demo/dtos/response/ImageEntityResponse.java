package s1510.demo.dtos.response;

import s1510.demo.model.ImageEntity;

public record ImageEntityResponse(Long id,
                                  String imageInternalId,
                                  String url,
                                  String imageName) {

    public ImageEntityResponse(ImageEntity image){
        this(image.getId(),image.getImage_id(),image.getUrl(),image.getImage_name());
    }
}
