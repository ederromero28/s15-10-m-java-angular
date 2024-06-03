package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.response.ImageEntityResponse;
import s1510.demo.model.ImageEntity;
import s1510.demo.repository.ImageEntityRepository;
import s1510.demo.service.ImageEntityService;

@Service
@Profile(value = {"dev", "prod", "test"})
@RequiredArgsConstructor
public class ImageEntityServiceImplementation implements ImageEntityService {

    private final ImageEntityRepository imageEntityRepository;

    @Override
    public ImageEntityResponse persistImage(ImageEntity image) {
        ImageEntity img = imageEntityRepository.save(image);
        return new ImageEntityResponse(image);
    }

    @Override
    public ImageEntityResponse deleteImage(ImageEntity image) {
        imageEntityRepository.delete(image);
        return new ImageEntityResponse(image);
    }
}
