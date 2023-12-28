import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LibraryManagement librarySystem = new LibraryManagement();
    private static Users User = null ;
    private static Admin admin = null ;
    private static Events event= new Events("Stars","12/01/2024","Andalucia");

    static Book b1=new Book("Intro to java","Jhon",100);
    static Book b2=new Book("Intro to python","Tom",200);
    static Book b3=new Book("Math","khemi",300);

    static Book testBook;

    /*-------------------------------------------------*/
    public static void main(String[] args) {

        librarySystem.addBook(b1);
        librarySystem.addBook(b2);
        librarySystem.addBook(b3);

        System.out.println("You are currently using our Online Library ! ");

        int choice ;
        while (true) {
            Menu();
            choice =Choice();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("our books:");
                    librarySystem.displayBooks();
                    break;
                case 3:
                    if (admin==null && User==null) {
                        System.out.println("log in first");
                    }else {

                        System.out.println("our books:");
                        librarySystem.displayBooks();

                        Scanner scanner = new Scanner(System.in);

                        System.out.println("the title of the book to borrow:");
                        String title = scanner.nextLine();

                        System.out.println("the author of the book:");
                        String author = scanner.nextLine();


                        System.out.println("the code of the book:");
                        int code = scanner.nextInt();

                        Book b= new Book(title,author,code);

                        testBook =librarySystem.searchBook(b.getTitle());

                        if (User!=null) {
                            User.borrowBook(testBook);
                        }else {
                            admin.borrowBook(testBook);
                        }
                    }
                    break;
                case 4:
                    if (admin==null && User==null) {
                        System.out.println("log in first");
                    }else {
                        if (User.listVide()) {
                            System.out.println("You did not borrow any books");
                        } else {
                            Scanner scanner = new Scanner(System.in);

                            System.out.println("the title of the book to return :");
                            String title = scanner.nextLine();

                            System.out.println("the author of the book:");
                            String author = scanner.nextLine();

                            System.out.println("the code of the book:");
                            int code = scanner.nextInt();

                            Book b= new Book(title,author,code);

                            testBook = testBook =librarySystem.searchBook(b.getTitle());

                            if (User!=null) {
                                User.returnBook(testBook);
                            }else {
                                admin.returnBook(testBook);
                            }
                        }
                    }
                    break;

                case 5:
                    if (admin==null && User==null) {
                        System.out.println("log in first");
                    }else{
                        event.displayEventDetails();
                        if (User!=null) {
                            event.addParticipant(User.getName());
                            User.participated=true ;
                        }else {
                            event.addParticipant(admin.getName());
                            admin.participated=true;
                        }
                        System.out.println("participation approved !");
                    }
                    break;

                case 6:
                    if (admin==null && User==null){
                        System.out.println("log in first");
                    }else if  (admin!=null && User==null) {
                        Scanner scanner = new Scanner(System.in);

                        System.out.println("the title of the book to add :");
                        String title = scanner.nextLine();

                        System.out.println("the author of the book:");
                        String author = scanner.nextLine();

                        System.out.println("the code of the book:");
                        int code = scanner.nextInt();

                        Book b = new Book(title, author, code);

                        librarySystem.addBook(b);
                    }else{
                        System.out.println("You must be an admin to add a book ");
                    }
                    break;
                case 7:
                    if (admin==null && User==null){
                        System.out.println("log in first");
                    }else if (admin!=null && User==null){
                        Scanner scanner = new Scanner(System.in);

                        System.out.println("the title of the book to add :");
                        String title = scanner.nextLine();

                        System.out.println("the author of the book:");
                        String author = scanner.nextLine();

                        System.out.println("the code of the book:");
                        int code = scanner.nextInt();

                        Book b = new Book(title, author, code);

                        librarySystem.deleteBook(b);
                    }else{
                        System.out.println("You must be an admin to remove a book from a library ");
                    }
                    break;

                case 8:
                    if (admin==null && User==null){
                        System.out.println("log in first");
                    }else if (User!= null) {
                        User.displayBorrowedBooks();
                    }else {
                        admin.displayBorrowedBooks();
                    }
                    break;

                case 9:
                    logout(User);
                    break;
                case 10:
                    if (admin==null && User==null){
                        System.out.println("log in first");

                    }else if (admin!=null && User==null){
                        System.out.println(event.participants);

                    }else{
                        System.out.println("You must be an admin to remove a book from a library ");
                    }
                    break;
                case 11:
                    exit();
                    break;

                default:
                    System.out.println("Invalid choice. Please try again ");
            }
        }
    }

    private static void logout(Users currentUser) {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }

        System.out.println("logging out... See you soon ");
        User=null;
        admin=null;
    }

    private static void exit() {
        System.out.println("Exiting the application. Thank you!");
        System.exit(0);
    }

    private static void  login() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name : ");
        String username = scanner.nextLine();

        System.out.print("Enter status : ");
        String status = scanner.nextLine();

        while (!"admin".equals(status) && !"user".equals(status)) {
            System.out.print("Enter your role (admin /user): ");
            status = scanner.nextLine();
        }

        System.out.print("Enter your ID : ");
        int ID = scanner.nextInt();




        if ( "admin".equals(status) ){
            System.out.print("Enter your AdminID : ");
            int studentId = scanner.nextInt();
            admin = new Admin(username,ID);
        }

        if( "user".equals(status) ) {
            System.out.print("Enter user ID : ");
            int adminId = scanner.nextInt();
            User= new Users(username,ID);
            librarySystem.addUser(User);
        }
        System.out.println("login approved !");

    }
    private static int Choice() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }

    public static void Menu() {
        System.out.println("--------------------|| Online Library ||-------------");
        System.out.println("1. Login ");
        System.out.println("2. check our books");
        System.out.println("3. borrow a book ");
        System.out.println("4. return a book ");
        System.out.println("5. participate to an event ");
        System.out.println("6. add a book to the library ");
        System.out.println("7. remove a book from the library ");
        System.out.println("8. view your borrowed books ");
        System.out.println("9. log out");
        System.out.println("10. List of participants");
        System.out.println("11. Exit");
        System.out.print("Enter your choice: ");
    }
}