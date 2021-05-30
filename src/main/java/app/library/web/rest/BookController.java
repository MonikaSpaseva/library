package app.library.web.rest;

import app.library.core.model.AbstractBook;
import app.library.core.service.BookService;
import app.library.integration.StorageService;
import app.library.web.rest.model.CreateBookDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

  private final StorageService storageService;
  private final BookService bookService;

  public BookController(StorageService storageService, BookService bookService) {
    this.storageService = storageService;
    this.bookService = bookService;
  }

  @GetMapping
  public List<AbstractBook> getAllBooks() {
    return storageService.getAllBooks();
  }

  @GetMapping("/{id}")
  public AbstractBook getBookById(@PathVariable UUID id) {
    return storageService.getAllBooks().stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
  }

  @PostMapping
  public AbstractBook addNewBook(@RequestBody CreateBookDto createBookDto) {
    return bookService.createBook(createBookDto);
  }

  @PutMapping("/{id}")
  public AbstractBook editBook(@PathVariable UUID id, @RequestBody CreateBookDto book) {
    return bookService.editBook(id, book);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable UUID id) {
    storageService.deleteBookById(id);
  }
}
