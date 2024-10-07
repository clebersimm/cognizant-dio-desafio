package br.clebersimm.projetoteste.controller;

public record BookmarkOutput(
    String id,
    String url,
    String description,
    String tags,
    String createdAt
) {

}
