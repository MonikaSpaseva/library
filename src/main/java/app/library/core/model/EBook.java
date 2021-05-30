package app.library.core.model;

import java.util.UUID;

public class EBook extends AbstractBook {

  private EBookFormat format;
  private double sizeInMB;

  public EBook(String title, String isbn, int yearPublished, Author author, EBookFormat format, double sizeInMB) {
    super(title, isbn, yearPublished, BookType.ELECTRONIC, author);
    this.format = format;
    this.sizeInMB = sizeInMB;
  }

  public EBook(String title, String isbn, int yearPublished, Author author, EBookFormat format, double sizeInMB, UUID id) {
    super(title, isbn, yearPublished, BookType.ELECTRONIC, author, id);
    this.format = format;
    this.sizeInMB = sizeInMB;
  }


  public void setFormat(EBookFormat format) {
    this.format = format;
  }

  public void setSizeInMB(double sizeInMB) {
    this.sizeInMB = sizeInMB;
  }

  public EBookFormat getFormat() {
    return format;
  }

  public double getSizeInMB() {
    return sizeInMB;
  }
}
