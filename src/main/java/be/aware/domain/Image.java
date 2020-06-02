package be.aware.domain;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;

@Entity
@Data
@Table(name = "image")
public class Image extends AbstractEntity {

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(columnDefinition = "bytea")
    private byte[] photo;

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

    public String getEncodedPhoto() {
        byte[] encodedImage = Base64.getEncoder().encode(this.photo);
        return new String(encodedImage, StandardCharsets.UTF_8);
    }
}
