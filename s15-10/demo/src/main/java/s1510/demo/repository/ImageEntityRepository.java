package s1510.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1510.demo.model.ImageEntity;

public interface ImageEntityRepository extends JpaRepository<ImageEntity, Long> {
}
