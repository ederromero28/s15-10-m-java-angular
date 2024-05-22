package s1510.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s1510.demo.model.Sport;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {
}
