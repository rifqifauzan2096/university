package id.co.university.common.model;


import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class EntityBase implements Serializable {

    private final static long serialVersionUID = 8996799355658904224L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Column(name = "deleted")
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "EntityBase{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
