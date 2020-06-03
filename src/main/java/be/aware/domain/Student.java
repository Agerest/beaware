package be.aware.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Data
@Table(name = "student")
public class Student extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    private Image photo;

    @OneToOne
    private User user;

    public Student(String firstName,
                   String lastName,
                   Image photo,
                   User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
        this.user = user;
    }
}
