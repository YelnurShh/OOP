package users;

import enums.DegreeType;
import enums.Language;
import exceptions.LowHIndexException;
import interfaces.Researcher;
import research.ResearchPaper;
import research.ResearchProject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GraduateStudent extends Student implements Researcher, Serializable {

	private static final long serialVersionUID = 1L;

	private DegreeType degree;
	private Researcher supervisor;
	private List<ResearchPaper> diplomaPapers;
	private List<ResearchPaper> papers;
	private List<ResearchProject> projects;

	public GraduateStudent() {
		this.diplomaPapers = new ArrayList<>();
		this.papers = new ArrayList<>();
		this.projects = new ArrayList<>();
	}

	public GraduateStudent(int id, String name, String email, String password, Language language, DegreeType degree) {
		super(id, name, email, password, language);
		this.degree = degree;
		this.diplomaPapers = new ArrayList<>();
		this.papers = new ArrayList<>();
		this.projects = new ArrayList<>();
	}

	public void setSupervisor(Researcher supervisor) throws LowHIndexException {
		if (supervisor.calculateHIndex() < 3) {
			throw new LowHIndexException(
					"Supervisor's h-index is " + supervisor.calculateHIndex() + " which is less than 3.");
		}
		this.supervisor = supervisor;
		System.out.println(name + "'s supervisor has been set.");
	}

	public void submitDiplomaPaper(ResearchPaper paper) {
		diplomaPapers.add(paper);
		papers.add(paper);
		System.out.println(name + " submitted diploma paper: " + paper.getTitle());
	}

	@Override
	public void publishPaper(ResearchPaper paper) {
		papers.add(paper);
		System.out.println(name + " published: " + paper.getTitle());
	}

	@Override
	public int calculateHIndex() {
		int h = 0;
		List<ResearchPaper> sorted = new ArrayList<>(papers);
		sorted.sort(ResearchPaper.BY_CITATIONS);
		for (int i = 0; i < sorted.size(); i++) {
			if (sorted.get(i).getCitations() >= i + 1) {
				h = i + 1;
			} else
				break;
		}
		return h;
	}

	@Override
	public void printPapers(Comparator<ResearchPaper> comparator) {
		List<ResearchPaper> sorted = new ArrayList<>(papers);
		sorted.sort(comparator);
		for (ResearchPaper p : sorted) {
			System.out.println(p);
		}
	}

	@Override
	public void joinResearchProject(ResearchProject project) {
		projects.add(project);
	}

	@Override
	public List<ResearchProject> getProjects() {
		return projects;
	}

	@Override
	public List<ResearchPaper> getPapers() {
		return papers;
	}

	public DegreeType getDegree() {
		return degree;
	}

	public void setDegree(DegreeType degree) {
		this.degree = degree;
	}

	public Researcher getSupervisor() {
		return supervisor;
	}

	public List<ResearchPaper> getDiplomaPapers() {
		return diplomaPapers;
	}

	public void setDiplomaPapers(List<ResearchPaper> diplomaPapers) {
		this.diplomaPapers = diplomaPapers;
	}

	@Override
	public String toString() {
		return "GraduateStudent{id=" + id + ", name='" + name + "', degree=" + degree + "}";
	}
}
