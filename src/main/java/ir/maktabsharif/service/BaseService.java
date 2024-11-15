package ir.maktabsharif.service;

import java.util.List;

public interface BaseService<T> {

    void save(T t);

    void update(T t);

    void delete(T t);

    List<T> getAll();

    T getById(int id);
}
