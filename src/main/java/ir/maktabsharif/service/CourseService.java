package ir.maktabsharif.service;

import ir.maktabsharif.model.CourseEntity;

import java.util.Optional;

public interface CourseService extends BaseService<CourseEntity> {
    Optional<CourseEntity> findByTitle(String title);
}
