package models;

import enums.DegreeType;
import enums.Language;
import exceptions.LowHIndexException;
import interfaces.Researcher;
import java.util.*;

public class GraduateStudent extends Student implements Researcher {
	private static final long serialVersionUID = 1L;

	public static final int MIN_SUPERVISOR_HINDEX = 3;

	private DegreeType degree;
	private Researcher supervisor;
	private List<ResearchPaper> diplomaPapers = new ArrayList<>();
	private List<ResearchPaper> papers = new ArrayList<>();
	private List<ResearchProject> projects = new ArrayList<>();

	public GraduateStudent(int id, String name, String email, String pass, Language l, String major, String school,
			int year, DegreeType degree) {
		super(id, name, email, pass, l, major, school, year);
		this.degree = degree;
	}

	public void setSupervisor(Researcher r) throws LowHIndexException {
		if (r.calculateHIndex() < MIN_SUPERVISOR_HINDEX) {
			throw new LowHIndexException("Cannot assign " + r.getResearcherName() + " as supervisor. h-index = "
					+ r.calculateHIndex() + ", minimum required = " + MIN_SUPERVISOR_HINDEX);
		}
		this.supervisor = r;
		System.out.println(name + "'s supervisor set to " + r.getResearcherName());
	}

	public void submitDiplomaPaper(ResearchPaper p) {
		diplomaPapers.add(p);
		if (!papers.contains(p))
			papers.add(p);
		System.out.println(name + " submitted diploma paper: " + p.getTitle());
	}

	public DegreeType getDegree() {
		return degree;
	}

	public Researcher getSupervisor() {
		return supervisor;
	}

	public List<ResearchPaper> getDiplomaPapers() {
		return diplomaPapers;
	}

	@Override
	public List<ResearchPaper> getPapers() {
		return papers;
	}

	@Override
	public List<ResearchProject> getProjects() {
		return projects;
	}

	@Override
	public String getResearcherName() {
		return name;
	}

	@Override
	public String toString() {
		return "GraduateStudent " + name + " [" + degree + ", " + major + "]";
	}
}
