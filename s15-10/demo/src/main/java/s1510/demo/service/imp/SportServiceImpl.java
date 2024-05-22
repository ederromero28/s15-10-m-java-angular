package s1510.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import s1510.demo.dtos.SportDTO;
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
    public Sport create(SportDTO saveSport) {

        Sport sport =new Sport();
        sport.setName(saveSport.getName());
        sport.setTeamSize(saveSport.getTeamSize());
        sport.setRounds(saveSport.getRounds());

        return sportRepository.save(sport);

    }

    @Override
    public Sport update(Long sportId, SportDTO updateSport) {

        Sport sportDB = sportRepository.findById(sportId)
                .orElseThrow( () -> new ObjectNotFoundException("Sport no encontrado con id" + sportId));

        sportDB.setName(updateSport.getName());
        sportDB.setTeamSize(updateSport.getTeamSize());
        sportDB.setRounds(updateSport.getRounds());

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
}
