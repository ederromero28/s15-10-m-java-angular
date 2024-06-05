package s1510.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s1510.demo.model.Sport;

@Repository
@Profile(value = {"dev", "prod", "test"})
public interface SportRepository extends GenericRepo<Sport, Long> {
}
