package be.aware.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@Table(name = "server")
public class Server extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToOne
    private Student owner;

    @OneToMany
    private List<Student> students;

    @OneToMany
    private List<Channel> channels;

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

    public Server(String name, Student owner) {
        this.name = name;
        this.owner = owner;
    }
}
