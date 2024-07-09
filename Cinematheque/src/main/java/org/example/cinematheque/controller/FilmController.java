package org.example.cinematheque.controller;

import org.example.cinematheque.dto.FilmDtoGet;
import org.example.cinematheque.dto.FilmDtoPost;
import org.example.cinematheque.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalogue/films")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("")
    public ResponseEntity<List<FilmDtoGet>> getAll() {
        return ResponseEntity.ok(filmService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<FilmDtoGet> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(filmService.getById(id));
    }

    @GetMapping("director/{directorId}")
    public ResponseEntity<List<FilmDtoGet>> getByDirectorId(@PathVariable("directorId") Long directorId) {
        return ResponseEntity.ok(filmService.findByDirectorId(directorId));
    }

    @PostMapping("")
    public ResponseEntity<FilmDtoGet> createFilm(@RequestBody FilmDtoPost filmDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.create(filmDtoPost));
    }

    @PutMapping("{id}")
    public ResponseEntity<FilmDtoGet> updateFilm(@PathVariable("id") Long id, @RequestBody FilmDtoPost filmDtoPost) {
        return ResponseEntity.ok(filmService.update(id, filmDtoPost));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFilm(@PathVariable("id") Long id) {
        filmService.delete(id);
        return ResponseEntity.ok("Film with id: " + id + " is deleted");
    }
}
