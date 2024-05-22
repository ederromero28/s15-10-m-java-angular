package s1510.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import s1510.demo.model.TeamManager;

import java.util.List;
import java.util.Optional;

public interface TeamManagerService {

    Page<TeamManager> findByPage(int page, int size, String sortBy,String sortOrder);
    List<TeamManager> findAll();
    Optional<TeamManager> findById(Long teamManagerId);
    TeamManager create(TeamManager saveTeamManager);
    TeamManager update(Long teamManagerId, TeamManager teamManager);
    ResponseEntity<TeamManager> delete(Long teamManagerId);


}
