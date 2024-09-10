package br.com.davipaluch.gestao_vagas.modules.book.useCases.getBook;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.davipaluch.gestao_vagas.modules.book.entities.BookEntity;
import br.com.davipaluch.gestao_vagas.modules.book.repositories.BookRepository;

@Service
public class GetBookUseCase {

  @Autowired
  private BookRepository bookRepository;

  public List<BookEntity> listBooks(String title, String author) {
    return bookRepository.findBooks(title, author);
  }
}