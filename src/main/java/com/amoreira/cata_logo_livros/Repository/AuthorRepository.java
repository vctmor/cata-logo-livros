package com.amoreira.cata_logo_livros.Repository;

import com.amoreira.cata_logo_livros.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
