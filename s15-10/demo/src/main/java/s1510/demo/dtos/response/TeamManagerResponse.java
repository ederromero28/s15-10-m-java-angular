package s1510.demo.dtos.response;

import s1510.demo.model.TeamManager;

import java.util.List;

public record TeamManagerResponse(Long id,
                                  String name,
                                  String email,
                                  List<String> awards,
                                  ImageEntityResponse image,
                                  List<PlayerResponse> players) {

    public TeamManagerResponse(TeamManager teamManager, List<String> awards){
        this(teamManager.getId(),
                teamManager.getName(),
                teamManager.getEmail(),
                awards,
                new ImageEntityResponse(
                        teamManager.getLogo()),
                teamManager.getPlayers().stream().map(PlayerResponse::new).toList());
    }

    public TeamManagerResponse(TeamManager teamManager) {
        this(teamManager.getId(),
                teamManager.getName(),
                teamManager.getEmail(),
                null,
                new ImageEntityResponse(
                        teamManager.getLogo()),
                teamManager.getPlayers().stream().map(PlayerResponse::new).toList());
    }

}
