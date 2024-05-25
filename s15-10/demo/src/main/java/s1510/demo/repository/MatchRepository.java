package s1510.demo.repository;

import org.springframework.stereotype.Repository;
import s1510.demo.model.Match;

@Repository
public interface MatchRepository extends GenericRepo<Match, Long> {
}
