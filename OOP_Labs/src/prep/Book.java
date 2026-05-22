package prep;

public class Book{
    public String title;
    public String author;
    public int year;
    
    public Book(String t, String a, int y){
        this.title = t;
        this.author = a;
        this.year = y;
    }
    
    public void displayInfo(){
        System.out.println(title + author + year);
    }
}