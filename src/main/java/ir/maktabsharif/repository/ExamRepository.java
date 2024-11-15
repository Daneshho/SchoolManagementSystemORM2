package ir.maktabsharif.repository;

import ir.maktabsharif.model.ExamEntity;

public interface ExamRepository extends BaseRepository<ExamEntity> {
    void findByTitle(String title);

}
