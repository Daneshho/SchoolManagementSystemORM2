package ir.maktabsharif.service;

import ir.maktabsharif.model.TeacherEntity;

import java.util.Optional;

public interface TeacherService extends BaseService<TeacherEntity> {
    Optional<TeacherEntity> findByNationalCode(String nationalCode);
}
