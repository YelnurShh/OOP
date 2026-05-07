package communication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String content;
	private String topic;
	private boolean isPinned;
	private List<String> comments;

	public News() {
		this.comments = new ArrayList<>();
	}

	public News(String title, String content, String topic) {
		this.title = title;
		this.content = content;
		this.topic = topic;
		this.comments = new ArrayList<>();
		if ("Research".equalsIgnoreCase(topic)) {
			this.isPinned = true;
		}
	}

	public void addComment(String comment) {
		comments.add(comment);
	}

	public void pin() {
		this.isPinned = true;
		System.out.println("News pinned: " + title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
		if ("Research".equalsIgnoreCase(topic)) {
			this.isPinned = true;
		}
	}

	public boolean isPinned() {
		return isPinned;
	}

	public void setPinned(boolean pinned) {
		isPinned = pinned;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof News))
			return false;
		News that = (News) o;
		return Objects.equals(title, that.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title);
	}

	@Override
	public String toString() {
		return "News{title='" + title + "', topic='" + topic + "', pinned=" + isPinned + "}";
	}
}
