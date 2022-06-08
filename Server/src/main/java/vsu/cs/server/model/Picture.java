package vsu.cs.server.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, insertable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "creator", referencedColumnName = "login")
    private User creator;

    @Column(nullable = false, name = "url")
    private String url;

    @Column(nullable = false, name = "creation_date")
    private Date creationDate;

    @Column(nullable = false, name = "is_public")
    private Boolean isPublic;

    @ManyToOne
    @JoinColumn(name = "source", referencedColumnName = "id")
    private Picture source;

    public Picture() {
    }

    public Picture(User creator, String url, Date creationDate, Boolean isPublic) {
        this.creator = creator;
        this.url = url;
        this.creationDate = creationDate;
        this.isPublic = isPublic;
        this.source = null;
    }

    public Picture(User creator, String url, Date creationDate, Boolean isPublic, Picture source) {
        this.creator = creator;
        this.url = url;
        this.creationDate = creationDate;
        this.isPublic = isPublic;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Picture getSource() {
        return source;
    }

    public void setSource(Picture source) {
        this.source = source;
    }
}
