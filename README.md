# library project

## Dev Setup

* Install Java 16 and set it on your `PATH`
* Set `JAVA_HOME` environment variable in your OS pointing to JDK installation (i.e. `C:\Program Files\Java\jdk-16.0.1`). This is needed because the project includes mvn binary and it expects for that environment variable to be set.
* clone the repository
* enter the project folder directory
* run `mvnw clean install`
* run `java -jar target/library-0.0.1-SNAPSHOT.jar`

## Exercise

Open the following links to see the result from the corresponding exercises.

2.
- (a) http://localhost:8080/exercise/get-all-books-by-publishing-year
- (b) http://localhost:8080/exercise//get-all-books-from-author-whose-last-name-starts-with?q=t
- (c) http://localhost:8080/exercise/get-all-authors-for-which-there-are-books-from-the-same-decade-he-was-born
- (d) http://localhost:8080/exercise/get-all-authors-with-more-than-three-books
- (e) http://localhost:8080/exercise/oldest-and-newest-book

