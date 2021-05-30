package app.library;

import app.library.core.model.AbstractBook;
import app.library.integration.StorageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LibraryApplication {

  public static void main(String[] args) {
    SpringApplication.run(LibraryApplication.class, args);
  }

  @Bean
  public StorageService storageService() {
    List<AbstractBook> initialBooks = StorageService.createInitialBooks();
    return new StorageService(initialBooks);
  }

}
