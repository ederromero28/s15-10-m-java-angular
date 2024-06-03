package s1510.demo.service;

import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile(value = {"dev", "prod", "test"})
public interface CRUD<T, ID> {
    T save(T t);

    T update(T t);

    List<T> readAll();

    T ReadById(ID id);

    void delete(ID id);
}
