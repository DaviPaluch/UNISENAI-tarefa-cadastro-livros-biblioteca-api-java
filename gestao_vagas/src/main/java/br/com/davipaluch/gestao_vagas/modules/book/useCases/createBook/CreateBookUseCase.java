package br.com.davipaluch.gestao_vagas.modules.book.useCases.createBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.davipaluch.gestao_vagas.modules.book.entities.BookEntity;
import br.com.davipaluch.gestao_vagas.modules.book.repositories.BookRepository;

@Service
public class CreateBookUseCase {

  @Autowired
  private BookRepository bookRepository;

  public BookEntity execute(BookEntity bookEntity) {
    this.bookRepository.findByTitleOrIsbn(bookEntity.getTitle(), bookEntity.getIsbn())
        .ifPresent((book) -> {
          throw new RuntimeException("Livro já existente no sistema");
        });

    return this.bookRepository.save(bookEntity);
  }
}
