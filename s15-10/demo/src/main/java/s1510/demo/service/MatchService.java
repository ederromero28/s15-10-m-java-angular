package s1510.demo.service;

import s1510.demo.dtos.request.MatchRequestDTO;
import s1510.demo.dtos.response.MatchResponseDto;
import s1510.demo.model.Match;

import java.util.List;

public interface MatchService extends CRUD<Match, Integer> {
    List<MatchResponseDto> getAllMatches();
    MatchResponseDto createMatch(MatchRequestDTO matchRequestDTO);
    MatchResponseDto getMatchById(Integer id);
    MatchResponseDto updateMatch(Integer id, MatchRequestDTO matchRequestDTO);
}
