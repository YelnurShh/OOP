package academic;

import enums.LessonType;
import users.Teacher;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Lesson implements Serializable {

	private static final long serialVersionUID = 1L;

	private LessonType lessonType;
	private Teacher teacher;
	private Date schedule;

	public Lesson() {
	}

	public Lesson(LessonType lessonType, Teacher teacher, Date schedule) {
		this.lessonType = lessonType;
		this.teacher = teacher;
		this.schedule = schedule;
	}

	public LessonType getLessonType() {
		return lessonType;
	}

	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Lesson))
			return false;
		Lesson that = (Lesson) o;
		return lessonType == that.lessonType && Objects.equals(schedule, that.schedule);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lessonType, schedule);
	}

	@Override
	public String toString() {
		return "Lesson{type=" + lessonType + ", teacher=" + (teacher != null ? teacher.getName() : "N/A")
				+ ", schedule=" + schedule + "}";
	}
}
