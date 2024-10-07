package br.clebersimm.projetoteste.controller;

import org.springframework.http.ResponseEntity;

public interface BookmarkApi {

    ResponseEntity<?> create(BookmarkInput input);
    ResponseEntity<?> list();
}
