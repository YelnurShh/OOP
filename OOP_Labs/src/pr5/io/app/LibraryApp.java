package pr5.io.app;

import pr5.io.model.Book;
import java.io.*;
import java.util.*;

public class LibraryApp {
    private static final String FILE = "library.dat";

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        ArrayList<Book> books = new ArrayList<>();

        File f = new File(FILE);
        if (f.exists()) {
     
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                books = (ArrayList<Book>) ois.readObject();
            }
        }

        Scanner sc = new Scanner(System.in);
        String cmd;
        while (true) {
            System.out.print("(A)dd / (L)ist / (Q)uit: ");
            cmd = sc.nextLine().trim().toUpperCase();
            
            if (cmd.equals("A")) {
                System.out.print("Title: ");
                String t = sc.nextLine();
                System.out.print("Author: ");
                String a = sc.nextLine();
                books.add(new Book(t, a));
            } else if (cmd.equals("L")) {
  
                for (Book b : books) {
                    b.incrementVisit(); 
                    System.out.println(b);
                }
            } else if (cmd.equals("Q")) {
                break;
            }
        }
        sc.close();


        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(books);
        }
        System.out.println("Saved.");
    }
}