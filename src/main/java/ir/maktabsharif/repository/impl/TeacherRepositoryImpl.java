package ir.maktabsharif.repository.impl;

import ir.maktabsharif.database.DbManager;
import ir.maktabsharif.model.TeacherEntity;
import ir.maktabsharif.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImpl implements TeacherRepository {
    EntityManager entityManager = DbManager.getFactory();

    public List<TeacherEntity> findByFirstname(String firstname) {
        TypedQuery<TeacherEntity> query = entityManager.createNamedQuery("TeacherEntity.findByFirstname", TeacherEntity.class);
        query.setParameter(1, firstname);
        return query.getResultList();
    }

    public int getCount() {
        Query query = entityManager.createQuery("select count(t) from TeacherEntity t");
        return ((Long) query.getSingleResult()).intValue();
    }

    @Override
    public void save(TeacherEntity object) {
        entityManager.getTransaction().begin();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        DbManager.close();

    }

    @Override
    public void update(TeacherEntity object) {
        entityManager.getTransaction().begin();
        TeacherEntity teacherEntity = entityManager.find(TeacherEntity.class, object.getId());
        teacherEntity.setFirstName(object.getFirstName());
        teacherEntity.setLastName(object.getLastName());
        entityManager.merge(teacherEntity);
        entityManager.getTransaction().commit();
        DbManager.close();

    }

    @Override
    public void delete(Long id) {
        entityManager.getTransaction().begin();
        TeacherEntity teacherEntity = entityManager.find(TeacherEntity.class, id);
        entityManager.remove(teacherEntity);
        entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public Optional<TeacherEntity> findById(Long id) {
        entityManager.getTransaction().begin();
        String FIND_BY_ID = "from TeacherEntity t WHERE t.id = :id";
        TypedQuery<TeacherEntity> query = entityManager.createQuery(FIND_BY_ID, TeacherEntity.class);
        query.setParameter("id", id);
        List<TeacherEntity> resultList = query.getResultList();
        System.out.println(resultList);
        entityManager.getTransaction().commit();
        DbManager.close();
        return Optional.ofNullable(resultList.get(0));
    }

    @Override
    public List<TeacherEntity> getAll() {
        entityManager.getTransaction().begin();
        TypedQuery<TeacherEntity> query = entityManager.createQuery("from TeacherEntity", TeacherEntity.class);
        List<TeacherEntity> resultList = query.getResultList();
        System.out.println(resultList);
        entityManager.getTransaction().commit();
        DbManager.close();
        return resultList;
    }

    @Override
    public void findByNationalCode(String nationalCode) {
        entityManager.getTransaction().begin();
        String FIND_BY_NATIONAL_CODE = "from TeacherEntity t where t.nationalCode = :nationalCode";
        TypedQuery<TeacherEntity> query = entityManager.createQuery(FIND_BY_NATIONAL_CODE, TeacherEntity.class);
        query.setParameter("nationalCode", nationalCode);
        List<TeacherEntity> resultList = query.getResultList();
        System.out.println(resultList);
        entityManager.getTransaction().commit();
        DbManager.close();
    }

    @Override
    public void findByCourseId(long courseId) {
        entityManager.getTransaction().begin();
        String FIND_BY_COURSE_ID = "from TeacherEntity t where t.courseEntity = :courseId";
        TypedQuery<TeacherEntity> query = entityManager.createQuery(FIND_BY_COURSE_ID, TeacherEntity.class);
        query.setParameter("courseId", courseId);
        List<TeacherEntity> resultList = query.getResultList();
        System.out.println(resultList);
        entityManager.getTransaction().commit();
        DbManager.close();
    }
}