package models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	private User from;
	private User to;
	private String content;
	private Date date;

	public Message(User from, User to, String content) {
		this.from = from;
		this.to = to;
		this.content = content;
		this.date = new Date();
	}

	public User getFrom() {
		return from;
	}

	public User getTo() {
		return to;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "[" + date + "] " + from.getName() + " -> " + to.getName() + ": " + content;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Message))
			return false;
		Message m = (Message) o;
		return Objects.equals(from, m.from) && Objects.equals(to, m.to) && Objects.equals(content, m.content)
				&& Objects.equals(date, m.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(from, to, content, date);
	}
}
