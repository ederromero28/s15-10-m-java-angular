package s1510.demo.service.imp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.TeamManagerRequest;
import s1510.demo.dtos.response.TeamManagerResponse;
import s1510.demo.enums.Role;
import s1510.demo.exception.ObjectNotFoundException;
import s1510.demo.model.ImageEntity;
import s1510.demo.model.Player;
import s1510.demo.model.TeamManager;
import s1510.demo.repository.PlayerRepository;
import s1510.demo.repository.TeamManagerRepository;
import s1510.demo.service.TeamManagerService;
import s1510.demo.utils.CloudinaryService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class TeamManagerServiceImplementation implements TeamManagerService {

    @Autowired
    private TeamManagerRepository teamManagerRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Page<TeamManager> findByPage(int page, int size, String sortBy, String sortOrder) {
        Pageable pageable = PageRequest.of(page -1, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
        return teamManagerRepository.findAll(pageable);
    }

    @Override
    public List<TeamManagerResponse> findAll() {

        List<TeamManager> teamsFound = teamManagerRepository.findAll();

        return teamsFound.stream().map(TeamManagerResponse::new).toList();
    }

    @Override
    public TeamManagerResponse findById(Long teamManagerId) {
        TeamManager teamFound = teamManagerRepository.findById(teamManagerId)
                .orElseThrow(() ->new ObjectNotFoundException("Team no encontrado con el id"+ teamManagerId));

        return new TeamManagerResponse(teamFound);
    }

    @Override
    public TeamManagerResponse create(TeamManagerRequest saveTeamManager) {

        TeamManager newTeamManager = new TeamManager();

        newTeamManager.setName(saveTeamManager.name());
        newTeamManager.setEmail(saveTeamManager.email());
        newTeamManager.setIsPresent(true);
        newTeamManager.setRole(Role.TEAM_MANAGER);

        teamManagerRepository.save(newTeamManager);

        return new TeamManagerResponse(newTeamManager);
    }

    @Transactional
    @Override
    public TeamManagerResponse update(Long teamManagerId, TeamManagerRequest teamManager) {

        TeamManager teamM = teamManagerRepository.findById(teamManagerId)
                        .orElseThrow( () -> new ObjectNotFoundException("Team Manager no encontrado con id" + teamManagerId));

        teamM.setName(teamManager.name());
        teamM.setEmail(teamManager.email());
        teamM.setPassword(teamManager.password());
        teamManagerRepository.save(teamM);

        return new TeamManagerResponse(teamM);
    }

    @Transactional
    @Override
    public TeamManagerResponse updateLogo(Long teamId, MultipartFile multipartFile) throws IOException {

        TeamManager team = teamManagerRepository.findById(teamId)
                .orElseThrow(() -> new ObjectNotFoundException("Team no encontrado con id" + teamId));

        Map imgProperties = cloudinaryService.uploadNewImage(multipartFile);

        ImageEntity newImage = new ImageEntity();

        newImage.setImage_name((String) imgProperties.get("original_filename"));
        newImage.setUrl((String) imgProperties.get("url"));
        newImage.setImage_id((String) imgProperties.get("public_id"));

        team.setLogo(newImage);
        teamManagerRepository.save(team);

        return  new TeamManagerResponse(team);

    }

    @Transactional
    @Override
    public TeamManagerResponse delete(Long teamManagerId) {

        TeamManager team = teamManagerRepository.findById(teamManagerId)
                .orElseThrow(() ->new ObjectNotFoundException("Team no encontrado con el id" + teamManagerId));

        teamManagerRepository.delete(team);

        return new TeamManagerResponse(team);

    }

    @Transactional
    @Override
    public TeamManagerResponse updateRoster(Long teamId, Long playerId) {

        Player playerFound = playerRepository.findById(playerId)
                .orElseThrow(() -> new ObjectNotFoundException("Player not found whit id" + playerId));

        TeamManager teamManagerFound = teamManagerRepository.findById(teamId)
                .orElseThrow(() -> new ObjectNotFoundException("Team not found whit id" + teamId));

        List<Player> roster = teamManagerFound.getPlayers();
        roster.add(playerFound);

        teamManagerFound.setPlayers(roster);
        teamManagerRepository.save(teamManagerFound);

        return new TeamManagerResponse(teamManagerFound);

    }


}
