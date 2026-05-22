package models;

import exceptions.NotResearcherException;
import interfaces.Researcher;
import java.io.Serializable;
import java.util.*;

public class ResearchProject implements Serializable {
	private static final long serialVersionUID = 1L;

	private String topic;
	private List<ResearchPaper> papers = new ArrayList<>();
	private List<Researcher> participants = new ArrayList<>();

	public ResearchProject(String topic) {
		this.topic = topic;
	}

	public void addParticipant(Object o) throws NotResearcherException {
		if (!(o instanceof Researcher)) {
			throw new NotResearcherException("Object is not a Researcher: " + o);
		}
		Researcher r = (Researcher) o;
		if (!participants.contains(r)) {
			participants.add(r);
			r.getProjects().add(this);
			System.out.println(r.getResearcherName() + " joined project: " + topic);
		}
	}

	public void publishPaper(ResearchPaper p) {
		papers.add(p);
		for (Researcher r : participants) {
			if (!r.getPapers().contains(p))
				r.getPapers().add(p);
		}
		System.out.println("[NEWS] Project '" + topic + "' published paper: " + p.getTitle());
	}

	public String getTopic() {
		return topic;
	}

	public List<ResearchPaper> getPapers() {
		return papers;
	}

	public List<Researcher> getParticipants() {
		return participants;
	}

	@Override
	public String toString() {
		return "Project[" + topic + ", participants=" + participants.size() + ", papers=" + papers.size() + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ResearchProject))
			return false;
		return Objects.equals(topic, ((ResearchProject) o).topic);
	}

	@Override
	public int hashCode() {
		return Objects.hash(topic);
	}
}
