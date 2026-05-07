package research;

import exceptions.NotResearcherException;
import interfaces.Researcher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResearchProject implements Serializable {

	private static final long serialVersionUID = 1L;

	private String topic;
	private List<ResearchPaper> papers;
	private List<Researcher> participants;

	public ResearchProject() {
		this.papers = new ArrayList<>();
		this.participants = new ArrayList<>();
	}

	public ResearchProject(String topic) {
		this.topic = topic;
		this.papers = new ArrayList<>();
		this.participants = new ArrayList<>();
	}

	public void addParticipant(Object obj) throws NotResearcherException {
		if (!(obj instanceof Researcher)) {
			throw new NotResearcherException("Only researchers can join a research project!");
		}
		participants.add((Researcher) obj);
	}

	public void publishPaper(ResearchPaper paper) {
		papers.add(paper);
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<ResearchPaper> getPapers() {
		return papers;
	}

	public void setPapers(List<ResearchPaper> papers) {
		this.papers = papers;
	}

	public List<Researcher> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Researcher> participants) {
		this.participants = participants;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ResearchProject))
			return false;
		ResearchProject that = (ResearchProject) o;
		return Objects.equals(topic, that.topic);
	}

	@Override
	public int hashCode() {
		return Objects.hash(topic);
	}

	@Override
	public String toString() {
		return "ResearchProject{topic='" + topic + "', participants=" + participants.size() + ", papers="
				+ papers.size() + "}";
	}
}
