package s1510.demo.service.imp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.TeamRequest;
import s1510.demo.dtos.response.TeamResponse;
import s1510.demo.exception.ObjectNotFoundException;
import s1510.demo.model.ImageEntity;
import s1510.demo.model.Player;
import s1510.demo.model.Team;
import s1510.demo.repository.PlayerRepository;
import s1510.demo.repository.TeamRepository;
import s1510.demo.service.TeamService;
import s1510.demo.helpers.CloudinaryService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Profile(value = {"dev", "prod", "test"})
public class TeamServiceImplementation implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Page<Team> findByPage(int page, int size, String sortBy, String sortOrder) {

        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));

        return teamRepository.findAll(pageable);

    }

    @Override
    public List<TeamResponse> findAll() {

        List<Team> teamsFound = teamRepository.findAll();

        return teamsFound.stream().map(TeamResponse::new).toList();
    }

    @Override
    public TeamResponse findById(Long teamId) {

        Team teamFound = teamRepository.findById(teamId)
                .orElseThrow(() -> new ObjectNotFoundException("Team no encontrado con el id" + teamId));

        return new TeamResponse(teamFound);
    }

    @Override
    public TeamResponse create(TeamRequest saveTeam) {

        Team newTeam = new Team();

        newTeam.setName(saveTeam.name());
        newTeam.setEmail(saveTeam.email());
        newTeam.setIsPresent(true);
//        newTeam.setRole(Role.TEAM);

        teamRepository.save(newTeam);

        return new TeamResponse(newTeam);

    }

    @Transactional
    @Override
    public TeamResponse update(Long teamId, TeamRequest team) {

        Team teamM = teamRepository.findById(teamId)
                .orElseThrow(() -> new ObjectNotFoundException("Team Manager no encontrado con id" + teamId));

        teamM.setName(team.name());
        teamM.setEmail(team.email());
        teamM.setPassword(team.password());
        teamRepository.save(teamM);

        return new TeamResponse(teamM);

    }

    @Transactional
    @Override
    public TeamResponse updateLogo(Long teamId, MultipartFile multipartFile) throws IOException {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ObjectNotFoundException("Team no encontrado con id" + teamId));

        Map imgProperties = cloudinaryService.uploadNewImage(multipartFile);

        ImageEntity newImage = new ImageEntity();

        newImage.setImage_name((String) imgProperties.get("original_filename"));
        newImage.setUrl((String) imgProperties.get("url"));
        newImage.setImage_id((String) imgProperties.get("public_id"));

        team.setLogo(newImage);
        teamRepository.save(team);

        return new TeamResponse(team);

    }

    @Transactional
    @Override
    public TeamResponse delete(Long teamId) {

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ObjectNotFoundException("Team no encontrado con el id" + teamId));

        teamRepository.delete(team);

        return new TeamResponse(team);

    }

    @Transactional
    @Override
    public TeamResponse updateRoster(Long teamId, Long playerId) {

        Player playerFound = playerRepository.findById(playerId)
                .orElseThrow(() -> new ObjectNotFoundException("Player not found whit id" + playerId));

        Team teamFound = teamRepository.findById(teamId)
                .orElseThrow(() -> new ObjectNotFoundException("Team not found whit id" + teamId));

        List<Player> roster = teamFound.getPlayers();
        roster.add(playerFound);

        teamFound.setPlayers(roster);
        teamRepository.save(teamFound);

        return new TeamResponse(teamFound);

    }


}
