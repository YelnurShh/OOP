package Lab2.problem1.partB;

public abstract class LibraryItem {
	public abstract String getItemInfo();

	private String title;
	private String author;
	private int year;

	public LibraryItem(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title + " by " + author + " (" + year + ")";
	}
}
