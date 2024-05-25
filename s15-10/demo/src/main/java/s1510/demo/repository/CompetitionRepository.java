package s1510.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s1510.demo.model.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
