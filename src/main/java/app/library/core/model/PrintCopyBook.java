package app.library.core.model;

import java.util.UUID;

public class PrintCopyBook extends AbstractBook {
  private int numOfPages;
  private double weightInKg;

  public PrintCopyBook(String title, String isbn, int yearPublished, Author author, int numOfPages, double weightInKg, UUID id) {
    super(title, isbn, yearPublished, BookType.PHYSICAL, author, id);
    this.numOfPages = numOfPages;
    this.weightInKg = weightInKg;
  }

  public PrintCopyBook(String title, String isbn, int yearPublished, Author author, int numOfPages, double weightInKg) {
    super(title, isbn, yearPublished, BookType.PHYSICAL, author);
    this.numOfPages = numOfPages;
    this.weightInKg = weightInKg;
  }

  public void setNumOfPages(int numOfPages) {
    this.numOfPages = numOfPages;
  }

  public void setWeightInKg(double weightInKg) {
    this.weightInKg = weightInKg;
  }

  public int getNumOfPages() {
    return numOfPages;
  }

  public double getWeightInKg() {
    return weightInKg;
  }
}
