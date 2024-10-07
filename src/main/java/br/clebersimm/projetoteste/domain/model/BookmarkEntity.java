package br.clebersimm.projetoteste.domain.model;

import java.time.LocalDateTime;

import br.clebersimm.projetoteste.domain.Bookmark;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Table(name = "bookmarks")
@Entity(name = "bookmarks")
public class BookmarkEntity {

    @Id
    private String id;
    @Column(unique = true)
    private String url;
    private String description;
    private String tags;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    public BookmarkEntity(){}

    private BookmarkEntity(String id, String url, String description, String tags,
        LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt
    ){
        this.id = id;
        this.url = url;
        this.description = description;
        this.tags = tags;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public static BookmarkEntity fromDomain(final Bookmark bookmark){
        return new BookmarkEntity(
            bookmark.getId(),
            bookmark.getUrl(),
            bookmark.getDescription(),
            bookmark.getTags(),
            bookmark.getCreatedAt(),
            bookmark.getUpdatedAt(),
            bookmark.getDeletedAt()
        );
    }

    public Bookmark toDomain(){
        return Bookmark.load(
            this.id,
            this.url,
            this.description,
            this.tags,
            this.createdAt, 
            this.updatedAt, 
            this.createdAt
        );
    }
}
