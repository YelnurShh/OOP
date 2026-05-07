package research;

import interfaces.Observable;
import interfaces.Observer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Journal implements Observable, Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<ResearchPaper> papers;
	private List<Observer> subscribers;

	public Journal() {
		this.papers = new ArrayList<>();
		this.subscribers = new ArrayList<>();
	}

	public Journal(String name) {
		this.name = name;
		this.papers = new ArrayList<>();
		this.subscribers = new ArrayList<>();
	}

	public void addPaper(ResearchPaper paper) {
		papers.add(paper);
		notifyObservers();
	}

	@Override
	public void subscribe(Observer o) {
		if (!subscribers.contains(o)) {
			subscribers.add(o);
		}
	}

	@Override
	public void unsubscribe(Observer o) {
		subscribers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : subscribers) {
			o.update(this);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ResearchPaper> getPapers() {
		return papers;
	}

	public void setPapers(List<ResearchPaper> papers) {
		this.papers = papers;
	}

	public List<Observer> getSubscribers() {
		return subscribers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Journal))
			return false;
		Journal that = (Journal) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public String toString() {
		return "Journal{name='" + name + "', papers=" + papers.size() + ", subscribers=" + subscribers.size() + "}";
	}
}
