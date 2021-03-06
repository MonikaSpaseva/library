package app.library.web.rest;

import app.library.core.service.AuthorService;
import app.library.web.rest.model.AuthorDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping
  public List<AuthorDto> getAllAuthors() {
    return authorService.getAllAuthors();
  }
}
