package ir.maktabsharif.service.impl;

import ir.maktabsharif.repository.BaseRepository;
import ir.maktabsharif.service.BaseService;

import java.util.List;

public class BaseServiceImpl <T> implements BaseService <T>{
    private final BaseRepository<T> repository;

    public BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T t) {
        try {

            repository.save(t);

        }catch (Exception e) {
            System.out.println("data connection failed :( ");
        }
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(T t) {

    }

    @Override
    public List<T> getAll() {
        return List.of();
    }

    @Override
    public T getById(int id) {
        return null;
    }

}
