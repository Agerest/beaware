package be.aware.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@NoArgsConstructor
@Entity
@Data
@Table(name = "message")
@EntityListeners(AuditingEntityListener.class)
public class Message extends AbstractEntity {

    @OneToOne
    private Student owner;

    @Column(name = "message")
    private String message;

    @OneToOne
    private Image image;

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

    public Message(Student owner,
                   String message,
                   Image image) {
        this.owner = owner;
        this.image = image;
        this.message = message;
    }
}
