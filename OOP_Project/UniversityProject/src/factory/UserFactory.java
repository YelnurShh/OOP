package factory;

import enums.*;
import models.*;

public class UserFactory {

	public static User createUser(String role, int id, String name, String email, String pass, Language lang,
			Object... extra) {
		switch (role.toUpperCase()) {
		case "ADMIN":
			return new Admin(id, name, email, pass, lang, (String) extra[0]);
		case "MANAGER":
			return new Manager(id, name, email, pass, lang, (String) extra[0], (ManagerType) extra[1]);
		case "TEACHER":
			return new Teacher(id, name, email, pass, lang, (String) extra[0], (TeacherPosition) extra[1],
					(String) extra[2]);
		case "STUDENT":
			return new Student(id, name, email, pass, lang, (String) extra[0], (String) extra[1], (Integer) extra[2]);
		case "GRADUATE":
			return new GraduateStudent(id, name, email, pass, lang, (String) extra[0], (String) extra[1],
					(Integer) extra[2], (DegreeType) extra[3]);
		case "SUPPORT":
			return new TechSupportSpecialist(id, name, email, pass, lang, (String) extra[0]);
		case "RESEARCHER_EMP":
			return new ResearcherEmployee(id, name, email, pass, lang, (String) extra[0], (String) extra[1]);
		default:
			throw new IllegalArgumentException("Unknown role: " + role);
		}
	}
}
