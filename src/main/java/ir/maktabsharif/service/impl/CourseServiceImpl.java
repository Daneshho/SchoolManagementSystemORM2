package ir.maktabsharif.service.impl;

import ir.maktabsharif.database.DbManager;
import ir.maktabsharif.model.CourseEntity;
import ir.maktabsharif.service.CourseService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {
    @Override
    public Optional<CourseEntity> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public void save(CourseEntity courseEntity) {
        EntityManager entityManager = DbManager.getFactory();
        entityManager.getTransaction().begin();
        entityManager.persist(courseEntity);
        entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public void update(CourseEntity courseEntity) {
        EntityManager entityManager = DbManager.getFactory();
        entityManager.getTransaction().begin();
        entityManager.merge(courseEntity);
        entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public void delete(CourseEntity courseEntity) {

    }

    @Override
    public List<CourseEntity> getAll() {
        return List.of();
    }

    @Override
    public CourseEntity getById(int id) {
        return null;
    }
}
