package ir.maktabsharif.repository;

import ir.maktabsharif.model.CourseEntity;

import java.util.Optional;

public interface CourseRepository extends BaseRepository<CourseEntity> {
    Optional<CourseEntity> findByTitle(String title);
}