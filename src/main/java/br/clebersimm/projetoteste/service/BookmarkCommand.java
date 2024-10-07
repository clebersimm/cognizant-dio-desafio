package br.clebersimm.projetoteste.service;

public record BookmarkCommand(
    String url,
    String description,
    String tags
) {

}
