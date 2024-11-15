package ir.maktabsharif.repository.impl;

import ir.maktabsharif.database.DbManager;
import ir.maktabsharif.model.CourseEntity;
import ir.maktabsharif.repository.CourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryImpl implements CourseRepository {

    EntityManager entityManager = DbManager.getFactory();

    @Override
    public void save(CourseEntity object) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(object);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public void update(CourseEntity object) {
        this.entityManager.getTransaction().begin();
        CourseEntity courseEntity = this.entityManager.find(CourseEntity.class, object.getId());
        courseEntity.setUnit(object.getUnit());
        courseEntity.setTitle(object.getTitle());
        courseEntity.setTeachers(object.getTeachers());
        courseEntity.setExamEntities(object.getExamEntities());
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }


    @Override
    public void delete(Long id) {
        this.entityManager.getTransaction().begin();
        CourseEntity object = this.entityManager.find(CourseEntity.class, id);
        this.entityManager.remove(object);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public Optional<CourseEntity> findById(Long id) {
        this.entityManager.getTransaction().begin();
        String FIND_BY_ID = "from CourseEntity c where c.id = :id";
        TypedQuery<CourseEntity> query = this.entityManager.createQuery(FIND_BY_ID, CourseEntity.class);
        query.setParameter("id", id);
        List<CourseEntity> result = query.getResultList();
        System.out.println(result);
        this.entityManager.getTransaction().commit();
        DbManager.close();
        return Optional.ofNullable(result.isEmpty() ? null : result.get(0));
    }

    @Override
    public List<CourseEntity> getAll() {
        this.entityManager.getTransaction().begin();
        TypedQuery<CourseEntity> query = this.entityManager.createQuery("from CourseEntity", CourseEntity.class);
        List<CourseEntity> result = query.getResultList();
        System.out.println(result);
        this.entityManager.getTransaction().commit();
        DbManager.close();
        return result;
    }

    @Override
    public Optional<CourseEntity> findByTitle(String title) {
        this.entityManager.getTransaction().begin();
        String FIND_BY_TITLE = "from CourseEntity c where c.title = :title";
        TypedQuery<CourseEntity> query = this.entityManager.createQuery(FIND_BY_TITLE, CourseEntity.class);
        query.setParameter("title", title);
        List<CourseEntity> result = query.getResultList();
        System.out.println(result);
        this.entityManager.getTransaction().commit();
        DbManager.close();
        return Optional.ofNullable(result.isEmpty() ? null : result.get(0));
    }
}