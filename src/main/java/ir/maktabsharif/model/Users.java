package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@ToString
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Users extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_code", unique = true)
    private String nationalCode;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

//    @Override
//    public String toString() {
//        return "Users{" +
//                "firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", nationalCode='" + nationalCode + '\'' +
//                ", dob=" + dob +
//                ", gender=" + gender +
//                ", address=" + address +
//                '}';
//    }
}
