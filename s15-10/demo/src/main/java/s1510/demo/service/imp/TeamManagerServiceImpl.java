package s1510.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s1510.demo.exception.ObjectNotFoundException;
import s1510.demo.model.TeamManager;
import s1510.demo.repository.TeamManagerRepository;
import s1510.demo.service.TeamManagerService;

import java.util.List;
import java.util.Optional;

@Service
public class TeamManagerServiceImpl implements TeamManagerService {

    @Autowired
    private TeamManagerRepository teamManagerRepository;

    @Override
    public List<TeamManager> findAll() {
        return teamManagerRepository.findAll();
    }

    @Override
    public Optional<TeamManager> findById(Long teamManagerId) {
        return teamManagerRepository.findById(teamManagerId);
    }

    @Override
    public TeamManager create(TeamManager saveTeamManager) {
        TeamManager newTeamManager = new TeamManager();
        newTeamManager.setName(saveTeamManager.getName());
        newTeamManager.setLogo(saveTeamManager.getLogo());
        return teamManagerRepository.save(newTeamManager);
    }

    @Override
    public TeamManager update(Long teamManagerId, TeamManager teamManager) {

        TeamManager teamM = teamManagerRepository.findById(teamManagerId)
                        .orElseThrow( () -> new ObjectNotFoundException("Team Manager no encontrado con id" + teamManagerId));

        teamM.setName(teamManager.getName());
        //ACA EL PASSWORD
        //PLAYERS
        teamM.setLogo(teamManager.getLogo());
        return teamManagerRepository.save(teamM);
    }

    @Override
    public ResponseEntity<TeamManager> delete(Long teamManagerId) {
        return null;
    }
}
