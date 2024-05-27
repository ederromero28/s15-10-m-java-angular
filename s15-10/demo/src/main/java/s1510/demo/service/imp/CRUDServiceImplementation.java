package s1510.demo.service.imp;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s1510.demo.repository.GenericRepo;
import s1510.demo.service.CRUD;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CRUDServiceImplementation<T, ID> implements CRUD<T, ID> {
    protected abstract GenericRepo<T, ID> getRepo();

    public T save(T t) {
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
        return getRepo()
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No encontrado"));
    }

    @Override
    public void delete(ID id) {
        getRepo().deleteById(id);
    }
}
