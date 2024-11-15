package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class StudentEntity extends Users {

    private Double gpu;

    @ManyToMany
    @JoinTable(
            name = "j_student_course",
            joinColumns = {@JoinColumn(name = "fk_student")},
            inverseJoinColumns = {@JoinColumn(name = "fk_course")}
    )
    private List<CourseEntity> course = new ArrayList<>();

    @OneToMany(mappedBy = "studentEntity", fetch = FetchType.EAGER)
    private List<ExamEntity> examEntities = new ArrayList<>();

}