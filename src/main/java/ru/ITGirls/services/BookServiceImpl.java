package ru.ITGirls.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ITGirls.DTO.AuthorDTO;
import ru.ITGirls.DTO.BookDTO;
import ru.ITGirls.entity.Book;
import ru.ITGirls.repository.BookRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    public Book addNewBook;
    public Book addNewBook (Book book){
        return bookRepository.save(book);
    }

    @Override
    public BookDTO getBookById (Long id){
        Book book = bookRepository.findById(id).orElseThrow();
        return convertToDTO(book);
    }

    private BookDTO convertToDTO (Book book){

        List<AuthorDTO> authorDtoList = book.getAuthors()
                .stream()
                .map(author -> AuthorDTO.builder()
                        .surname(author.getSurname())
                        .name(author.getName())
                        .id(author.getId())
                        .build()
                ).toList();

        return BookDTO.builder()
                    .authors(authorDtoList)
                    .id(book.getId())
                    .name(book.getName())
                    //.genre(book.getGenre().getName())
                    .build();
            }

}
