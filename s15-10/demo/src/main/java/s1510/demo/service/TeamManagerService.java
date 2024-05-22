package s1510.demo.service;

import org.springframework.http.ResponseEntity;
import s1510.demo.model.TeamManager;

import java.util.List;
import java.util.Optional;

public interface TeamManagerService {


    List<TeamManager> findAll();
    Optional<TeamManager> findById(Long teamManagerId);
    TeamManager create(TeamManager saveTeamManager);
    TeamManager update(Long teamManagerId, TeamManager teamManager);
    ResponseEntity<TeamManager> delete(Long teamManagerId);


}
