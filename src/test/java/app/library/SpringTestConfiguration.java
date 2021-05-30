package app.library;

import app.library.core.model.AbstractBook;
import app.library.integration.StorageService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@TestConfiguration
public class SpringTestConfiguration {

  @Bean
  public StorageService storageService() {
    List<AbstractBook> initialBooks = StorageService.createInitialBooks();
    return new StorageService(initialBooks);
  }
}
