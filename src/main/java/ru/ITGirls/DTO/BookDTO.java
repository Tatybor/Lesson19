package ru.ITGirls.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookDTO {

    private Long id;
    private String name;
   // private String genre;
   private List <AuthorDTO> authors;

}





