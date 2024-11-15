package ir.maktabsharif.service;

import ir.maktabsharif.model.ExamEntity;

import java.util.Optional;

public interface ExamService extends BaseService<ExamEntity> {
    Optional<ExamEntity> findByTitle(String title);
}
