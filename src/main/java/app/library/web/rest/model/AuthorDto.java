package app.library.web.rest.model;

import app.library.core.model.AbstractBook;

import java.util.List;

public class AuthorDto {

  private String firstName;
  private String lastName;
  private int yearOfBirth;
  private List<AbstractBook> books;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }

  public List<AbstractBook> getBooks() {
    return books;
  }

  public void setBooks(List<AbstractBook> books) {
    this.books = books;
  }
}
