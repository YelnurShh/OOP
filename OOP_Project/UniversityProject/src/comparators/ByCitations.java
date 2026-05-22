package comparators;

import java.util.Comparator;
import models.ResearchPaper;

public class ByCitations implements Comparator<ResearchPaper> {
    @Override
    public int compare(ResearchPaper a, ResearchPaper b) {
        return Integer.compare(b.getCitations(), a.getCitations());
    }
}
