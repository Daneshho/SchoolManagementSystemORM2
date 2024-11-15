package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.Embeddable;
@ToString
@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private String country;
    private String city;
    private String street;
    private String zipCode;
}
