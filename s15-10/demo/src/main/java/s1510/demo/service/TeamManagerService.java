package s1510.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.TeamManagerRequest;
import s1510.demo.dtos.response.TeamManagerResponse;
import s1510.demo.model.TeamManager;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface TeamManagerService {

    Page<TeamManager> findByPage(int page, int size, String sortBy,String sortOrder);
    List<TeamManagerResponse> findAll();
    TeamManagerResponse findById(Long teamManagerId);
    TeamManagerResponse create(TeamManagerRequest saveTeamManager);
    TeamManagerResponse update(Long teamManagerId, TeamManagerRequest teamManager);
    TeamManagerResponse updateLogo(Long teamId, MultipartFile multipartFile) throws IOException;
    TeamManagerResponse delete(Long teamManagerId);


}
