package s1510.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s1510.demo.model.Team;

@Repository
@Profile(value = {"dev", "prod", "test"})
public interface TeamRepository extends JpaRepository<Team, Long> {
}
