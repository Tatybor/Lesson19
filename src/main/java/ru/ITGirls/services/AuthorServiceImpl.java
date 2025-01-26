package ru.ITGirls.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.ITGirls.DTO.AuthorDTO;
import ru.ITGirls.DTO.BookDTO;
import ru.ITGirls.entity.Author;
import ru.ITGirls.repository.AuthorRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public Author addNewAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return convertAuthorToDTO(author);
    }

    private AuthorDTO convertAuthorToDTO(Author author) {

        List<BookDTO> bookDtoList = author.getBooks()
                .stream()
                .map(book -> BookDTO.builder()
                        //.genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build()
                ).toList();

        return AuthorDTO.builder()
                .books(bookDtoList)
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }

    @Override
    public AuthorDTO getAuthorBySurnameV1(String surname) {
        Author author = authorRepository.findAuthorBySurname(surname).orElseThrow();
        return convertAuthorToDTO(author);
    }

    @Override
    public AuthorDTO getAuthorBySurnameV2(String surname) {
        Author author = authorRepository.findAuthorBySurnameV2(surname).orElseThrow();
        return convertAuthorToDTO(author);
    }

    @Override
    public AuthorDTO getAuthorBySurnameV3(String surname) {
        Specification<Author> specification = Specification.where(new Specification<Author>() {
            @Override
            public Predicate toPredicate(Root<Author> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                return cb.equal(root.get("surname"), surname);
            }
        });
        Author author = authorRepository.findOne(specification).orElseThrow();
        return convertAuthorToDTO(author);
    }
}









