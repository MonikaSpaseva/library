package app.library.integration;

import app.library.core.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class StorageService {

  private List<AbstractBook> allBooks;

  public StorageService(List<AbstractBook> initialBooks) {
    this.allBooks = initialBooks;
  }

  public static List<AbstractBook> createInitialBooks() {

    List<AbstractBook> books = new ArrayList<>();
    Author author = new Author("Bram", "Stoker", 1847, UUID.fromString("562b87c6-c14f-11eb-8529-0242ac130003"));
    AbstractBook pc1 = new PrintCopyBook("Dracula", "222", 1897, author, 418, 0.53, UUID.fromString("10d82d43-e5f0-4f3a-9c14-918125b51bbb"));
    books.add(pc1);

    Author author1 = new Author("Ken", "Kesey", 1935, UUID.fromString("a58c9715-2251-4873-bf88-9b31fcad3c54"));
    AbstractBook pc2 = new PrintCopyBook("One Flew Over the Cuckoo's nest", "223", 1962, author1, 320, 0.39, UUID.fromString("c4ca46c2-76a6-4078-b439-3ad87f8d347f"));
    books.add(pc2);

    Author author2 = new Author("Gaston", "Leroux", 1868, UUID.fromString("98f3d885-8b03-4196-bf97-43c2a6b6d2f2"));
    AbstractBook pc3 = new PrintCopyBook("The Phantom of the Opera", "224", 1909, author2, 145, 0.18, UUID.fromString("0d8e4546-47e8-4368-8458-5f2116ec6bd8"));
    books.add(pc3);

    Author author3 = new Author("Gillian", "Flynn", 1971, UUID.fromString("300ee8bc-7afc-4281-a3e7-c460da18ecbb"));
    AbstractBook ebook = new EBook("Gone Girl", "225", 2012, author3, EBookFormat.EPUB, 0.473, UUID.fromString("030eb42f-ee1b-476c-a21f-547ffb7a6a78"));
    books.add(ebook);

    Author author4 = new Author("John", "Tolkien", 1892, UUID.fromString("215888a0-66f8-4638-892f-335fc9baeb25"));
    AbstractBook pc4 = new PrintCopyBook("The Hobbit", "226", 1937, author4, 310, 0.38, UUID.fromString("1a96f2d5-78bd-4789-9a74-82cc41dfb97a"));
    books.add(pc4);
    AbstractBook pc5 = new PrintCopyBook("The Fellowship of the Ring", "227", 1954, author4, 423, 0.54, UUID.fromString("b7c6f409-9e72-44c0-9280-7a7cf3065737"));
    books.add(pc5);
    AbstractBook pc6 = new PrintCopyBook("The Two Towers", "228", 1954, author4, 352, 0.44, UUID.fromString("b7c6f409-9e72-44c0-9280-7a7cf3065737"));
    books.add(pc6);
    AbstractBook pc7 = new PrintCopyBook("The Return of the King", "229", 1955, author4, 416, 0.53, UUID.fromString("13aff006-97f5-4b0c-bcf2-fa4bc75c0f73"));
    books.add(pc7);

    Author author5 = new Author("Thomas", "Harris", 1940, UUID.fromString("f955985e-63b5-44a5-93a8-d310553114f6"));
    AbstractBook ebook1 = new EBook("Red Dragon", "230-1", 1999, author5, EBookFormat.PDF, 0.48, UUID.fromString("82d0a3dd-d13f-464a-a35e-41317a920b8d"));
    books.add(ebook1);
    AbstractBook pc8 = new PrintCopyBook("The Silence of the Lambs", "230-2", 1988, author5, 338, 0.40, UUID.fromString("84295239-8141-43de-9d2b-c97e78e1993d"));
    books.add(pc8);
    AbstractBook pc9 = new PrintCopyBook("Hannibal", "230-3", 1999, author5, 484, 0.61, UUID.fromString("b5463e61-abaf-424f-bf94-0a56c2ef8ba2"));
    books.add(pc9);
    AbstractBook ebook2 = new EBook("Black Sunday", "233", 1975, author5, EBookFormat.HTML5, 15.97, UUID.fromString("9c0342c2-e86d-4cd6-ab29-4f2e5a14d6f4"));
    books.add(ebook2);
    return books;
  }

  public List<AbstractBook> getAllBooksOrderedByPublishingYear() {
    return allBooks.stream()
      .sorted(Comparator.comparing(AbstractBook::getYearPublished)).collect(Collectors.toList());
  }

  public List<AbstractBook> getAllBooksByAuthorWhoseLastNameStarts(char character) {

    return allBooks.stream().filter(b -> {
      String lastName = b.getAuthor().getLastName().toUpperCase();
      return lastName.startsWith(String.valueOf(character).toUpperCase());
    }).collect(Collectors.toList());

  }

  public List<Author> getAllAuthorsThatHaveBooksInTheDecadeWhenAuthorWasBorn() {

    List<Author> allUniqueAuthors = allBooks.stream().map(AbstractBook::getAuthor).distinct().collect(Collectors.toList());
    List<Integer> decadesWhenBooksWherePublished = allBooks.stream().map(b -> b.getYearPublished() / 10).collect(Collectors.toList());

    return allUniqueAuthors.stream().filter(a -> {
      int decadeWhenAuthorWasBorn = a.getYearOfBirth() / 10;
      return decadesWhenBooksWherePublished.contains(decadeWhenAuthorWasBorn);
    }).collect(Collectors.toList());
  }

  public List<Author> getAllAuthorsThatHaveMoreThanThreeBooks() {
    Map<Author, List<AbstractBook>> authorsMap = allBooks.stream().collect(Collectors.groupingBy(AbstractBook::getAuthor));
    return authorsMap.entrySet().stream().filter(e -> e.getValue().size() > 3).map(Map.Entry::getKey).collect(Collectors.toList());
  }

  public List<AbstractBook> getOldestAndNewestBook() {
    AbstractBook maxBook = allBooks.stream().max(Comparator.comparing(AbstractBook::getYearPublished)).orElseThrow(NoSuchElementException::new);
    AbstractBook minBook = allBooks.stream().min(Comparator.comparing(AbstractBook::getYearPublished)).orElseThrow(NoSuchElementException::new);
    return List.of(minBook, maxBook);
  }

  public List<AbstractBook> getAllBooks() {
    return new ArrayList<>(allBooks);
  }

  public AbstractBook getBookById(UUID id) {
    return allBooks.stream().filter(b -> b.getId().equals(id)).findFirst().orElseThrow();
  }

  public List<Author> getAllAuthors() {
    return allBooks.stream().map(AbstractBook::getAuthor).distinct().collect(Collectors.toList());
  }

  public void addBook(AbstractBook newBook) {
    allBooks.add(newBook);
  }

  public void deleteBookById(UUID uuid) {
    allBooks.removeIf(x -> x.getId().equals(uuid));
  }
}
