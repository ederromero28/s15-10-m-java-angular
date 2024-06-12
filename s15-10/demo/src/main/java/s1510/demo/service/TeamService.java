package s1510.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.TeamRequest;
import s1510.demo.dtos.response.TeamResponse;
import s1510.demo.model.Team;

import java.io.IOException;
import java.util.List;

@Profile(value = {"dev", "prod", "test"})
public interface TeamService {

    Page<Team> findByPage(int page, int size, String sortBy, String sortOrder);

    List<TeamResponse> findAll();

    TeamResponse findById(Long teamId);

    TeamResponse create(TeamRequest saveTeam);

    TeamResponse update(Long teamId, TeamRequest team);

    TeamResponse updateLogo(Long teamId, MultipartFile multipartFile) throws IOException;

    TeamResponse delete(Long teamId);

    TeamResponse updateRoster(Long teamId, Long playerId);

}
