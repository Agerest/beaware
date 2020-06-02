package be.aware.domain;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(columnDefinition = "bytea")
    private byte[] photo;

    @OneToOne
    private User user;

    public String getEncodedPhoto() {
        byte[] encodedImage = Base64.getEncoder().encode(this.photo);
        return new String(encodedImage, StandardCharsets.UTF_8);
    }
}
