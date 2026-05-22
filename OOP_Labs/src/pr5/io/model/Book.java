package pr5.io.model;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private transient int visitCount;

    public Book(String t, String a) {
        this.title = t;
        this.author = a;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getVisitCount() { return visitCount; }
    

    public void incrementVisit() {
        this.visitCount++;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " (visits=" + visitCount + ")";
    }
}
