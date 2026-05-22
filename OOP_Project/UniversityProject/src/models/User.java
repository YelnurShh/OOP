package models;

import enums.Language;
import interfaces.Observer;
import java.io.Serializable;
import java.util.*;

public abstract class User implements Observer, Serializable, Comparable<User> {
    private static final long serialVersionUID = 1L;

    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected Language lang;
    protected List<Message> inbox = new ArrayList<>();

    public User(int id, String name, String email, String pass, Language l) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = pass;
        this.lang = l;
    }

    public boolean login(String e, String p) {
        return email.equals(e) && password.equals(p);
    }

    public void logout() {
        System.out.println(name + " logged out");
    }

    public void sendMessage(User to, String text) {
        Message m = new Message(this, to, text);
        to.inbox.add(m);
        System.out.println("[MSG] " + name + " -> " + to.name + ": " + text);
    }

    public void subscribeToJournal(Journal j) {
        j.subscribe(this);
        System.out.println(name + " subscribed to journal: " + j.getName());
    }

    @Override
    public void update(Journal j) {
        System.out.println("[NOTIFY -> " + name + "] New paper in journal: " + j.getName());
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Language getLang() { return lang; }
    public void setLang(Language l) { this.lang = l; }
    public List<Message> getInbox() { return inbox; }
    public void setName(String n) { this.name = n; }
    public void setEmail(String e) { this.email = e; }
    public void setPassword(String p) { this.password = p; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        return id == ((User) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return name + " (id=" + id + ", email=" + email + ")";
    }
}
