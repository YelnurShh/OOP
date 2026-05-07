package research;

import enums.Format;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ResearchPaper implements Comparable<ResearchPaper>, Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private List<String> authors;
	private String journal;
	private int citations;
	private int pages;
	private Date date;
	private String doi;

	public static final Comparator<ResearchPaper> BY_DATE = Comparator.comparing(ResearchPaper::getDate);

	public static final Comparator<ResearchPaper> BY_CITATIONS = (p1, p2) -> Integer.compare(p2.citations,
			p1.citations);

	public static final Comparator<ResearchPaper> BY_PAGES = Comparator.comparingInt(ResearchPaper::getPages);

	public ResearchPaper() {
	}

	public ResearchPaper(String title, List<String> authors, String journal, int citations, int pages, Date date,
			String doi) {
		this.title = title;
		this.authors = authors;
		this.journal = journal;
		this.citations = citations;
		this.pages = pages;
		this.date = date;
		this.doi = doi;
	}

	public String getCitation(Format format) {
		if (format == Format.PLAIN_TEXT) {
			return authors + ". " + title + ". " + journal + ". " + date + ". DOI: " + doi;
		} else if (format == Format.BIBTEX) {
			return "@article{" + doi + ",\n" + "  title={" + title + "},\n" + "  author={" + authors + "},\n"
					+ "  journal={" + journal + "},\n" + "  year={" + date + "},\n" + "  doi={" + doi + "}\n" + "}";
		}
		return "";
	}

	@Override
	public int compareTo(ResearchPaper other) {
		return Integer.compare(other.citations, this.citations);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public int getCitations() {
		return citations;
	}

	public void setCitations(int citations) {
		this.citations = citations;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ResearchPaper))
			return false;
		ResearchPaper that = (ResearchPaper) o;
		return Objects.equals(doi, that.doi);
	}

	@Override
	public int hashCode() {
		return Objects.hash(doi);
	}

	@Override
	public String toString() {
		return "ResearchPaper{title='" + title + "', citations=" + citations + ", journal='" + journal + "', date="
				+ date + "}";
	}
}
