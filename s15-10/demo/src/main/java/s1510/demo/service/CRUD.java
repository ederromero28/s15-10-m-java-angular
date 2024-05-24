package s1510.demo.service;

import java.util.List;

public interface CRUD <T,ID>{
    T save (T t);
    T update(T t);
    List<T> readAll();
    T ReadById(ID id);
    void delete(ID id);
}
