package ru.ITGirls.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ITGirls.services.AuthorServiceImpl;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorServiceImpl authorServiceImpl;

    @GetMapping("/v1/authors")
    public ResponseEntity<?> getAuthorBySurnameV1(@RequestParam("surname") String surname) {
        try {
            return ResponseEntity.ok(authorServiceImpl.getAuthorBySurnameV1(surname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no such author in db");
        }
    }

    @GetMapping("/v2/authors")
    public ResponseEntity getAuthorBySurnameV2(@RequestParam("surname") String surname) {
        try {
            return ResponseEntity.ok(authorServiceImpl.getAuthorBySurnameV2(surname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no such author in db");
        }
    }

    @GetMapping("/v3/authors")
    public ResponseEntity getAuthorBySurnameV3(@RequestParam("surname") String surname) {
        try {
            return ResponseEntity.ok(authorServiceImpl.getAuthorBySurnameV3(surname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no such author in db");
        }
    }
}


