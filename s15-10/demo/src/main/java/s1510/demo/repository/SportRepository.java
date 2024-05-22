package s1510.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1510.demo.model.Sport;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
