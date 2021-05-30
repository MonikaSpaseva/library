package app.library.web.rest;

import app.library.core.model.AbstractBook;
import app.library.core.model.Author;
import app.library.integration.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExercisesController {

  private final StorageService storageService;

  public ExercisesController(StorageService storageService) {
    this.storageService = storageService;
  }

  @GetMapping("/get-all-books-by-publishing-year")
  public List<AbstractBook> getAllBooksByPublishingYear() {
    return storageService.getAllBooksOrderedByPublishingYear();
  }

  @GetMapping("/get-all-books-from-author-whose-last-name-starts-with")
  public List<AbstractBook> getAllBooksByPublishingYear(@RequestParam("q") char q) {
    return storageService.getAllBooksByAuthorWhoseLastNameStarts(q);
  }
  @GetMapping("/get-all-authors-for-which-there-are-books-from-the-same-decade-he-was-born")
  public List<Author> getAllAuthorsDecade() {
    return storageService.getAllAuthorsThatHaveBooksInTheDecadeWhenAuthorWasBorn();
  }

  @GetMapping("/get-all-authors-with-more-than-three-books")
  public List<Author> getAllAuthorsWithMoreThanThreeBooks() {
    return storageService.getAllAuthorsThatHaveMoreThanThreeBooks();
  }

  @GetMapping("/oldest-and-newest-book")
  public List<AbstractBook> getOldestAndNewestBook() {
    return storageService.getOldestAndNewestBook();
  }


}
