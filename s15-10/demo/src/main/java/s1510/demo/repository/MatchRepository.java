package s1510.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import s1510.demo.model.Match;

@Repository
@Profile(value = {"dev", "prod", "test"})
public interface MatchRepository extends GenericRepo<Match, Long> {
}
