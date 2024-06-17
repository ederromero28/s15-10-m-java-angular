package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.dtos.response.SportResponse;
import s1510.demo.exception.ResourceNotFoundException;
import s1510.demo.helpers.GenericMapperUtil;
import s1510.demo.model.Sport;
import s1510.demo.repository.SportRepository;
import s1510.demo.service.SportService;

import java.util.List;

@Service
@Profile(value = {"dev", "prod", "test"})
@RequiredArgsConstructor
public class SportServiceImplementation implements SportService {

    private final SportRepository sportRepository;


    private final GenericMapperUtil mapperUtil;

    @Override
    public List<SportResponse> findAll() {
        return sportRepository.findAll()
                .stream()
                .map(SportResponse::new)
                .toList();
    }

    @Override
    public SportResponse findById(Long id) {
        Sport sport = sportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sport not found with id: " + id));
        return new SportResponse(sport);
    }

    @Override
    public SportResponse create(SportRequest saveSport) {

        Sport newSport = new Sport();
        newSport.setName(saveSport.name());
        newSport.setTeamSize(saveSport.teamSize());
        newSport.setRounds(saveSport.rounds());
        newSport.setStatus(true);
        sportRepository.save(newSport);
        return new SportResponse(newSport);

    }

    @Override
    public SportResponse update(Long id, SportRequest sportRequest) {
        Sport sportDB = sportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sport not found with id: " + id));
        if (sportRequest.name() != null) {
            sportDB.setName(sportRequest.name());
        }
        if (sportRequest.teamSize() != null) {
            sportDB.setTeamSize(sportRequest.teamSize());
        }
        if (sportRequest.rounds() != null) {
            sportDB.setRounds(sportRequest.rounds());
        }
        Sport updateSport = sportRepository.save(sportDB);
        return new SportResponse(updateSport);
    }

    @Override
    public void disabled(Long id) {
        Sport sportDB = sportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sport not found with id: " + id));
        sportDB.setStatus(Boolean.FALSE);
        sportRepository.save(sportDB);
    }

    @Override
    public void enabled(Long id) {
        Sport sportDB = sportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sport not found with id: " + id));
        sportDB.setStatus(Boolean.TRUE);
        sportRepository.save(sportDB);
    }
}