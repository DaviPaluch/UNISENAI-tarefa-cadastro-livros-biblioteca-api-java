package br.com.davipaluch.gestao_vagas.modules.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.davipaluch.gestao_vagas.modules.book.entities.BookEntity;
import br.com.davipaluch.gestao_vagas.modules.book.useCases.createBook.CreateBookUseCase;

@RestController
@RequestMapping("/book")
public class CreateBookController {

  @Autowired
  private CreateBookUseCase createBookUseCase;

  @PostMapping()
  public ResponseEntity<Object> postMethodName(@Valid @RequestBody BookEntity bookEntity) {

    try {
      var entity = this.createBookUseCase.execute(bookEntity);
      return ResponseEntity.ok().body(entity);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
