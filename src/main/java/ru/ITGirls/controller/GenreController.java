package ru.ITGirls.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ITGirls.entity.Genre;
import ru.ITGirls.services.GenreServiceImpl;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreServiceImpl genreServiceImpl;

    @PostMapping("/genres")
    public Genre addNewGenre(@RequestBody Genre genre) {
        return genreServiceImpl.addNewGenre(genre);
    }

    @GetMapping("/genres/{id}")
    public ResponseEntity<?> getGenreById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(genreServiceImpl.getGenreById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no such genre in DB");
        }
    }
}








