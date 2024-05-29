package s1510.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import s1510.demo.model.Player;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.status = true")
    List<Player> findPlayersAvailable();

    @Modifying
    @Query("UPDATE Player p SET p.status = :status")
    Optional<Player> updateStatus(@Param("status")Boolean status);
}
