package communication;

import users.User;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	private User from;
	private User to;
	private String content;
	private Date date;

	public Message() {
	}

	public Message(User from, User to, String content, Date date) {
		this.from = from;
		this.to = to;
		this.content = content;
		this.date = date;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Message))
			return false;
		Message that = (Message) o;
		return Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(date, that.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(from, to, date);
	}

	@Override
	public String toString() {
		return "Message{from=" + (from != null ? from.getName() : "N/A") + ", to=" + (to != null ? to.getName() : "N/A")
				+ ", date=" + date + ", content='" + content + "'}";
	}
}
