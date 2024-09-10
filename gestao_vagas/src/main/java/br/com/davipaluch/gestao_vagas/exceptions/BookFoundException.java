package br.com.davipaluch.gestao_vagas.exceptions;

public class BookFoundException extends RuntimeException {
  public BookFoundException() {
    super("Livro já existente no sistema");
  }
}
