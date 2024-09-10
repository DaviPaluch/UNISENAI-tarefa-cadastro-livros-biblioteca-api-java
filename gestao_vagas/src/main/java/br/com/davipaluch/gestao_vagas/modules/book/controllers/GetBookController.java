package br.com.davipaluch.gestao_vagas.modules.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.davipaluch.gestao_vagas.modules.book.entities.BookEntity;
import br.com.davipaluch.gestao_vagas.modules.book.useCases.getBook.GetBookUseCase;

@RestController
@RequestMapping("/books")
public class GetBookController {

  @Autowired
  private GetBookUseCase getBookUseCase;

  @GetMapping
  public List<BookEntity> listBooks(
      @RequestParam(value = "title", required = false) String title,
      @RequestParam(value = "author", required = false) String author) {
    return getBookUseCase.listBooks(title, author);
  }
}
