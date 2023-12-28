import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {
    private List<Book> books;

    public LibraryDatabase() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }
}
