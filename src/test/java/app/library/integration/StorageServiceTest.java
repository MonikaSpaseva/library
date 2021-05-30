package app.library.integration;

import app.library.SpringTestConfiguration;
import app.library.core.model.AbstractBook;
import app.library.core.model.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@Import(SpringTestConfiguration.class)
public class StorageServiceTest {

  @Autowired
  private StorageService storageService;

  @Test
  public void shouldGetAllBooksOrderedByPublishingYear() {
    // given spring configuration

    // when
    List<AbstractBook> allBooksOrderedByPublishingYear = storageService.getAllBooksOrderedByPublishingYear();

    // then
    assertEquals(12, allBooksOrderedByPublishingYear.size());
    assertEquals("Dracula", allBooksOrderedByPublishingYear.get(0).getTitle());
    assertEquals("Gone Girl", allBooksOrderedByPublishingYear.get(allBooksOrderedByPublishingYear.size() - 1).getTitle());
  }

  @Test
  public void shouldGetAllBooksByAuthorLastNameStartingWith() {
    // given
    char input1 = 't';

    // when
    List<AbstractBook> books = storageService.getAllBooksByAuthorWhoseLastNameStarts(input1);

    // then
    assertEquals(4, books.size());

  }


  @Test
  public void shouldGetAllBooksByAuthorLastNameStartingWithUpperCase() {
    // given
    char input1 = 'T';

    // when
    List<AbstractBook> books = storageService.getAllBooksByAuthorWhoseLastNameStarts(input1);

    // then
    assertEquals(4, books.size());

  }


  @Test
  public void shouldGetAllAuthorsThatHaveBooksInTheSameDecadeThatTheyWereBorn() {
    // given spring configuration

    // when
    List<Author> authors = storageService.getAllAuthorsThatHaveBooksInTheDecadeWhenAuthorWasBorn();

    // then
    assertEquals(3, authors.size());

  }

  @Test
  public void shouldGetAllAuthorsWithMoreThanThreeBooks() {
    // given spring configuration

    // when
    List<Author> authors = storageService.getAllAuthorsThatHaveMoreThanThreeBooks();

    // then
    assertEquals(2, authors.size());

  }

  @Test
  public void shouldGetMinAndMaxBooks() {
    // given spring configuration

    // when
    List<AbstractBook> oldestAndNewestBook = storageService.getOldestAndNewestBook();

    // then
    assertEquals(2, oldestAndNewestBook.size());
    assertEquals("Dracula", oldestAndNewestBook.get(0).getTitle());
    assertEquals("Gone Girl", oldestAndNewestBook.get(1).getTitle());

  }
}