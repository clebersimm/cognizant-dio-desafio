package br.clebersimm.projetoteste.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Bookmark {

    private String id;
    private String url;
    private String description;
    private String tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private Bookmark(String id, 
        String url, 
        String description, 
        String tags,
        LocalDateTime createdAt,
        LocalDateTime updateAt,
        LocalDateTime deletedAt
        ){

        this.id = id;
        this.url = url;
        this.description = description;
        this.tags = tags;
        this.createdAt = createdAt;
        this.updatedAt = updateAt;
        this.deletedAt = deletedAt;
    }

    public static Bookmark with(final String url, final String description, final String tags){
        final var id = UUID.randomUUID().toString();
        Objects.requireNonNull(url,"URL não pode ser vazia");
        Objects.requireNonNull(description,"Description não pode ser vazia");
        Objects.requireNonNull(tags,"TAGS não pode ser vazia");
        return new Bookmark(id, url, description, tags, LocalDateTime.now(), null, null);
    }

    public static Bookmark load(final String id, final String url, final String description, final String tags,
        final LocalDateTime createdAt, final LocalDateTime updateAt,
        final LocalDateTime deletedAt
    ){
        return new Bookmark(id, url, description, tags, LocalDateTime.now(), null, null);
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getTags() {
        return tags;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }    

}
