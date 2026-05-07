package users;

import enums.Language;
import interfaces.Observer;
import research.Journal;
import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Observer, Serializable {

	private static final long serialVersionUID = 1L;

	protected int id;
	protected String name;
	protected String email;
	protected String password;
	protected Language language;

	public User() {
	}

	public User(int id, String name, String email, String password, Language language) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.language = language;
	}

	public void login() {
		System.out.println(name + " logged in.");
	}

	public void logout() {
		System.out.println(name + " logged out.");
	}

	public void sendMessage(User to, String text) {
		System.out.println("Message from " + name + " to " + to.getName() + ": " + text);
	}

	public void subscribeToJournal(Journal journal) {
		journal.subscribe(this);
		System.out.println(name + " subscribed to journal: " + journal.getName());
	}

	@Override
	public void update(Journal journal) {
		System.out.println("[Notification] " + name + ": New paper in journal '" + journal.getName() + "'");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User that = (User) o;
		return id == that.id && Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, email);
	}

	@Override
	public String toString() {
		return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
	}
}
