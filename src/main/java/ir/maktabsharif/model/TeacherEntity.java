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
@Table(name = "teacher")
@NamedQuery(name = "TeacherEntity.findByFirstname", query = "select t from TeacherEntity t where firstName = ?1")

public class TeacherEntity extends Users {

    @ManyToOne
    @JoinColumn(name = "fk_course")
    private CourseEntity courseEntity;

    @Embedded
    private Address address;

    @ManyToMany
    private List<StudentEntity> studentEntities = new ArrayList<>();
}