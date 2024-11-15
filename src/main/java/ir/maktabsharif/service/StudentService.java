package ir.maktabsharif.service;

import ir.maktabsharif.model.StudentEntity;

import java.util.Optional;

public interface StudentService extends BaseService<StudentEntity> {
    Optional<StudentEntity> findByNationalCode(String nationalCode);
}
