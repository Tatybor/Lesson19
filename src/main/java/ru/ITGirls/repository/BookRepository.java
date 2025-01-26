package ru.ITGirls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ITGirls.entity.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

}
