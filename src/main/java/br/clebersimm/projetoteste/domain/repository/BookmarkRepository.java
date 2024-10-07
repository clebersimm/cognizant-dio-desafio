package br.clebersimm.projetoteste.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.clebersimm.projetoteste.domain.model.BookmarkEntity;

@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkEntity, String> {

}
