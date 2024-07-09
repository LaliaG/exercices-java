package org.example.cinematheque.controller;

import org.example.cinematheque.dto.DirectorDtoGet;
import org.example.cinematheque.dto.DirectorDtoPost;
import org.example.cinematheque.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/catalogue/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping("")
    public ResponseEntity<List<DirectorDtoGet>> getAll() {
        return ResponseEntity.ok(directorService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<DirectorDtoGet> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(directorService.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<DirectorDtoGet> createDirector(@RequestBody DirectorDtoPost directorDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(directorService.create(directorDtoPost));
    }

    @PutMapping("{id}")
    public ResponseEntity<DirectorDtoGet> updateDirector(@PathVariable("id") Long id, @RequestBody DirectorDtoPost directorDtoPost) {
        return ResponseEntity.ok(directorService.update(id, directorDtoPost));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDirector(@PathVariable("id") Long id) {
        directorService.delete(id);
        return ResponseEntity.ok("Director with id: " + id + " is deleted");
    }
}
