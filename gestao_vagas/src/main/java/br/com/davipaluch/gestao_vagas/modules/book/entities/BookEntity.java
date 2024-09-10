package br.com.davipaluch.gestao_vagas.modules.book.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "book")
@Data
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @NotBlank(message = "O título do livro não pode ser vazio")
  @Length(min = 1, max = 255, message = "O título deve ter entre 1 e 255 caracteres")
  private String title;

  @NotBlank(message = "O nome do autor não pode ser vazio")
  @Length(min = 1, max = 255, message = "O nome do autor deve ter entre 1 e 255 caracteres")
  private String author;

  @NotBlank(message = "O ISBN não pode ser vazio")
  private String isbn;

  @PastOrPresent(message = "A data de publicação não pode ser futura")
  private LocalDate publicationDate;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
