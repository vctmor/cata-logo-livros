package com.amoreira.cata_logo_livros.Repository;

import com.amoreira.cata_logo_livros.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
