package ir.maktabsharif.repository.impl;

import ir.maktabsharif.database.DbManager;
import ir.maktabsharif.model.StudentEntity;
import ir.maktabsharif.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements StudentRepository {

    EntityManager entityManager = DbManager.getFactory();

    @Override
    public void save(StudentEntity object) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(object);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public void update(StudentEntity object) {
        this.entityManager.getTransaction().begin();
        StudentEntity studentEntity = this.entityManager.find(StudentEntity.class, object.getId());
        studentEntity.setFirstName(object.getFirstName());
        studentEntity.setLastName(object.getLastName());
        studentEntity.setDob(object.getDob());
        studentEntity.setGpu(object.getGpu());
        studentEntity.setCourse(object.getCourse());
        studentEntity.setNationalCode(object.getNationalCode());
        this.entityManager.merge(studentEntity);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public void delete(Long id) {
        this.entityManager.getTransaction().begin();
        StudentEntity studentEntity = this.entityManager.find(StudentEntity.class, id);
        this.entityManager.remove(studentEntity);
        this.entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public Optional<StudentEntity> findById(Long id) {
        this.entityManager.getTransaction().begin();
        String FIND_BY_ID = "from StudentEntity s where s.id = :id";
        TypedQuery<StudentEntity> query = this.entityManager.createQuery(FIND_BY_ID, StudentEntity.class);
        query.setParameter("id", id);
        List<StudentEntity> studentEntities = query.getResultList();
        System.out.println(studentEntities);
        this.entityManager.getTransaction().commit();
        DbManager.close();
        return Optional.ofNullable(studentEntities.isEmpty() ? null : studentEntities.get(0));
    }

    @Override
    public List<StudentEntity> getAll() {
        this.entityManager.getTransaction().begin();
        TypedQuery<StudentEntity> query = this.entityManager.createQuery("from StudentEntity", StudentEntity.class);
        List<StudentEntity> studentEntities = query.getResultList();
        for (StudentEntity studentEntity : studentEntities) {
            this.entityManager.getTransaction();
            System.out.println(studentEntity);
        }
        this.entityManager.getTransaction().commit();
//        DbManager.close();
        return studentEntities;
    }

    @Override
    public void findByNationalCode(String nationalCode) {
        entityManager.getTransaction().begin();
        String FIND_BY_ID = "from StudentEntity s where s.nationalCode = :nationalCode";
        TypedQuery<StudentEntity> query = entityManager.createQuery(FIND_BY_ID, StudentEntity.class);
        query.setParameter("nationalCode", nationalCode);
        List<StudentEntity> studentEntities = query.getResultList();
        System.out.println(studentEntities);
        entityManager.getTransaction().commit();
        DbManager.close();
    }
}
