package s1510.demo.service;

import s1510.demo.dtos.request.MatchRequestDTO;
import s1510.demo.dtos.response.MatchResponseDto;
import s1510.demo.model.Match;

import java.util.List;

public interface MatchService extends CRUD<Match, Long> {
    List<MatchResponseDto> getAllMatches();
    MatchResponseDto createMatch(MatchRequestDTO matchRequestDTO);
    MatchResponseDto getMatchById(Long id);
    MatchResponseDto updateMatch(Long id, MatchRequestDTO matchRequestDTO);
}
