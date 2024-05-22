package s1510.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1510.demo.model.TeamManager;

public interface TeamManagerRepository extends JpaRepository<TeamManager, Long> {
}
