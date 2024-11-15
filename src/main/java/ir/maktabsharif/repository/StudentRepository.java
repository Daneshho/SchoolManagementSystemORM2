package ir.maktabsharif.repository;

import ir.maktabsharif.model.StudentEntity;

public interface StudentRepository extends BaseRepository<StudentEntity> {
    void findByNationalCode(String nationalCode);
}
