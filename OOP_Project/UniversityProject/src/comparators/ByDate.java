package comparators;

import java.util.Comparator;
import models.ResearchPaper;

public class ByDate implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper a, ResearchPaper b) {
        return b.getDate().compareTo(a.getDate());
    }
}
