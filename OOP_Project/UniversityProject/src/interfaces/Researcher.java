package interfaces;

import java.util.*;
import java.util.stream.Collectors;
import models.ResearchPaper;
import models.ResearchProject;
import exceptions.NotResearcherException;

public interface Researcher {
	List<ResearchPaper> getPapers();

	List<ResearchProject> getProjects();

	String getResearcherName();

	default void publishPaper(ResearchPaper p) {
		getPapers().add(p);
		System.out.println("[NEWS] " + getResearcherName() + " published a new paper: \"" + p.getTitle() + "\"");
		database.Database.getInstance().generateTopCitedNews();
	}

	default int calculateHIndex() {
		List<Integer> cs = getPapers().stream().map(ResearchPaper::getCitations).sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		int h = 0;
		for (int i = 0; i < cs.size(); i++) {
			if (cs.get(i) >= i + 1)
				h = i + 1;
			else
				break;
		}
		return h;
	}

	default void printPapers(Comparator<ResearchPaper> c) {
		List<ResearchPaper> sorted = new ArrayList<>(getPapers());
		sorted.sort(c);
		for (ResearchPaper p : sorted)
			System.out.println("  - " + p);
	}

	default void joinResearchProject(ResearchProject p) throws NotResearcherException {
		p.addParticipant(this);
	}
}
