package ru.ITGirls.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ITGirls.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
