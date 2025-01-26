package ru.ITGirls.services;

import ru.ITGirls.DTO.BookDTO;

public interface BookService {
    BookDTO getBookById (Long id);
}
