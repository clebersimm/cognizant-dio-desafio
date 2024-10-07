package br.clebersimm.projetoteste.controller;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.clebersimm.projetoteste.domain.Bookmark;
import br.clebersimm.projetoteste.service.BookmarkService;


@RestController
@RequestMapping("/bookmarks")
public class BookmarkController implements BookmarkApi {

    private BookmarkService bookmarkService;
    
    public BookmarkController(BookmarkService bookmarkService) {
        Objects.requireNonNull(bookmarkService,"Ocorreu um erro ao inicial bookmarkController: Service null");
        this.bookmarkService = bookmarkService;
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookmarkOutput> create(@RequestBody BookmarkInput input) {
        final var bookmark = Bookmark.with(input.url(), input.description(), input.tags());
        final var newBookmark = bookmarkService.create(bookmark);
        final var output = domainToOutput(newBookmark);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(output.id()).toUri();
        return ResponseEntity.created(location).body(output);
    }

    @Override
    @GetMapping
    public ResponseEntity<?> list() {
        final var bookmarks = bookmarkService.list();
        final var output = bookmarks.stream().map(bookmark -> domainToOutput(bookmark)).collect(Collectors.toList());
        return ResponseEntity.ok().body(output);
    }

    private BookmarkOutput domainToOutput(final Bookmark bookmark){
        final var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final var creationDateFormatted = formatter.format(bookmark.getCreatedAt());
        final var output = new BookmarkOutput(bookmark.getId(), bookmark.getUrl(), bookmark.getDescription(), bookmark.getTags(), creationDateFormatted);
        return output;
    }

}
