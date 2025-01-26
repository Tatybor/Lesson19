package ru.ITGirls.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ITGirls.DTO.BookDTO;
import ru.ITGirls.entity.Book;
import ru.ITGirls.services.BookServiceImpl;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookServiceImpl bookServiceImpl;

    @PostMapping ("/books")
    public Book addNewBook(@RequestBody Book book) {
        return bookServiceImpl.addNewBook (book);
    }

    @GetMapping("/books/{id}")
    BookDTO getBookById(@PathVariable("id") Long id) {
        return bookServiceImpl.getBookById(id);
    }
}




