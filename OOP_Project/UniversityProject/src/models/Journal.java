package models;

import interfaces.Observable;
import interfaces.Observer;
import java.io.Serializable;
import java.util.*;

public class Journal implements Observable, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private List<ResearchPaper> papers = new ArrayList<>();
    private List<Observer> subscribers = new ArrayList<>();

    public Journal(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Observer o) {
        if (!subscribers.contains(o)) subscribers.add(o);
    }

    @Override
    public void unsubscribe(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : subscribers) o.update(this);
    }

    public void addPaper(ResearchPaper p) {
        papers.add(p);
        notifyObservers();
    }

    public String getName() { return name; }
    public List<ResearchPaper> getPapers() { return papers; }
    public List<Observer> getSubscribers() { return subscribers; }

    @Override
    public String toString() {
        return "Journal[" + name + ", papers=" + papers.size() + ", subs=" + subscribers.size() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;
        return Objects.equals(name, ((Journal) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
