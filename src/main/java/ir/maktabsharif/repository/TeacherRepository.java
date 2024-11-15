package ir.maktabsharif.repository;

import ir.maktabsharif.model.TeacherEntity;

public interface TeacherRepository extends BaseRepository<TeacherEntity> {
    void findByNationalCode(String nationalCode);

    void findByCourseId(long courseId);
}