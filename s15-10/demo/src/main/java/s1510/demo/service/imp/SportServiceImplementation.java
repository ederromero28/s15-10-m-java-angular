package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.dtos.response.SportResponse;
import s1510.demo.exception.ObjectNotFoundException;
import s1510.demo.exception.ResourceNotFoundException;
import s1510.demo.helpers.GenericMapperUtil;
import s1510.demo.model.Match;
import s1510.demo.model.Sport;
import s1510.demo.repository.GenericRepo;
import s1510.demo.repository.SportRepository;
import s1510.demo.service.SportService;

import java.util.List;
import java.util.Optional;

@Service
@Profile(value = {"dev", "prod", "test"})
@RequiredArgsConstructor
public class SportServiceImplementation extends CRUDServiceImplementation<Sport, Long> implements SportService {

    private final SportRepository sportRepository;
    private final GenericMapperUtil mapperUtil;

    @Override
    public List<SportResponse> findAll() {
        return sportRepository.findAll().stream()
                .map(sport -> mapperUtil.mapToDto(sport, SportResponse.class))
                .toList();
    }

    @Override
    public SportResponse findById(Long sportId) {
        Sport sport = sportRepository.findById(sportId)
                .orElseThrow(() -> new ObjectNotFoundException("Sport not found with id " + sportId));
        return mapperUtil.mapToDto(sport, SportResponse.class);
    }

    @Override
    public SportResponse create(SportRequest saveSport) {
        Sport sport = mapperUtil.mapToEntity(saveSport, Sport.class);
        Sport savedSport = sportRepository.save(sport);
        return mapperUtil.mapToDto(savedSport, SportResponse.class);
    }

    @Override
    public SportResponse update(Long sportId, SportRequest sportRequest) {
        Sport existingSport = sportRepository.findById(sportId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id: " + sportId));

        existingSport.setName(sportRequest.name());
        existingSport.setTeamSize(sportRequest.teamSize());
        existingSport.setRounds(sportRequest.rounds());

        Sport updateSport = sportRepository.save(existingSport);
        return mapperUtil.mapToDto(updateSport, SportResponse.class);
    }

    @Override
    public void disabled(Long id) {
        Optional<Sport> sportDB = sportRepository.findById(id);
        if (sportDB.isPresent()) {
            Sport finalySport = sportDB.get();
            finalySport.setStatus(Boolean.FALSE);
            sportRepository.save(finalySport);
        }
    }


    @Override
    public void enabled(Long id) {
        Optional<Sport> sportDB = sportRepository.findById(id);
        if (sportDB.isPresent()) {
            Sport finalySport = sportDB.get();
            finalySport.setStatus(Boolean.TRUE);
            sportRepository.save(finalySport);
        }
    }

    @Override
    protected GenericRepo<Sport, Long> getRepo() {
        return sportRepository;
    }
}