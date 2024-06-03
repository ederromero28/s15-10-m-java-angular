package s1510.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import s1510.demo.dtos.request.SportRequest;
import s1510.demo.model.Sport;

import java.util.List;
import java.util.Optional;

@Profile(value = {"dev", "prod", "test"})
public interface SportService {

    List<Sport> findAll();

    Optional<Sport> findById(Long sportId);

    Sport create(SportRequest saveSport);

    Sport update(Long sportId, SportRequest updateSport);

    ResponseEntity<Sport> delete(Long sportId);

    void disabled(Long id);

    void enabled(Long id);

}
