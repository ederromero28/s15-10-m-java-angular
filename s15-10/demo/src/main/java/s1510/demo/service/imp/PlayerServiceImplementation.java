package s1510.demo.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import s1510.demo.dtos.request.PlayerRequest;
import s1510.demo.dtos.response.PlayerResponse;
import s1510.demo.exception.ObjectNotFoundException;
import s1510.demo.model.ImageEntity;
import s1510.demo.model.Player;
import s1510.demo.model.TeamManager;
import s1510.demo.repository.PlayerRepository;
import s1510.demo.repository.TeamManagerRepository;
import s1510.demo.service.PlayerService;
import s1510.demo.helpers.CloudinaryService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Profile(value = {"dev", "prod", "test"})
@RequiredArgsConstructor
public class PlayerServiceImplementation implements PlayerService {

    private final PlayerRepository playerRepository;
    private final CloudinaryService cloudinaryService;
    private final TeamManagerRepository teamManagerRepository;

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

        if (player.getIsPresent()) {
            playerRepository.updateIsPresent(false);
            return new PlayerResponse(player);
        }

        playerRepository.updateIsPresent(true);

        return new PlayerResponse(player);

    }

    @Override
    public PlayerResponse updateImage(MultipartFile file, Long playerId) throws IOException {

        Player playerFound = playerRepository.findById(playerId)
                .orElseThrow(() -> new ObjectNotFoundException("Player not found whit id" + playerId));

        Map imgProperties = cloudinaryService.uploadNewImage(file);

        ImageEntity newImage = new ImageEntity();

        newImage.setImage_name((String) imgProperties.get("original_filename"));
        newImage.setUrl((String) imgProperties.get("url"));
        newImage.setImage_id((String) imgProperties.get("public_id"));

        playerFound.setImage(newImage);
        playerRepository.save(playerFound);

        return new PlayerResponse(playerFound);

    }

    @Override
    public List<PlayerResponse> listAllPlayers() {

        return playerRepository.findAll()
                .stream()
                .map(PlayerResponse::new)
                .toList();

    }

    @Override
    public List<PlayerResponse> listPlayerAvailable() {

        return playerRepository.findPlayersAvailable(true)
                .stream()
                .map(PlayerResponse::new)
                .toList();
    }

    @Override
    public PlayerResponse updateTeam(Long playerId, Long teamId) {

        Player playerFound = playerRepository.findById(playerId)
                .orElseThrow(() -> new ObjectNotFoundException("Player not found whit id" + playerId));

        TeamManager teamManagerFound = teamManagerRepository.findById(teamId)
                .orElseThrow(() -> new ObjectNotFoundException("Team not found whit id" + teamId));

        playerFound.setTeamManager(teamManagerFound);
        playerRepository.save(playerFound);

        return new PlayerResponse(playerFound);

    }

}
