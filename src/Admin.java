public class Admin extends Users {
    private int Id;
    private String name;

    private LibraryManagement library= new LibraryManagement();
    public Admin(String name, int Id) {
        super(name, Id);
    }
    public void addBook(Book newBook){
        library.addBook(newBook);
    }

    public void deleteBook(Book b){
        library.deleteBook(b);
    }

}
