package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.request.MatchRequestDTO;
import s1510.demo.dtos.response.MatchResponseDto;
import s1510.demo.exception.ResourceNotFoundException;
import s1510.demo.model.Match;
import s1510.demo.model.Sport;
import s1510.demo.repository.GenericRepo;
import s1510.demo.repository.MatchRepository;
import s1510.demo.repository.SportRepository;
import s1510.demo.service.MatchService;
import s1510.demo.utils.GenericMapperUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchServiceImplementation extends CRUDServiceImplementation<Match, Long> implements MatchService {

    private final MatchRepository repo;
    private final GenericMapperUtil mapperUtil;

    private final SportRepository sportRepository;

    @Override
    protected GenericRepo<Match, Long> getRepo() {
        return repo;
    }

    /**
     * @return
     * @author nedder3
     */

    @Override
    public List<MatchResponseDto> getAllMatches() {
        return repo.findAll().stream()
                .map(match -> mapperUtil.mapToDto(match, MatchResponseDto.class))
                .toList();
    }

    /**
     * @param matchRequestDTO
     * @return
     * @author nedder3
     */
    @Override
    public MatchResponseDto createMatch(MatchRequestDTO matchRequestDTO) {
        Match match = mapperUtil.mapToEntity(matchRequestDTO, Match.class);
        Match savedMatch = repo.save(match);
        return mapperUtil.mapToDto(savedMatch, MatchResponseDto.class);
    }

    /**
     * @param id
     * @return matchResponseDTO
     * @author nedder3
     */

    @Override
    public MatchResponseDto getMatchById(Long id) {
        Match match = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id:"+id));
        return mapperUtil.mapToDto(match, MatchResponseDto.class);
    }

    /**
     * nota : consultar modificacion de Sports y parametros startAT y endAt
     *
     * @param id
     * @param matchRequestDTO
     * @return MatchResponseDto
     * @author nedder3
     */
    @Override
    public MatchResponseDto updateMatch(Long id, MatchRequestDTO matchRequestDTO) {
        Match existingMatch = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id: " + id));

        Sport sport = sportRepository.findById(matchRequestDTO.sportId())
                        .orElseThrow(()->new ResourceNotFoundException("Sport not found with id: "+id));

        existingMatch.setStartAt(matchRequestDTO.startAt());
        existingMatch.setEndAt(matchRequestDTO.endAt());
        existingMatch.setPointsTeamA(matchRequestDTO.pointsTeamA());
        existingMatch.setPointsTeamB(matchRequestDTO.pointsTeamB());
        existingMatch.setSport(sport);

        Match updatedMatch = repo.save(existingMatch);
        return mapperUtil.mapToDto(updatedMatch, MatchResponseDto.class);

    }
}
