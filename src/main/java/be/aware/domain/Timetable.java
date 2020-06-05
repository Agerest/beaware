package be.aware.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@NoArgsConstructor
@Entity
@Data
@Table(name = "timetable")
@EntityListeners(AuditingEntityListener.class)
public class Timetable extends AbstractEntity {

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private String type;

    @Column(name = "classroom")
    private String classroom;

    @Column(name = "teacher")
    private String teacher;

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

    public Timetable(String date,
                     String type,
                     String classroom,
                     String teacher) {
        this.date = date;
        this.type = type;
        this.classroom = classroom;
        this.teacher = teacher;
    }
}
