package br.clebersimm.projetoteste.service;

import java.util.Collection;

import br.clebersimm.projetoteste.domain.Bookmark;

public interface BookmarkService {
    Collection<Bookmark> list();
    Bookmark create(Bookmark bookmark);
}
