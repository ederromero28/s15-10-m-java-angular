package s1510.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.exception.ObjectNotFoundException;
import s1510.demo.model.Sport;
import s1510.demo.repository.SportRepository;
import s1510.demo.service.SportService;

import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImpl implements SportService {

    @Autowired
    private SportRepository sportRepository;

    @Override
    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

    @Override
    public Optional<Sport> findById(Long sportId) {
        return sportRepository.findById(sportId);
    }

    @Override
    public Sport create(SportRequest saveSport) {

        Sport sport =new Sport();
        sport.setName(saveSport.name());
        sport.setTeamSize(saveSport.teamSize());
        sport.setRounds(saveSport.rounds());
        sport.setStatus(true);

        return sportRepository.save(sport);

    }

    @Override
    public Sport update(Long sportId, SportRequest updateSport) {

        Sport sportDB = sportRepository.findById(sportId)
                .orElseThrow( () -> new ObjectNotFoundException("Sport no encontrado con id" + sportId));

        sportDB.setName(updateSport.name());
        sportDB.setTeamSize(updateSport.teamSize());
        sportDB.setRounds(updateSport.rounds());

        return sportRepository.save(sportDB);
    }

    @Override
    public ResponseEntity<Sport> delete(Long sportId) {
        if (sportRepository.findById(sportId).isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        sportRepository.deleteById(sportId);
        return ResponseEntity.ok().body(null);
    }

    @Override
    public void disabled(Long id) {
        Optional<Sport> sportDB = sportRepository.findById(id);
        if (sportDB.isPresent()){
            Sport finalySport = sportDB.get();
            finalySport.setStatus(Boolean.FALSE);
            sportRepository.save(finalySport);
        }
    }

    @Override
    public void enabled(Long id) {
        Optional<Sport> sportDB = sportRepository.findById(id);
        if (sportDB.isPresent()){
            Sport finalySport = sportDB.get();
            finalySport.setStatus(Boolean.TRUE);
            sportRepository.save(finalySport);
        }
    }
}
