package models;

import enums.LessonType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Lesson implements Serializable {
	private static final long serialVersionUID = 1L;

	private LessonType type;
	private Teacher teacher;
	private Date schedule;
	private String room;

	public Lesson(LessonType type, Teacher teacher, Date schedule, String room) {
		this.type = type;
		this.teacher = teacher;
		this.schedule = schedule;
		this.room = room;
	}

	public LessonType getType() {
		return type;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Date getSchedule() {
		return schedule;
	}

	public String getRoom() {
		return room;
	}

	public void setTeacher(Teacher t) {
		this.teacher = t;
	}

	public void setSchedule(Date d) {
		this.schedule = d;
	}

	@Override
	public String toString() {
		return type + " by " + (teacher == null ? "TBA" : teacher.getName()) + " at " + room;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Lesson))
			return false;
		Lesson l = (Lesson) o;
		return type == l.type && Objects.equals(teacher, l.teacher) && Objects.equals(schedule, l.schedule)
				&& Objects.equals(room, l.room);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, teacher, schedule, room);
	}
}
