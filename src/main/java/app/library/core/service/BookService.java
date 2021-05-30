package app.library.core.service;

import app.library.core.model.*;
import app.library.integration.StorageService;
import app.library.web.rest.model.CreateBookDto;
import app.library.web.rest.model.CreateEBookDto;
import app.library.web.rest.model.CreatePrintCopyBookDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {

  private final StorageService storageService;

  public BookService(StorageService storageService) {
    this.storageService = storageService;
  }

  public AbstractBook createBook(CreateBookDto createBookDto) {
    AbstractBook newBook;
    Author author = storageService.getAllAuthors().stream().filter(a -> a.getId().equals(createBookDto.getAuthorId())).findFirst().orElseThrow();
    if (createBookDto.getPrintCopy() != null) {

      newBook = new PrintCopyBook(createBookDto.getTitle(), createBookDto.getIsbn(),
        createBookDto.getYearPublished(),
        author,
        createBookDto.getPrintCopy().getNumOfPages(),
        createBookDto.getPrintCopy().getWeightInKg());
    } else {
      newBook = new EBook(createBookDto.getTitle(), createBookDto.getIsbn(),
        createBookDto.getYearPublished(),
        author,
        createBookDto.geteBookDto().getFormat(),
        createBookDto.geteBookDto().getSizeInMB());
    }
    storageService.addBook(newBook);

    return newBook;
  }

  public AbstractBook editBook(UUID id, CreateBookDto book) {
    AbstractBook bookById = storageService.getBookById(id);
    Author author = storageService.getAllAuthors().stream().filter(a -> a.getId().equals(book.getAuthorId())).findFirst().orElseThrow();
    CreatePrintCopyBookDto printCopy = book.getPrintCopy();
    CreateEBookDto eBook = book.geteBookDto();
    AbstractBook editedBook = null;
    if (printCopy != null) {
      if (bookById.getBookType().equals(BookType.PHYSICAL)) {
        PrintCopyBook printCopyBook = (PrintCopyBook) bookById;
        printCopyBook.setTitle(book.getTitle());
        printCopyBook.setIsbn(book.getIsbn());
        printCopyBook.setAuthor(author);
        printCopyBook.setYearPublished(book.getYearPublished());
        printCopyBook.setWeightInKg(printCopy.getWeightInKg());
        printCopyBook.setNumOfPages(printCopy.getNumOfPages());
        editedBook = printCopyBook;
      } else if (bookById.getBookType().equals(BookType.ELECTRONIC)) {
        PrintCopyBook newPrintCopy = new PrintCopyBook(book.getTitle(), book.getIsbn(), book.getYearPublished(), author, printCopy.getNumOfPages(), printCopy.getWeightInKg(), id);
        storageService.deleteBookById(id);
        storageService.addBook(newPrintCopy);
        editedBook = newPrintCopy;
      }
    } else if (eBook != null) {
      if (bookById.getBookType().equals(BookType.PHYSICAL)) {
        EBook newEbook = new EBook(book.getTitle(), book.getIsbn(), book.getYearPublished(), author, eBook.getFormat(), eBook.getSizeInMB(), id);
        storageService.deleteBookById(id);
        storageService.addBook(newEbook);
        editedBook = newEbook;
      } else if (bookById.getBookType().equals(BookType.ELECTRONIC)) {
        EBook eBookById = (EBook) bookById;
        eBookById.setTitle(book.getTitle());
        eBookById.setIsbn(book.getIsbn());
        eBookById.setAuthor(author);
        eBookById.setYearPublished(book.getYearPublished());
        eBookById.setFormat(eBook.getFormat());
        eBookById.setSizeInMB(eBook.getSizeInMB());
        editedBook = eBookById;
      }
    }

    return editedBook;
  }
}
