package br.com.davipaluch.gestao_vagas.modules.book.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.davipaluch.gestao_vagas.modules.book.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
  Optional<BookEntity> findByTitleOrIsbn(String title, String isbn);

  @Query("SELECT b FROM book b WHERE "
      + "(:title IS NULL OR b.title LIKE %:title%) AND "
      + "(:author IS NULL OR b.author LIKE %:author%)")
  List<BookEntity> findBooks(@Param("title") String title, @Param("author") String author);
}
