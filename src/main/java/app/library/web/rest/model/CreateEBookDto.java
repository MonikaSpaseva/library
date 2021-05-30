package app.library.web.rest.model;

import app.library.core.model.EBookFormat;

public class CreateEBookDto {

  private EBookFormat format;
  private double sizeInMB;

  public EBookFormat getFormat() {
    return format;
  }

  public void setFormat(EBookFormat format) {
    this.format = format;
  }

  public double getSizeInMB() {
    return sizeInMB;
  }

  public void setSizeInMB(double sizeInMB) {
    this.sizeInMB = sizeInMB;
  }
}
