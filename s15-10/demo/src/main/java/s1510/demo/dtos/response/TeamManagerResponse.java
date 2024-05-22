package s1510.demo.dtos.response;

import s1510.demo.model.TeamManager;

import java.util.List;

public record TeamManagerResponse(Long id,
                                  String name,
                                  String email,
                                  List<String> awards) {

    public TeamManagerResponse(TeamManager teamManager, List<String> awards){
        this(teamManager.getId(), teamManager.getName(), teamManager.getEmail(), awards);
    }
}
