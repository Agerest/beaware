package be.aware.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@Table(name = "channel")
public class Channel extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(columnDefinition = "bytea")
    private byte[] photo;

    @OneToMany
    private List<Message> messages;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "date_created")
    private Instant dateCreated = Instant.now();

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

    @LastModifiedDate
    @Column(name = "date_modified")
    private Instant dateModified;

    @NotNull
    @Column(name = "deleted")
    private Boolean deleted = false;

    public Channel(String name, byte[] photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getEncodedPhoto() {
        byte[] encodedImage = Base64.getEncoder().encode(this.photo);
        return new String(encodedImage, StandardCharsets.UTF_8);
    }
}
