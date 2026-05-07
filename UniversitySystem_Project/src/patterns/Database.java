package patterns;

import communication.News;
import academic.Course;
import users.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String FILE_PATH = "data/database.ser";

	private static Database instance;

	private List<User> users;
	private List<Course> courses;
	private List<News> news;

	private Database() {
		this.users = new ArrayList<>();
		this.courses = new ArrayList<>();
		this.news = new ArrayList<>();
	}

	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public void saveData() {
		try {
			File dir = new File("data");
			if (!dir.exists())
				dir.mkdirs();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(this);
			oos.close();
			System.out.println("Data saved successfully.");
		} catch (IOException e) {
			System.err.println("Error saving data: " + e.getMessage());
		}
	}

	public void loadData() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
			Database loaded = (Database) ois.readObject();
			ois.close();
			this.users = loaded.users;
			this.courses = loaded.courses;
			this.news = loaded.news;
			System.out.println("Data loaded successfully.");
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error loading data: " + e.getMessage());
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "Database{users=" + users.size() + ", courses=" + courses.size() + ", news=" + news.size() + "}";
	}
}
