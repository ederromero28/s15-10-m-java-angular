package s1510.demo.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import s1510.demo.model.Player;

import java.util.List;
import java.util.Optional;

@Repository
@Profile(value = {"dev", "prod", "test"})
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.isPresent = :isPresent")
    List<Player> findPlayersAvailable(@Param("isPresent") Boolean isPresent);

    @Modifying
    @Query("UPDATE Player p SET p.isPresent = :isPresent")
    Player updateIsPresent(@Param("isPresent") Boolean isPresent);

    @Modifying
    @Query("UPDATE Player p SET p.teamManager = :teamManager")
    Optional<Player> updateTeam(@Param("teamManager") Long teamManager);

}
