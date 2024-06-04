package s1510.demo.service;

import org.springframework.context.annotation.Profile;
import s1510.demo.dtos.request.MatchRequestDTO;
import s1510.demo.dtos.response.MatchResponseDto;
import s1510.demo.model.Match;

import java.util.List;

@Profile(value = {"dev", "prod", "test"})
public interface MatchService {
    List<MatchResponseDto> getAllMatches();

    MatchResponseDto createMatch(MatchRequestDTO matchRequestDTO);

    MatchResponseDto getMatchById(Long id);

    MatchResponseDto updateMatch(Long id, MatchRequestDTO matchRequestDTO);
}
