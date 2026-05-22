package Lab2.problem1.partB;

public class Book extends LibraryItem {
	private int pages;

	public Book(String title, String author, int year, int pages) {
		super(title, author, year);
		this.pages = pages;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String getItemInfo() {
		return "Book: " + toString();
	}

	@Override
	public String toString() {
		return super.toString() + ", pages: " + pages;
	}
}
