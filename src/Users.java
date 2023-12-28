import java.util.ArrayList;
import java.util.List;

public class Users {
    private String name ;
    public boolean participated=false;
    private int userId ;
    private List<Book> borrowedBooks;

    public Users(String name, int userId){
        this.name = name;
        this.userId = userId;
        this.borrowedBooks= new ArrayList<>();
    }
    public void borrowBook(Book book) {

        if (book != null && book.isAvailable()) {
            book.available = false;
            borrowedBooks.add(book);
            System.out.println("Book ' " + book.getTitle() + "' borrowed successfully by " + this.name);
        } else {
            System.out.println("Book is not available for the moment .");
        }

    }
    public void returnBook(Book book) {
        if (book != null ) {
            if ( borrowedBooks.contains(book) ){
                book.setAvailable(true);
                borrowedBooks.remove(book);
                System.out.println("Book '" + book.getTitle() + "' returned successfully by " + this.name);
            }
        } else {
            System.out.println("Invalid return operation. Book is already available or not found.");
        }
    }

    public String getName(){
        return this.name;
    }

    public boolean listVide(){
        return borrowedBooks.isEmpty() ;
    }
    public void displayBorrowedBooks(){
        if (!borrowedBooks.isEmpty()){
            for (Book book: borrowedBooks){
                book.display();
            }
        }
        else{
            System.out.println(" you have not borrowed any books ! ");
        }
    }

}
