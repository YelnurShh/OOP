package models;

import enums.Language;
import interfaces.Researcher;
import java.util.*;

public class ResearcherEmployee extends Employee implements Researcher {
	private static final long serialVersionUID = 1L;

	private List<ResearchPaper> papers = new ArrayList<>();
	private List<ResearchProject> projects = new ArrayList<>();
	private String department;

	public ResearcherEmployee(int id, String name, String email, String pass, Language l, String empId,
			String department) {
		super(id, name, email, pass, l, empId);
		this.department = department;
	}

	public String getDepartment() {
		return department;
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
		return "ResearcherEmployee " + name + " [" + department + "]";
	}
}
