package app.library.core.model;

import java.util.UUID;

public class Author {

  private UUID id;
  private String firstName;
  private String lastName;
  private int yearOfBirth;

  public Author(String firstName, String lastName, int yearOfBirth, UUID id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.yearOfBirth = yearOfBirth;
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public UUID getId() {
    return id;
  }
}
