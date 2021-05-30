package app.library.web.rest.model;

public class CreatePrintCopyBookDto {

  private int numOfPages;
  private double weightInKg;

  public int getNumOfPages() {
    return numOfPages;
  }

  public void setNumOfPages(int numOfPages) {
    this.numOfPages = numOfPages;
  }

  public double getWeightInKg() {
    return weightInKg;
  }

  public void setWeightInKg(double weightInKg) {
    this.weightInKg = weightInKg;
  }
}
