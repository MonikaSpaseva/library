package app.library.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public abstract class AbstractBook {

  private UUID id;
  private String title;
  private String isbn;
  private int yearPublished;
  private BookType bookType;
  @JsonIgnore
  private Author author;

  public AbstractBook(String title, String isbn, int yearPublished, BookType bookType, Author author, UUID id) {
    this.title = title;
    this.isbn = isbn;
    this.yearPublished = yearPublished;
    this.bookType = bookType;
    this.author = author;
    this.id = id;
  }

  public AbstractBook(String title, String isbn, int yearPublished, BookType bookType, Author author) {
    this.title = title;
    this.isbn = isbn;
    this.yearPublished = yearPublished;
    this.bookType = bookType;
    this.author = author;
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  public BookType getBookType() {
    return bookType;
  }

  public Author getAuthor() {
    return author;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setYearPublished(int yearPublished) {
    this.yearPublished = yearPublished;
  }

  public void setBookType(BookType bookType) {
    this.bookType = bookType;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
