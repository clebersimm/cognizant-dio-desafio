package br.clebersimm.projetoteste.controller;

public record BookmarkInput(
    String url,
    String description,
    String tags
) {

}
