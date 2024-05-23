package s1510.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import s1510.demo.model.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
