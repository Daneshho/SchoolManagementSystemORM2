package ir.maktabsharif.repository.impl;

import ir.maktabsharif.database.DbManager;
import ir.maktabsharif.model.ExamEntity;
import ir.maktabsharif.repository.ExamRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ExamRepositoryImpl implements ExamRepository {
    EntityManager entityManager = DbManager.getFactory();

    @Override
    public void save(ExamEntity object) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(object);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public void update(ExamEntity object) {
        this.entityManager.getTransaction().begin();
        ExamEntity examEntity = this.entityManager.find(ExamEntity.class, object.getId());
        examEntity.setTitle(object.getTitle());
        this.entityManager.merge(examEntity);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public void delete(Long id) {
        ExamEntity examEntity = this.entityManager.find(ExamEntity.class, id);
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(examEntity);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public Optional<ExamEntity> findById(Long id) {
        this.entityManager.getTransaction().begin();
        String FIND_BY_ID = "from ExamEntity e WHERE e.id = :id";
        TypedQuery<ExamEntity> query = this.entityManager.createQuery(FIND_BY_ID, ExamEntity.class);
        query.setParameter("id", id);
        List<ExamEntity> examEntities = query.getResultList();
        System.out.println(examEntities);
        this.entityManager.getTransaction().commit();
        DbManager.close();
        return Optional.ofNullable(examEntities.get(0));
    }

    @Override
    public List<ExamEntity> getAll() {
        this.entityManager.getTransaction().begin();
        TypedQuery<ExamEntity> query = this.entityManager.createQuery("from ExamEntity", ExamEntity.class);
        List<ExamEntity> examEntities = query.getResultList();
        System.out.println(examEntities);
        this.entityManager.getTransaction().commit();
        DbManager.close();
        return examEntities;
    }

    @Override
    public void findByTitle(String title) {
        this.entityManager.getTransaction().begin();
        String FIND_BY_TITLE = "from ExamEntity e WHERE e.title = :title";
        TypedQuery<ExamEntity> query = this.entityManager.createQuery(FIND_BY_TITLE, ExamEntity.class);
        query.setParameter("title", title);
        List<ExamEntity> examEntities = query.getResultList();
        System.out.println(examEntities);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }
}
