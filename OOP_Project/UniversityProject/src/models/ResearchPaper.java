package models;

import enums.Format;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class ResearchPaper implements Serializable, Comparable<ResearchPaper> {
	private static final long serialVersionUID = 1L;

	private String title;
	private List<String> authors;
	private String journal;
	private int citations;
	private int pages;
	private Date date;
	private String doi;

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

	public String getCitation(Format f) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(date);
		if (f == Format.PLAIN_TEXT) {
			return String.join(", ", authors) + " (" + year + "). " + title + ". " + journal + ", pp. " + pages
					+ ". DOI: " + doi;
		} else {
			String key = (authors.isEmpty() ? "anon" : authors.get(0).split(" ")[0]) + year;
			return "@article{" + key + ",\n" + "  title={" + title + "},\n" + "  author={"
					+ String.join(" and ", authors) + "},\n" + "  journal={" + journal + "},\n" + "  year={" + year
					+ "},\n" + "  pages={" + pages + "},\n" + "  doi={" + doi + "}\n}";
		}
	}

	public String getTitle() {
		return title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public String getJournal() {
		return journal;
	}

	public int getCitations() {
		return citations;
	}

	public int getPages() {
		return pages;
	}

	public Date getDate() {
		return date;
	}

	public String getDoi() {
		return doi;
	}

	public void setCitations(int c) {
		this.citations = c;
	}

	@Override
	public int compareTo(ResearchPaper o) {
		return this.title.compareTo(o.title);
	}

	@Override
	public String toString() {
		return "\"" + title + "\" (" + new SimpleDateFormat("yyyy").format(date) + ") cites=" + citations + ", pages="
				+ pages + ", " + journal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ResearchPaper))
			return false;
		return Objects.equals(doi, ((ResearchPaper) o).doi);
	}

	@Override
	public int hashCode() {
		return Objects.hash(doi);
	}
}
