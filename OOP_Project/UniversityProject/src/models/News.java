package models;

import java.io.Serializable;
import java.util.*;

public class News implements Serializable, Comparable<News> {
	private static final long serialVersionUID = 1L;

	private String title;
	private String content;
	private String topic;
	private boolean isPinned;
	private List<String> comments = new ArrayList<>();
	private Date publishDate;

	public News(String title, String content, String topic) {
		this.title = title;
		this.content = content;
		this.topic = topic;
		this.publishDate = new Date();
	}

	public void addComment(String c) {
		comments.add(c);
	}

	public void pin() {
		this.isPinned = true;
	}

	public void unpin() {
		this.isPinned = false;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getTopic() {
		return topic;
	}

	public boolean isPinned() {
		return isPinned;
	}

	public List<String> getComments() {
		return comments;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	@Override
	public int compareTo(News o) {
		if (this.isPinned && !o.isPinned)
			return -1;
		if (!this.isPinned && o.isPinned)
			return 1;
		return o.publishDate.compareTo(this.publishDate);
	}

	@Override
	public String toString() {
		return (isPinned ? "[PINNED] " : "") + "[" + topic + "] " + title + " - " + content + " (comments: "
				+ comments.size() + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof News))
			return false;
		News n = (News) o;
		return Objects.equals(title, n.title) && Objects.equals(publishDate, n.publishDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, publishDate);
	}
}
