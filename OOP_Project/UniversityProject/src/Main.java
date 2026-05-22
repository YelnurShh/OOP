import comparators.ByCitations;
import comparators.ByDate;
import comparators.ByPages;
import database.Database;
import enums.*;
import exceptions.LowHIndexException;
import exceptions.NotResearcherException;
import factory.UserFactory;
import interfaces.Researcher;
import models.*;
import factory.JournalFactory;
import models.OfficialMessage;
import util.Translator;

import java.util.*;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static Database db = Database.getInstance();
	private static User current;

	public static void main(String[] args) {
		Database.loadData();
		db = Database.getInstance();
		if (db.getUsers().isEmpty())
			seed();

		System.out.println("==========================================");
		System.out.println("  Research-Oriented University System");
		System.out.println("==========================================");

		while (true) {
			if (current == null)
				loginMenu();
			else
				mainMenu();
		}
	}

	private static void seed() {
		System.out.println("[SEED] Initializing demo data...");

		Admin admin = (Admin) UserFactory.createUser("ADMIN", 1, "Aigerim Admin", "admin@kbtu.kz", "1234", Language.EN,
				"E001");
		Manager mgr = (Manager) UserFactory.createUser("MANAGER", 2, "Bolat Manager", "mgr@kbtu.kz", "1234",
				Language.KZ, "E002", ManagerType.DEPARTMENT);
		Manager dean = (Manager) UserFactory.createUser("MANAGER", 3, "Dauren Dean", "dean@kbtu.kz", "1234",
				Language.EN, "E003", ManagerType.OR);
		Teacher t1 = (Teacher) UserFactory.createUser("TEACHER", 4, "Erlan Prof", "erlan@kbtu.kz", "1234", Language.EN,
				"E004", TeacherPosition.PROFESSOR, "SITE");
		Teacher t2 = (Teacher) UserFactory.createUser("TEACHER", 5, "Gulnara Tutor", "gulnara@kbtu.kz", "1234",
				Language.RU, "E005", TeacherPosition.TUTOR, "SITE");
		Teacher t3 = (Teacher) UserFactory.createUser("TEACHER", 6, "Hasan Lector", "hasan@kbtu.kz", "1234",
				Language.EN, "E006", TeacherPosition.SENIOR_LECTOR, "Oil and Gas");
		Student s1 = (Student) UserFactory.createUser("STUDENT", 7, "Ivan Student", "ivan@kbtu.kz", "1234", Language.EN,
				"CS", "SITE", 2);
		Student s2 = (Student) UserFactory.createUser("STUDENT", 8, "Kamila Student", "kamila@kbtu.kz", "1234",
				Language.KZ, "CS", "SITE", 3);
		GraduateStudent gs = (GraduateStudent) UserFactory.createUser("GRADUATE", 9, "Liza Master", "liza@kbtu.kz",
				"1234", Language.EN, "CS", "SITE", 1, DegreeType.MASTER);
		GraduateStudent gs2 = (GraduateStudent) UserFactory.createUser("GRADUATE", 10, "Nurlan Phd", "nurlan@kbtu.kz",
				"1234", Language.EN, "CS", "SITE", 2, DegreeType.PHD);
		TechSupportSpecialist ts = (TechSupportSpecialist) UserFactory.createUser("SUPPORT", 11, "Olzhas Support",
				"support@kbtu.kz", "1234", Language.EN, "E011");
		ResearcherEmployee re = (ResearcherEmployee) UserFactory.createUser("RESEARCHER_EMP", 12, "Petr Lab",
				"petr@kbtu.kz", "1234", Language.EN, "E012", "AI Lab");

		for (User u : Arrays.asList(admin, mgr, dean, t1, t2, t3, s1, s2, gs, gs2, ts, re))
			db.addUser(u);

		Course c1 = new Course("CSCI101", "Intro to Programming", 6, CourseType.MAJOR, "SITE");
		Course c2 = new Course("CSCI201", "Algorithms", 6, CourseType.MAJOR, "SITE");
		Course c3 = new Course("MATH101", "Calculus I", 5, CourseType.MAJOR, "SITE");
		Course c4 = new Course("ART101", "Drawing", 3, CourseType.FREE_ELECTIVE, "Arts");
		Course c5 = new Course("OG101", "Petroleum Engineering Basics", 4, CourseType.FREE_ELECTIVE, "Oil and Gas");
		for (Course c : Arrays.asList(c1, c2, c3, c4, c5))
			db.addCourse(c);

		c1.addLesson(new Lesson(LessonType.LECTURE, t1, new Date(), "B201"));
		c1.addLesson(new Lesson(LessonType.PRACTICE, t2, new Date(), "B202"));
		c2.addLesson(new Lesson(LessonType.LECTURE, t1, new Date(), "B301"));
		c1.setLectureTeacher(t1);
		c1.setPracticeTeacher(t2);

		Journal j1 = JournalFactory.createCS();
		Journal j2 = JournalFactory.createEnergy();

		ResearchPaper p1 = new ResearchPaper("Deep Learning in NLP", Arrays.asList("Erlan Prof"), j1.getName(), 50, 12,
				new Date(123, 5, 1), "10.1/abc1");
		ResearchPaper p2 = new ResearchPaper("Sorting Algorithms Review", Arrays.asList("Erlan Prof", "Liza Master"),
				j1.getName(), 30, 8, new Date(124, 2, 15), "10.1/abc2");
		ResearchPaper p3 = new ResearchPaper("Quantum Computing Intro", Arrays.asList("Erlan Prof"), j1.getName(), 15,
				20, new Date(125, 7, 10), "10.1/abc3");
		ResearchPaper p4 = new ResearchPaper("Reinforcement Learning Survey", Arrays.asList("Erlan Prof"), j1.getName(),
				8, 30, new Date(125, 10, 5), "10.1/abc4");
		ResearchPaper p5 = new ResearchPaper("Petroleum Recovery Methods", Arrays.asList("Hasan Lector"), j2.getName(),
				45, 18, new Date(124, 0, 20), "10.2/og1");
		try {
			t1.publishPaper(p1);
			t1.publishPaper(p2);
			t1.publishPaper(p3);
			t1.publishPaper(p4);
			t3.publishPaper(p5);
			j1.addPaper(p1);
			j1.addPaper(p2);
			j1.addPaper(p3);
			j2.addPaper(p5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResearchProject rp = new ResearchProject("AI for Education");
		try {
			rp.addParticipant(t1);
			rp.addParticipant(gs);
		} catch (NotResearcherException e) {
			System.out.println(e.getMessage());
		}
		db.addProject(rp);

		StudentOrganization org = new StudentOrganization("Coding Club");
		org.setHead(s1);
		org.addMember(s2);
		s1.setOrganization(org);
		s2.setOrganization(org);
		db.addOrganization(org);

		News n1 = new News("Welcome", "New academic year started!", "General");
		News n2 = new News("Research Symposium", "Annual research symposium next month.", "Research");
		n2.pin();
		db.addNews(n1);
		db.addNews(n2);

		db.log("System initialized with seed data");
		System.out.println("[SEED] Done.\n");
	}

	private static void loginMenu() {
		Language l = Language.EN;
		System.out.println("\n--- " + Translator.t("login", l) + " ---");
		System.out.println("1) " + Translator.t("login", l));
		System.out.println("2) Show test accounts");
		System.out.println("3) " + Translator.t("save_exit", l));
		System.out.print("> ");
		String c = sc.nextLine().trim();
		switch (c) {
		case "1":
			doLogin();
			break;
		case "2":
			showAccounts();
			break;
		case "3":
			db.saveData();
			System.exit(0);
		default:
			System.out.println("Invalid choice");
		}
	}

	private static void showAccounts() {
		System.out.println("\nTest accounts (all passwords: 1234):");
		System.out.println("  admin@kbtu.kz   - Admin");
		System.out.println("  mgr@kbtu.kz     - Manager (Department)");
		System.out.println("  dean@kbtu.kz    - Manager (OR / Dean)");
		System.out.println("  erlan@kbtu.kz   - Teacher (Professor, Researcher)");
		System.out.println("  gulnara@kbtu.kz - Teacher (Tutor)");
		System.out.println("  hasan@kbtu.kz   - Teacher (Senior Lector)");
		System.out.println("  ivan@kbtu.kz    - Student");
		System.out.println("  kamila@kbtu.kz  - Student");
		System.out.println("  liza@kbtu.kz    - GraduateStudent (Master)");
		System.out.println("  nurlan@kbtu.kz  - GraduateStudent (PhD)");
		System.out.println("  support@kbtu.kz - Tech Support");
		System.out.println("  petr@kbtu.kz    - Researcher Employee");
	}

	private static void doLogin() {
		System.out.print(Translator.t("email", Language.EN) + ": ");
		String e = sc.nextLine().trim();
		System.out.print(Translator.t("password", Language.EN) + ": ");
		String p = sc.nextLine().trim();
		User u = db.authenticate(e, p);
		if (u == null)
			System.out.println(Translator.t("login_failed", Language.EN));
		else {
			current = u;
			System.out.println(Translator.t("welcome", u.getLang()) + ", " + u.getName() + "!");
		}
	}

	private static void mainMenu() {
		System.out.println("\n--- MAIN MENU (" + current.getName() + ") ---");
		System.out.println(" L) Switch language (current: " + current.getLang() + ")");
		System.out.println(" I) Inbox (" + current.getInbox().size() + " messages)");
		System.out.println(" N) View News");
		System.out.println(" J) Subscribe to journal");
		if (current instanceof Admin)
			adminMenu();
		else if (current instanceof Manager)
			managerMenu();
		else if (current instanceof Teacher)
			teacherMenu();
		else if (current instanceof GraduateStudent)
			graduateMenu();
		else if (current instanceof Student)
			studentMenu();
		else if (current instanceof TechSupportSpecialist)
			supportMenu();
		else if (current instanceof ResearcherEmployee)
			researcherEmpMenu();
		System.out.println(" X) Logout");
		System.out.println(" S) Save & exit");
		System.out.print("> ");
		String c = sc.nextLine().trim().toUpperCase();
		commonHandle(c);
	}

	private static void commonHandle(String c) {
		switch (c) {
		case "L":
			switchLang();
			return;
		case "I":
			showInbox();
			return;
		case "N":
			showNews();
			return;
		case "J":
			subscribeJournal();
			return;
		case "X":
			current.logout();
			current = null;
			return;
		case "S":
			db.saveData();
			System.exit(0);
		}
		if (current instanceof Admin)
			handleAdmin(c);
		else if (current instanceof Manager)
			handleManager(c);
		else if (current instanceof Teacher)
			handleTeacher(c);
		else if (current instanceof GraduateStudent)
			handleGraduate(c);
		else if (current instanceof Student)
			handleStudent(c);
		else if (current instanceof TechSupportSpecialist)
			handleSupport(c);
		else if (current instanceof ResearcherEmployee)
			handleResearcherEmp(c);
	}

	private static void switchLang() {
		System.out.println("Choose: 1) KZ  2) EN  3) RU");
		String x = sc.nextLine().trim();
		Language[] all = { Language.KZ, Language.EN, Language.RU };
		try {
			current.setLang(all[Integer.parseInt(x) - 1]);
			System.out.println("Language: " + current.getLang());
		} catch (Exception e) {
			System.out.println("Invalid");
		}
	}

	private static void showInbox() {
		if (current.getInbox().isEmpty()) {
			System.out.println("Inbox empty");
			return;
		}
		for (Message m : current.getInbox())
			System.out.println(m);
	}

	private static void showNews() {
		if (db.getNews().isEmpty()) {
			System.out.println("No news");
			return;
		}

		List<News> newsList = db.getNews();
		for (int i = 0; i < newsList.size(); i++) {
			System.out.println((i + 1) + ") " + newsList.get(i));
		}

		System.out.print("Comment on news (number, or 0 to skip): ");
		String choice = sc.nextLine().trim();
		if (!choice.equals("0")) {
			try {
				int idx = Integer.parseInt(choice) - 1;
				System.out.print("Your comment: ");
				String comment = sc.nextLine().trim();
				newsList.get(idx).addComment(comment);
				System.out.println("Comment added!");
			} catch (Exception e) {
				System.out.println("Invalid choice");
			}
		}
	}

	private static void subscribeJournal() {
		List<Journal> js = db.getJournals();
		if (js.isEmpty()) {
			System.out.println("No journals");
			return;
		}
		for (int i = 0; i < js.size(); i++)
			System.out.println((i + 1) + ") " + js.get(i).getName());
		System.out.print("Choose: ");
		try {
			int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
			current.subscribeToJournal(js.get(idx));
		} catch (Exception e) {
			System.out.println("Invalid");
		}
	}

	private static void adminMenu() {
		System.out.println(" 1) Add user");
		System.out.println(" 2) Remove user");
		System.out.println(" 3) Update user");
		System.out.println(" 4) View log files");
		System.out.println(" 5) View all users");
	}

	private static void handleAdmin(String c) {
		Admin a = (Admin) current;
		switch (c) {
		case "1":
			System.out.print("Role (STUDENT/TEACHER/MANAGER/SUPPORT): ");
			String role = sc.nextLine().trim().toUpperCase();
			System.out.print("Name: ");
			String n = sc.nextLine().trim();
			System.out.print("Email: ");
			String e = sc.nextLine().trim();
			int newId = db.getUsers().size() + 100;
			try {
				User nu;
				if (role.equals("STUDENT"))
					nu = UserFactory.createUser(role, newId, n, e, "1234", Language.EN, "Major", "SITE", 1);
				else if (role.equals("TEACHER"))
					nu = UserFactory.createUser(role, newId, n, e, "1234", Language.EN, "E" + newId,
							TeacherPosition.LECTOR, "SITE");
				else if (role.equals("MANAGER"))
					nu = UserFactory.createUser(role, newId, n, e, "1234", Language.EN, "E" + newId,
							ManagerType.DEPARTMENT);
				else if (role.equals("SUPPORT"))
					nu = UserFactory.createUser(role, newId, n, e, "1234", Language.EN, "E" + newId);
				else {
					System.out.println("Unknown role");
					return;
				}
				a.addUser(nu);
			} catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			break;
		case "2":
			User uu = pickUser();
			if (uu != null)
				a.removeUser(uu);
			break;
		case "3":
			User u3 = pickUser();
			if (u3 != null) {
				System.out.print("New name: ");
				String nn = sc.nextLine().trim();
				System.out.print("New email: ");
				String ne = sc.nextLine().trim();
				a.updateUser(u3, nn, ne);
			}
			break;
		case "4":
			for (String s : a.viewLogFiles())
				System.out.println(s);
			break;
		case "5":
			for (User x : db.getUsers())
				System.out.println(x);
			break;
		}
	}

	private static User pickUser() {
		List<User> us = db.getUsers();
		for (int i = 0; i < us.size(); i++)
			System.out.println((i + 1) + ") " + us.get(i));
		System.out.print("Choose: ");
		try {
			return us.get(Integer.parseInt(sc.nextLine().trim()) - 1);
		} catch (Exception e) {
			return null;
		}
	}

	private static void managerMenu() {
		System.out.println(" 1) Assign course to teacher");
		System.out.println(" 2) Approve student registration");
		System.out.println(" 3) Add course for registration");
		System.out.println(" 4) Create statistical report");
		System.out.println(" 5) Manage news (publish)");
		System.out.println(" 6) View students info (sorted by GPA)");
		System.out.println(" 7) View teachers info");
		System.out.println(" 8) View employee requests / complaints");
		System.out.println(" 9) Book room for exam");
		System.out.println(" 10) View official messages");
		System.out.println(" 11) Print all university papers");
		System.out.println(" 12) Top cited researcher of the year");
		System.out.println(" 13) Sign employee request");
		System.out.println(" 14) View signed/unsigned requests");
		System.out.println(" 15) Top cited researcher by school");
	}

	private static void handleManager(String c) {
		Manager m = (Manager) current;
		switch (c) {
		case "1":
			Teacher t = pickTeacher();
			if (t == null)
				return;
			Course co = pickCourse();
			if (co == null)
				return;
			System.out.print("Assign as (1=LECTURE, 2=PRACTICE, 3=BOTH): ");
			String lt = sc.nextLine().trim();
			if (lt.equals("1")) {
				co.setLectureTeacher(t);
				System.out.println("Assigned " + t.getName() + " as LECTURE teacher for " + co.getName());
			} else if (lt.equals("2")) {
				co.setPracticeTeacher(t);
				System.out.println("Assigned " + t.getName() + " as PRACTICE teacher for " + co.getName());
			} else {
				m.assignCourse(t, co);
			}
			break;
		case "2":
			Student s = pickStudent();
			if (s == null)
				return;
			Course co2 = pickCourse();
			if (co2 == null)
				return;
			m.approveRegistration(s, co2);
			break;
		case "3": {
			System.out.print("CourseId: ");
			String id = sc.nextLine().trim();
			System.out.print("Name: ");
			String nm = sc.nextLine().trim();
			System.out.print("Credits: ");
			int cr = Integer.parseInt(sc.nextLine().trim());
			System.out.print("Type (MAJOR/MINOR/FREE_ELECTIVE): ");
			CourseType ct = CourseType.valueOf(sc.nextLine().trim().toUpperCase());
			System.out.print("School: ");
			String sch = sc.nextLine().trim();
			System.out.print("For major: ");
			String maj = sc.nextLine().trim();
			System.out.print("Year: ");
			int yrCourse = Integer.parseInt(sc.nextLine().trim());
			m.addCourseForRegistration(new Course(id, nm, cr, ct, sch), maj, yrCourse);
			break;
		}
		case "4":
			System.out.println(m.createStatisticalReport());
			break;
		case "5":
			System.out.print("Title: ");
			String title = sc.nextLine().trim();
			System.out.print("Content: ");
			String cnt = sc.nextLine().trim();
			System.out.print("Topic: ");
			String top = sc.nextLine().trim();
			m.manageNews(new News(title, cnt, top));
			break;
		case "6":
			System.out.println("Sort by: 1) GPA  2) Name");
			String sortChoice = sc.nextLine().trim();
			List<Student> list = sortChoice.equals("2") ? m.viewStudentsByName() : m.viewStudentsByGpa();
			for (Student x : list)
				System.out.println(x);
			break;
		case "7":
			for (Teacher x : m.viewTeachersInfo())
				System.out.println(x);
			break;
		case "8":
			System.out.println("Complaints:");
			for (Request r : m.getComplaints())
				System.out.println("  " + r);
			System.out.println("Employee Requests:");
			for (Request r : db.getRequests())
				System.out.println("  " + r);
			break;
		case "9":
			System.out.print("Room: ");
			String rm = sc.nextLine().trim();
			Course coExam = pickCourse();
			if (coExam == null)
				return;
			m.getEmpId();
			db.bookRoomForExam(rm, new Date(), coExam, m);
			break;
		case "10":
			for (OfficialMessage om : db.getOfficialMessages())
				System.out.println(om);
			break;
		case "11":
			System.out.print("Sort by (1=date, 2=citations, 3=pages): ");
			String sb = sc.nextLine().trim();
			if (sb.equals("1"))
				db.printAllPapers(new ByDate());
			else if (sb.equals("2"))
				db.printAllPapers(new ByCitations());
			else if (sb.equals("3"))
				db.printAllPapers(new ByPages());
			break;
		case "12":
			System.out.print("Year: ");
			int yr = Integer.parseInt(sc.nextLine().trim());
			Researcher topY = db.getTopCitedOfYear(yr);
			System.out.println("Top of " + yr + ": " + (topY == null ? "none" : topY.getResearcherName()));
			break;
		case "13":
			if (db.getRequests().isEmpty()) {
				System.out.println("No requests");
				break;
			}
			for (int i = 0; i < db.getRequests().size(); i++)
				System.out.println((i + 1) + ") " + db.getRequests().get(i));
			System.out.print("Choose: ");
			try {
				int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
				db.getRequests().get(idx).sign(m);
			} catch (Exception ex) {
				System.out.println("Invalid");
			}
			break;
		case "14":
			System.out.println("Signed:");
			for (Request r : db.getRequests())
				if (r.isSigned())
					System.out.println("  " + r);
			System.out.println("Unsigned:");
			for (Request r : db.getRequests())
				if (!r.isSigned())
					System.out.println("  " + r);
			break;

		case "15":
			System.out.print("School name: ");
			String school = sc.nextLine().trim();
			Researcher topS = db.getTopCitedInSchool(school);
			System.out.println("Top in " + school + ": "
					+ (topS == null ? "none" : topS.getResearcherName() + " (h=" + topS.calculateHIndex() + ")"));
			break;
		}
	}

	private static void teacherMenu() {
		System.out.println(" 1) View my courses");
		System.out.println(" 2) Manage course");
		System.out.println(" 3) Put marks");
		System.out.println(" 4) View students of course");
		System.out.println(" 5) Send complaint to dean");
		System.out.println(" 6) Send message");
		System.out.println(" 7) Publish research paper");
		System.out.println(" 8) Calculate h-index");
		System.out.println(" 9) Print my papers (sorted)");
		System.out.println(" 10) Join research project");
		System.out.println(" 11) Get citation of paper");
	}

	private static void handleTeacher(String c) {
		Teacher t = (Teacher) current;
		switch (c) {
		case "1":
			for (Course co : t.viewCourses())
				System.out.println(co);
			break;
		case "2":
			Course co = pickCourse();
			if (co != null)
				t.manageCourse(co);
			break;
		case "3":
			Course co3 = pickCourseFromList(t.viewCourses());
			if (co3 == null)
				return;
			Student s = pickStudentFromCourse(co3);
			if (s == null)
				return;
			System.out.print("Att1: ");
			double a1 = Double.parseDouble(sc.nextLine().trim());
			System.out.print("Att2: ");
			double a2 = Double.parseDouble(sc.nextLine().trim());
			System.out.print("Final: ");
			double fn = Double.parseDouble(sc.nextLine().trim());
			t.putMark(s, co3, new Mark(a1, a2, fn));
			break;
		case "4":
			Course co4 = pickCourseFromList(t.viewCourses());
			if (co4 == null)
				return;
			for (Student x : t.viewStudents(co4))
				System.out.println(x);
			break;
		case "5":
			Manager dean = pickManager();
			if (dean == null)
				return;
			Student vs = pickStudent();
			if (vs == null)
				return;
			System.out.print("Urgency (LOW/MEDIUM/HIGH): ");
			UrgencyLevel ul = UrgencyLevel.valueOf(sc.nextLine().trim().toUpperCase());
			System.out.print("Reason: ");
			String rs = sc.nextLine().trim();
			t.sendComplaint(dean, vs, ul, rs);
			break;
		case "6":
			User to = pickUser();
			if (to == null)
				return;
			System.out.print("Text: ");
			String txt = sc.nextLine().trim();
			t.sendMessage(to, txt);
			break;
		case "7":
			ResearchPaper rp = createPaperPrompt();
			t.publishPaper(rp);
			break;
		case "8":
			System.out.println("h-index: " + t.calculateHIndex());
			break;
		case "9":
			System.out.println("By date:");
			t.printPapers(new ByDate());
			System.out.println("By citations:");
			t.printPapers(new ByCitations());
			System.out.println("By pages:");
			t.printPapers(new ByPages());
			break;
		case "10":
			ResearchProject prj = pickProject();
			if (prj == null)
				return;
			try {
				t.joinResearchProject(prj);
			} catch (NotResearcherException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "11":
			if (t.getPapers().isEmpty()) {
				System.out.println("No papers");
				return;
			}
			for (int i = 0; i < t.getPapers().size(); i++)
				System.out.println((i + 1) + ") " + t.getPapers().get(i));
			System.out.print("Choose: ");
			int pi = Integer.parseInt(sc.nextLine().trim()) - 1;
			System.out.print("Format (1=PLAIN_TEXT, 2=BIBTEX): ");
			int fi = Integer.parseInt(sc.nextLine().trim());
			Format f = fi == 1 ? Format.PLAIN_TEXT : Format.BIBTEX;
			System.out.println(t.getPapers().get(pi).getCitation(f));
			break;
		}
	}

	private static ResearchPaper createPaperPrompt() {
		System.out.print("Title: ");
		String tt = sc.nextLine().trim();
		System.out.print("Authors (comma-separated): ");
		List<String> au = Arrays.asList(sc.nextLine().trim().split("\\s*,\\s*"));
		System.out.print("Journal: ");
		String jr = sc.nextLine().trim();
		System.out.print("Citations: ");
		int ci = Integer.parseInt(sc.nextLine().trim());
		System.out.print("Pages: ");
		int pg = Integer.parseInt(sc.nextLine().trim());
		System.out.print("DOI: ");
		String d = sc.nextLine().trim();
		return new ResearchPaper(tt, au, jr, ci, pg, new Date(), d);
	}

	private static void studentMenu() {
		System.out.println(" 1) View available courses");
		System.out.println(" 2) Register for course");
		System.out.println(" 3) View my courses");
		System.out.println(" 4) View marks");
		System.out.println(" 5) View transcript");
		System.out.println(" 6) Rate teacher");
		System.out.println(" 7) Join student organization");
		System.out.println(" 8) Send message");
		System.out.println(" 9) View teacher info of specific course");
	}

	private static void handleStudent(String c) {
		Student s = (Student) current;
		switch (c) {
		case "1":
			for (Course co : db.getCourses())
				System.out.println(co);
			break;
		case "2":
			Course co = pickCourse();
			if (co != null)
				s.registerForCourse(co);
			break;
		case "3":
			for (Course x : s.viewCourses())
				System.out.println(x);
			break;
		case "4":
			for (Map.Entry<Course, Mark> e : s.viewMarks().entrySet())
				System.out.println(e.getKey().getName() + " -> " + e.getValue());
			break;
		case "5":
			System.out.println(s.getTranscript());
			break;
		case "6":
			Teacher t = pickTeacher();
			if (t == null)
				return;
			System.out.print("Rating (1-5): ");
			int rt = Integer.parseInt(sc.nextLine().trim());
			s.rateTeacher(t, rt);
			break;
		case "7":
			List<StudentOrganization> os = db.getOrgs();
			if (os.isEmpty()) {
				System.out.println("No organizations");
				return;
			}
			for (int i = 0; i < os.size(); i++)
				System.out.println((i + 1) + ") " + os.get(i));
			System.out.print("Choose: ");
			int oi = Integer.parseInt(sc.nextLine().trim()) - 1;
			s.joinOrganization(os.get(oi));
			break;
		case "8":
			User to = pickUser();
			if (to == null)
				return;
			System.out.print("Text: ");
			String tx = sc.nextLine().trim();
			s.sendMessage(to, tx);
			break;
		case "9":
			Course coT = pickCourseFromList(s.viewCourses());
			if (coT == null)
				return;
			System.out.println("Teachers of " + coT.getName() + ":");
			for (Teacher t9 : coT.getTeachers()) {
				System.out.println("  - " + t9 + " | h-index=" + t9.calculateHIndex());
			}
			System.out.println("Lessons:");
			for (Lesson l : coT.getLessons())
				System.out.println("  - " + l);
			break;

		}
	}

	private static void graduateMenu() {
		studentMenu();
		System.out.println(" 10) Set supervisor");
		System.out.println(" 11) Submit diploma paper");
		System.out.println(" 12) Publish research paper");
		System.out.println(" 13) Calculate h-index");
		System.out.println(" 14) Print my papers (sorted)");
		System.out.println(" 15) Join research project");
	}

	private static void handleGraduate(String c) {
		GraduateStudent g = (GraduateStudent) current;
		if (Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9").contains(c)) {
			handleStudent(c);
			return;
		}
		switch (c) {
		case "10":
			List<Researcher> rs = db.getResearchers();
			for (int i = 0; i < rs.size(); i++)
				System.out.println(
						(i + 1) + ") " + rs.get(i).getResearcherName() + " (h=" + rs.get(i).calculateHIndex() + ")");
			System.out.print("Choose: ");
			try {
				int ri = Integer.parseInt(sc.nextLine().trim()) - 1;
				g.setSupervisor(rs.get(ri));
			} catch (LowHIndexException e) {
				System.out.println("EXCEPTION: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Invalid");
			}
			break;
		case "11":
			ResearchPaper p = createPaperPrompt();
			g.submitDiplomaPaper(p);
			break;
		case "12":
			ResearchPaper rp = createPaperPrompt();
			g.publishPaper(rp);
			break;
		case "13":
			System.out.println("h-index: " + g.calculateHIndex());
			break;
		case "14":
			System.out.println("By date:");
			g.printPapers(new ByDate());
			System.out.println("By citations:");
			g.printPapers(new ByCitations());
			System.out.println("By pages:");
			g.printPapers(new ByPages());
			break;
		case "15":
			ResearchProject prj = pickProject();
			if (prj == null)
				return;
			try {
				g.joinResearchProject(prj);
			} catch (NotResearcherException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}

	private static void supportMenu() {
		System.out.println(" 1) View new requests");
		System.out.println(" 2) Accept request");
		System.out.println(" 3) Reject request");
		System.out.println(" 4) Mark as done");
		System.out.println(" 5) Create test request");
	}

	private static void handleSupport(String c) {
		TechSupportSpecialist ts = (TechSupportSpecialist) current;
		switch (c) {
		case "1":
			for (Request r : ts.viewNewRequests())
				System.out.println(r);
			break;
		case "2":
			Request r2 = pickRequest();
			if (r2 != null)
				ts.acceptRequest(r2);
			break;
		case "3":
			Request r3 = pickRequest();
			if (r3 != null)
				ts.rejectRequest(r3);
			break;
		case "4":
			Request r4 = pickRequest();
			if (r4 != null)
				ts.markAsDone(r4);
			break;
		case "5":
			System.out.print("Description: ");
			String d = sc.nextLine().trim();
			Request nr = new Request(d, ts);
			db.addRequest(nr);
			System.out.println("Created: " + nr);
			break;
		}
	}

	private static void researcherEmpMenu() {
		System.out.println(" 1) Publish paper");
		System.out.println(" 2) Calculate h-index");
		System.out.println(" 3) Print papers");
		System.out.println(" 4) Join project");
		System.out.println(" 5) Show top cited researcher");
	}

	private static void handleResearcherEmp(String c) {
		ResearcherEmployee r = (ResearcherEmployee) current;
		switch (c) {
		case "1":
			ResearchPaper rp = createPaperPrompt();
			r.publishPaper(rp);
			break;
		case "2":
			System.out.println("h-index: " + r.calculateHIndex());
			break;
		case "3":
			r.printPapers(new ByCitations());
			break;
		case "4":
			ResearchProject prj = pickProject();
			if (prj == null)
				return;
			try {
				r.joinResearchProject(prj);
			} catch (NotResearcherException e) {
				System.out.println(e.getMessage());
			}
			break;
		case "5":
			Researcher top = db.getTopCitedResearcher();
			System.out.println("Top cited: "
					+ (top == null ? "none" : top.getResearcherName() + " (h=" + top.calculateHIndex() + ")"));
			break;
		}
	}

	private static Course pickCourse() {
		return pickCourseFromList(db.getCourses());
	}

	private static Course pickCourseFromList(List<Course> list) {
		if (list.isEmpty()) {
			System.out.println("No courses");
			return null;
		}
		for (int i = 0; i < list.size(); i++)
			System.out.println((i + 1) + ") " + list.get(i));
		System.out.print("Choose: ");
		try {
			return list.get(Integer.parseInt(sc.nextLine().trim()) - 1);
		} catch (Exception e) {
			return null;
		}
	}

	private static Teacher pickTeacher() {
		List<Teacher> ts = new ArrayList<>();
		for (User u : db.getUsers())
			if (u instanceof Teacher)
				ts.add((Teacher) u);
		if (ts.isEmpty()) {
			System.out.println("No teachers");
			return null;
		}
		for (int i = 0; i < ts.size(); i++)
			System.out.println((i + 1) + ") " + ts.get(i));
		System.out.print("Choose: ");
		try {
			return ts.get(Integer.parseInt(sc.nextLine().trim()) - 1);
		} catch (Exception e) {
			return null;
		}
	}

	private static Student pickStudent() {
		List<Student> ss = new ArrayList<>();
		for (User u : db.getUsers())
			if (u instanceof Student)
				ss.add((Student) u);
		if (ss.isEmpty()) {
			System.out.println("No students");
			return null;
		}
		for (int i = 0; i < ss.size(); i++)
			System.out.println((i + 1) + ") " + ss.get(i));
		System.out.print("Choose: ");
		try {
			return ss.get(Integer.parseInt(sc.nextLine().trim()) - 1);
		} catch (Exception e) {
			return null;
		}
	}

	private static Student pickStudentFromCourse(Course c) {
		if (c.getStudents().isEmpty()) {
			System.out.println("No students in course");
			return null;
		}
		for (int i = 0; i < c.getStudents().size(); i++)
			System.out.println((i + 1) + ") " + c.getStudents().get(i));
		System.out.print("Choose: ");
		try {
			return c.getStudents().get(Integer.parseInt(sc.nextLine().trim()) - 1);
		} catch (Exception e) {
			return null;
		}
	}

	private static Manager pickManager() {
		List<Manager> ms = new ArrayList<>();
		for (User u : db.getUsers())
			if (u instanceof Manager)
				ms.add((Manager) u);
		if (ms.isEmpty()) {
			System.out.println("No managers");
			return null;
		}
		for (int i = 0; i < ms.size(); i++)
			System.out.println((i + 1) + ") " + ms.get(i));
		System.out.print("Choose: ");
		try {
			return ms.get(Integer.parseInt(sc.nextLine().trim()) - 1);
		} catch (Exception e) {
			return null;
		}
	}

	private static ResearchProject pickProject() {
		List<ResearchProject> ps = db.getProjects();
		if (ps.isEmpty()) {
			System.out.println("No projects");
			return null;
		}
		for (int i = 0; i < ps.size(); i++)
			System.out.println((i + 1) + ") " + ps.get(i));
		System.out.print("Choose: ");
		try {
			return ps.get(Integer.parseInt(sc.nextLine().trim()) - 1);
		} catch (Exception e) {
			return null;
		}
	}

	private static Request pickRequest() {
		List<Request> rs = db.getRequests();
		if (rs.isEmpty()) {
			System.out.println("No requests");
			return null;
		}
		for (int i = 0; i < rs.size(); i++)
			System.out.println((i + 1) + ") " + rs.get(i));
		System.out.print("Choose: ");
		try {
			return rs.get(Integer.parseInt(sc.nextLine().trim()) - 1);
		} catch (Exception e) {
			return null;
		}
	}
}
