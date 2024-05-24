package s1510.demo.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1510.demo.repository.GenericRepo;
import s1510.demo.service.CRUD;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CRUDServiceImpl<T,ID> implements CRUD<T,ID> {
    protected  abstract GenericRepo<T,ID> getRepo();

    public T save(T t){
        return getRepo().save(t);
    }

    @Override
    public T update(T t) {
        return getRepo().save(t);
    }

    @Override
    public List<T> readAll() {
        return getRepo().findAll();
    }

    @Override
    public T ReadById(ID id) {
        return   getRepo()
                .findById(id)
                .orElse(null);
    }

    @Override
    public void delete(ID id) {
        getRepo().deleteById(id);
    }
}
