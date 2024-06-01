package s1510.demo.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.PlayerRequest;
import s1510.demo.dtos.response.PlayerResponse;
import s1510.demo.exception.ObjectNotFoundException;
import s1510.demo.model.Player;
import s1510.demo.repository.PlayerRepository;
import s1510.demo.service.PlayerService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImplementation implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public PlayerResponse createPlayer(PlayerRequest playerRequest) {

        Player newPlayer = new Player();

        newPlayer.setName(playerRequest.name());
        newPlayer.setName(playerRequest.email());
        newPlayer.setName(playerRequest.contactEmail());
        newPlayer.setName(playerRequest.password());
        newPlayer.setName(playerRequest.phone());

        playerRepository.save(newPlayer);

        return new PlayerResponse(newPlayer);
    }

    @Transactional
    @Override
    public PlayerResponse updatePlayer(Long playerId, PlayerRequest playerRequest) {

        Player playerFound = playerRepository.findById(playerId)
                .orElseThrow(() -> new ObjectNotFoundException("Player no entonctrado con el id" + playerId));

        playerFound.setName(playerRequest.name());
        playerFound.setEmail(playerRequest.email());
        playerFound.setContactEmail(playerRequest.contactEmail());
        playerFound.setPassword(playerRequest.password());
        playerFound.setContactEmail(playerRequest.phone());
        return null;
    }

    @Transactional
    @Override
    public PlayerResponse logicDelete(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ObjectNotFoundException("Player no encontrado con el id" + playerId));
        if (player.getStatus()) {
            playerRepository.updateStatus(false);
            return new PlayerResponse(player);
        }
        playerRepository.updateStatus(true);
        return new PlayerResponse(player);
    }

    @Override
    public List<PlayerResponse> listAllPlayers() {
        return playerRepository.findAll().stream().map(PlayerResponse::new).toList();

    }

    @Override
    public List<PlayerResponse> listPlayerAvailable() {
        return playerRepository.findPlayersAvailable().stream().map(PlayerResponse::new).toList();
    }
}
