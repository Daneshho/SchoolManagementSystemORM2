package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@ToString
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "course")
public class CourseEntity extends BaseEntity {

    @Column(name = "course_title")
    private String title;

    @Column(name = "course_unit")
    private Integer unit;

    @OneToMany(mappedBy = "courseEntity")
    private List<TeacherEntity> teachers;

    @ManyToMany(mappedBy = "course")
    private List<StudentEntity> studentEntities = new ArrayList<>();

    @OneToMany(mappedBy = "courseEntity")
    private List<ExamEntity> examEntities = new ArrayList<>();

}