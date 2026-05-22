package database;

import models.*;
import interfaces.Researcher;
import java.io.*;
import java.util.*;

public class Database implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String FILE = "data/university.ser";

	private List<User> users = new ArrayList<>();
	private List<Course> courses = new ArrayList<>();
	private List<News> news = new ArrayList<>();
	private List<Journal> journals = new ArrayList<>();
	private List<ResearchProject> projects = new ArrayList<>();
	private List<Request> requests = new ArrayList<>();
	private List<StudentOrganization> orgs = new ArrayList<>();
	private List<String> logs = new ArrayList<>();
	private List<OfficialMessage> officialMessages = new ArrayList<>();

	private static Database instance;

	private Database() {
	}

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	public void addUser(User u) {
		if (!users.contains(u))
			users.add(u);
	}

	public void removeUser(User u) {
		users.remove(u);
	}

	public void addCourse(Course c) {
		if (!courses.contains(c))
			courses.add(c);
	}

	public void addNews(News n) {
		news.add(n);
		Collections.sort(news);
	}

	public void addJournal(Journal j) {
		if (!journals.contains(j))
			journals.add(j);
	}

	public void addProject(ResearchProject p) {
		if (!projects.contains(p))
			projects.add(p);
	}

	public void addRequest(Request r) {
		requests.add(r);
	}

	public void addOrganization(StudentOrganization o) {
		orgs.add(o);
	}

	public void log(String msg) {
		logs.add("[" + new Date() + "] " + msg);
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public List<News> getNews() {
		return news;
	}

	public List<Journal> getJournals() {
		return journals;
	}

	public List<ResearchProject> getProjects() {
		return projects;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public List<StudentOrganization> getOrgs() {
		return orgs;
	}

	public List<String> getLogs() {
		return logs;
	}

	public List<Researcher> getResearchers() {
		List<Researcher> r = new ArrayList<>();
		for (User u : users)
			if (u instanceof Researcher)
				r.add((Researcher) u);
		return r;
	}

	public Researcher getTopCitedResearcher() {
		Researcher top = null;
		int max = -1;
		for (Researcher r : getResearchers()) {
			int total = 0;
			for (ResearchPaper p : r.getPapers())
				total += p.getCitations();
			if (total > max) {
				max = total;
				top = r;
			}
		}
		return top;
	}

	public Researcher getTopCitedInSchool(String school) {
		Researcher top = null;
		int max = -1;
		for (Researcher r : getResearchers()) {
			String s = null;
			if (r instanceof Teacher)
				s = ((Teacher) r).getSchool();
			else if (r instanceof GraduateStudent)
				s = ((GraduateStudent) r).getSchool();
			if (s == null || !s.equalsIgnoreCase(school))
				continue;
			int total = 0;
			for (ResearchPaper p : r.getPapers())
				total += p.getCitations();
			if (total > max) {
				max = total;
				top = r;
			}
		}
		return top;
	}

	public User authenticate(String email, String pass) {
		for (User u : users) {
			if (u.login(email, pass)) {
				log("User " + u.getName() + " authenticated");
				return u;
			}
		}
		return null;
	}

	public void saveData() {
		new File("data").mkdirs();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
			oos.writeObject(this);
			System.out.println("[DB] State saved to " + FILE);
		} catch (IOException e) {
			System.out.println("[DB] Save failed: " + e.getMessage());
		}
	}

	public static void loadData() {
		File f = new File(FILE);
		if (!f.exists()) {
			System.out.println("[DB] No saved state, starting fresh");
			return;
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			instance = (Database) ois.readObject();
			System.out.println("[DB] State loaded from " + FILE);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[DB] Load failed: " + e.getMessage());
		}
	}

	public void generateTopCitedNews() {
		Researcher top = getTopCitedResearcher();
		if (top == null)
			return;
		int total = 0;
		for (ResearchPaper p : top.getPapers())
			total += p.getCitations();
		News n = new News("Top Cited Researcher", top.getResearcherName()
				+ " is now the top cited researcher in the university (citations=" + total + ")", "Research");
		n.pin();
		addNews(n);
		System.out.println("[AUTO-NEWS] Top cited: " + top.getResearcherName());
	}

	public void clear() {
		users.clear();
		courses.clear();
		news.clear();
		journals.clear();
		projects.clear();
		requests.clear();
		orgs.clear();
		logs.clear();
		officialMessages.clear();
	}

	private Object readResolve() {
		instance = this;
		return this;
	}

	public void addOfficialMessage(OfficialMessage m) {
		officialMessages.add(m);
		System.out.println("[BROADCAST] " + m);
	}

	public List<OfficialMessage> getOfficialMessages() {
		return officialMessages;
	}

	public void bookRoomForExam(String room, Date date, Course c, Employee by) {
		OfficialMessage m = new OfficialMessage("EXAM_BOOKING", "Exam for " + c.getName() + " is planned. Room booked.",
				room, date, by);
		addOfficialMessage(m);
	}

	public void printAllPapers(Comparator<ResearchPaper> c) {
		List<ResearchPaper> all = new ArrayList<>();
		for (Researcher r : getResearchers()) {
			for (ResearchPaper p : r.getPapers()) {
				if (!all.contains(p))
					all.add(p);
			}
		}
		all.sort(c);
		System.out.println("=== All papers in university (total: " + all.size() + ") ===");
		for (ResearchPaper p : all)
			System.out.println("  - " + p);
	}

	public Researcher getTopCitedOfYear(int year) {
		Researcher top = null;
		int max = -1;
		java.util.Calendar cal = java.util.Calendar.getInstance();
		for (Researcher r : getResearchers()) {
			int total = 0;
			for (ResearchPaper p : r.getPapers()) {
				cal.setTime(p.getDate());
				if (cal.get(java.util.Calendar.YEAR) == year)
					total += p.getCitations();
			}
			if (total > max) {
				max = total;
				top = r;
			}
		}
		return top;
	}
}
