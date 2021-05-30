package app.library.core.service;

import app.library.core.model.AbstractBook;
import app.library.core.model.Author;
import app.library.integration.StorageService;
import app.library.web.rest.model.AuthorDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

  private final StorageService storageService;

  public AuthorService(StorageService storageService) {
    this.storageService = storageService;
  }

  public List<AuthorDto> getAllAuthors() {
    Map<Author, List<AbstractBook>> authors = storageService.getAllBooks().stream().collect(Collectors.groupingBy(AbstractBook::getAuthor));
    return authors.entrySet().stream().map(a -> {
      Author author = a.getKey();
      List<AbstractBook> booksFromAuthor = a.getValue();
      AuthorDto authorDto = new AuthorDto();
      authorDto.setFirstName(author.getFirstName());
      authorDto.setLastName(author.getLastName());
      authorDto.setYearOfBirth(author.getYearOfBirth());
      authorDto.setBooks(booksFromAuthor);
      return authorDto;
    }).collect(Collectors.toList());
  }
}
