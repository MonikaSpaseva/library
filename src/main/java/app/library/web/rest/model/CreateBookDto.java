package app.library.web.rest.model;

import app.library.core.model.BookType;

import java.util.UUID;

public class CreateBookDto {

  private String title;
  private String isbn;
  private int yearPublished;
  private UUID authorId;

  private CreatePrintCopyBookDto printCopy;
  private CreateEBookDto eBookDto;

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

  public UUID getAuthorId() {
    return authorId;
  }

  public void setAuthorId(UUID authorId) {
    this.authorId = authorId;
  }

  public CreatePrintCopyBookDto getPrintCopy() {
    return printCopy;
  }

  public void setPrintCopy(CreatePrintCopyBookDto printCopy) {
    this.printCopy = printCopy;
  }

  public CreateEBookDto geteBookDto() {
    return eBookDto;
  }

  public void seteBookDto(CreateEBookDto eBookDto) {
    this.eBookDto = eBookDto;
  }
}
