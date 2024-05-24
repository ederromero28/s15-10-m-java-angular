package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1510.demo.model.Match;
import s1510.demo.repository.GenericRepo;
import s1510.demo.service.MatchService;

@Service
@RequiredArgsConstructor
public class MatchServiceImpl extends CRUDServiceImpl<Match,Integer> implements MatchService {
    @Override
    protected GenericRepo<Match,Integer> getRepo() {
        return null;
    }

    @Override
    public Match save(Match match) {
        return null;
    }

    @Override
    public Match update(Match match) {
        return null;
    }

    @Override
    public Match ReadById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }
}
