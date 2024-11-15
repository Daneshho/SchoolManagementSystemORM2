package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@ToString
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "exam")
public class ExamEntity extends BaseEntity {

    @Column(name = "exam_title")
    private String title;

    @Column(name = "exam_unit")
    private Integer unit;

    @Temporal(TemporalType.DATE)
    @Column(name = "exam_date")
    private Date date;

    @Column(name = "total_grade")
    private Double totalGrade;

    @ManyToOne
    @JoinColumn(name = "fk_course")
    private CourseEntity courseEntity;

    @ManyToOne
    private StudentEntity studentEntity;
}
