package app.library.web.rest.model;

import app.library.core.model.Author;
import app.library.core.model.BookType;

import java.util.UUID;

public class BookDto {

  private UUID id;
  private String title;
  private String isbn;
  private int yearPublished;
  private BookType bookType;
  private UUID authorId;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getAuthorId() {
    return authorId;
  }

  public void setAuthorId(UUID authorId) {
    this.authorId = authorId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  public void setYearPublished(int yearPublished) {
    this.yearPublished = yearPublished;
  }

  public BookType getBookType() {
    return bookType;
  }

  public void setBookType(BookType bookType) {
    this.bookType = bookType;
  }
}
