import academic.Course;
import academic.Lesson;
import academic.Mark;
import communication.News;
import communication.Request;
import enums.*;
import exceptions.LowHIndexException;
import exceptions.NotResearcherException;
import organizations.StudentOrganization;
import patterns.Database;
import research.Journal;
import research.ResearchPaper;
import research.ResearchProject;
import users.*;

import java.util.Arrays;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		System.out.println("University Research System - Demo\n");

		Database db = Database.getInstance();
		System.out.println("Database initialized: " + db);

		Admin admin = new Admin(1, "Admin Almas", "admin@uni.kz", "admin123", Language.KZ, "EMP001");
		Teacher teacher = new Teacher(2, "Assylzhan Izbassar", "teacher@uni.kz", "pass123", Language.EN, "EMP002",
				TeacherPosition.PROFESSOR);
		
		
		Student student = new Student(3, "Aigerim Bekova", "student@uni.kz", "pass123", Language.RU);
		GraduateStudent gradStudent = new GraduateStudent(4, "Daniyar Seitkali", "grad@uni.kz", "pass123", Language.EN,
				DegreeType.PHD);
		
		
		Manager manager = new Manager(5, "Pakizar Shamoi", "manager@uni.kz", "pass123", Language.KZ, "EMP003",
				ManagerType.DEPARTMENT);
		
		
		TechSupportSpecialist techSupport = new TechSupportSpecialist(6, "Tech Nurlan", "tech@uni.kz", "pass123",
				Language.KZ, "EMP004");

		System.out.println("Users created.\n");

		System.out.println("--- Admin Actions ---");
		
		admin.addUser(student);
		admin.addUser(teacher);
		
		System.out.println("Log files: " + admin.viewLogFiles());

		System.out.println("\n--- Course Actions ---");
		
		Course course = new Course("CS101", "Object-Oriented Programming", 5, CourseType.MAJOR);
		course.addTeacher(teacher);
		
		Lesson lesson = new Lesson(LessonType.LECTURE, teacher, new Date());
		course.addLesson(lesson);
		
		student.registerForCourse(course);
		student.viewTranscript();

		System.out.println("\n--- Teacher Actions ---");
		Mark mark = new Mark(85, 90, 88);
		
		teacher.putMark(student, mark);
		System.out.println("Mark total: " + mark.getTotal());
		
		teacher.sendComplaint(student, UrgencyLevel.LOW);

		System.out.println("\n--- Research Actions ---");
		ResearchPaper paper = new ResearchPaper("LMS Logs and Student Performance",
				Arrays.asList("Izbassar A.", "Shamoi P."), "KBTU Journal", 15, 10, new Date(), "10.1234/kbtu.2024");
		teacher.publishPaper(paper);
		
		System.out.println("H-index: " + teacher.calculateHIndex());
		System.out.println("Citation (Plain): " + paper.getCitation(Format.PLAIN_TEXT));
		System.out.println("Citation (BibTeX): " + paper.getCitation(Format.BIBTEX));

		ResearchProject project = new ResearchProject("AI in Education");
		
		try {
			project.addParticipant(teacher);
			project.addParticipant(gradStudent);
			System.out.println("Participants joined: " + project.getParticipants().size());
		} catch (NotResearcherException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("\n--- Graduate Student Actions ---");
		try {
			gradStudent.setSupervisor(teacher);
		} catch (LowHIndexException e) {
			System.out.println("Error: " + e.getMessage());
		}

		ResearchPaper diplomaPaper = new ResearchPaper("Deep Learning in University Systems",
				Arrays.asList("Seitkali D."), "Thesis Journal", 5, 8, new Date(), "10.5678/thesis.2024");
		gradStudent.submitDiplomaPaper(diplomaPaper);

		System.out.println("\n--- Observer Pattern (Journal) ---");
		Journal journal = new Journal("KBTU Research Journal");
		
		student.subscribeToJournal(journal);
		teacher.subscribeToJournal(journal);
		journal.addPaper(paper);

		System.out.println("\n--- Student Organization ---");
		StudentOrganization org = new StudentOrganization("KBTU IT Club");
		
		student.joinOrganization(org);
		org.setHead(student);

		System.out.println("\n--- Tech Support ---");
		Request request = new Request("Fix projector in Room 201", techSupport);
		
		techSupport.getRequests().add(request);
		techSupport.viewNewRequests();
		techSupport.acceptRequest(request);
		techSupport.markAsDone(request);

		System.out.println("\n--- News ---");
		News researchNews = new News("New Paper Published", "Prof. Izbassar published a new paper.", "Research");
		
		System.out.println(researchNews + " | Pinned: " + researchNews.isPinned());
		researchNews.addComment("Great work!");

		System.out.println("\n--- Manager Actions ---");
		
		manager.assignCourse(teacher, course);
		manager.approveRegistration(student);
		manager.createStatisticalReport();

		System.out.println("\n--- Saving Data ---");
		
		db.getUsers().add(admin);
		db.getUsers().add(teacher);
		db.getUsers().add(student);
		db.getCourses().add(course);
		db.getNews().add(researchNews);
		db.saveData();
	}
}
