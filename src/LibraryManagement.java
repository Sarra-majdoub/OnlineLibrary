import java.util.ArrayList;
import java.util.List;
public class LibraryManagement {
    protected List<Users> users=new ArrayList<>();
    protected List<Book> books= new ArrayList<>();
    protected LibraryDatabase libraryDatabase;

    public void addUser(Users user) {
        this.users.add(user);
    }
    public void addBook(Book book) {

        this.books.add(book);
    }
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    public void displayBooks(){

        for(Book book: books){
            book.display();
        }
    }
    public void deleteBook(Book b){
        if (books.contains(b)){
            books.remove(b);
        }else{
            System.out.println(" the book does not exist !");
        }
    }

}
