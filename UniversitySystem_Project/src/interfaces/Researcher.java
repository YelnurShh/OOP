package interfaces;

import research.ResearchPaper;
import research.ResearchProject;
import java.util.Comparator;
import java.util.List;

public interface Researcher {
	void publishPaper(ResearchPaper paper);

	int calculateHIndex();

	void printPapers(Comparator<ResearchPaper> comparator);

	void joinResearchProject(ResearchProject project);

	List<ResearchProject> getProjects();

	List<ResearchPaper> getPapers();
}
