package s1510.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.PlayerRequest;
import s1510.demo.dtos.response.PlayerResponse;

import java.io.IOException;
import java.util.List;

public interface PlayerService {

    PlayerResponse createPlayer(PlayerRequest playerRequest);

    PlayerResponse updatePlayer(Long playerId,PlayerRequest playerRequest);

    PlayerResponse logicDelete(Long playerId);
    PlayerResponse updateImage(MultipartFile file, Long playerId) throws IOException;

    List<PlayerResponse> listAllPlayers();
    List<PlayerResponse> listPlayerAvailable();
    PlayerResponse updateTeam(Long playerId, Long teamId);
}
