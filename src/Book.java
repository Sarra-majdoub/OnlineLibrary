public class Book {
    protected String title;
    protected String author;
    protected int code;

    public boolean available=true;

    public Book(String title, String author, int code) {
        this.title = title;
        this.author = author;
        this.code = code;
        this.available = true;
    }

    Boolean isAvailable(){
        return available;
    }
    void setAvailable(boolean etat){
        this.available=etat;
    }


    public String getTitle() {
        return title;
    }
    public void display() {
        System.out.println("title :"+title+", author:"+author);
    }

}
