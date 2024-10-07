package br.clebersimm.projetoteste.service;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.clebersimm.projetoteste.domain.Bookmark;
import br.clebersimm.projetoteste.domain.model.BookmarkEntity;
import br.clebersimm.projetoteste.domain.repository.BookmarkRepository;

@Service
public class BookmarkServiceImpl implements BookmarkService {
    
    private final BookmarkRepository bookmarkRepository;
    
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        Objects.requireNonNull(bookmarkRepository,"Ocorreu um erro ao inicial bookmarkService: Repository null");
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public Collection<Bookmark> list() {
        final var entities = bookmarkRepository.findAll();
        final var bookmarks = entities.stream().map(tmp -> tmp.toDomain()).collect(Collectors.toList());
        return bookmarks;
    }

    @Override
    public Bookmark create(Bookmark bookmark) {
        final var entity = BookmarkEntity.fromDomain(bookmark);
        final var newBookmarkEntity = this.bookmarkRepository.save(entity);
        final var newBookmark = newBookmarkEntity.toDomain();
        return newBookmark;
    }

}
