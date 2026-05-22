package models;

import java.io.Serializable;
import java.util.Date;

public class OfficialMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String type;
	private String content;
	private String room;
	private Date eventDate;
	private Employee createdBy;

	public OfficialMessage(String type, String content, String room, Date eventDate, Employee createdBy) {
		this.type = type;
		this.content = content;
		this.room = room;
		this.eventDate = eventDate;
		this.createdBy = createdBy;
	}

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public String getRoom() {
		return room;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	@Override
	public String toString() {
		return "[OFFICIAL][" + type + "] " + content + " | Room: " + room + " | Date: " + eventDate + " | By: "
				+ (createdBy == null ? "?" : createdBy.getName());
	}
}
