package users;

import enums.Language;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> logFiles;

	public Admin() {
		this.logFiles = new ArrayList<>();
	}

	public Admin(int id, String name, String email, String password, Language language, String employeeId) {
		
		super(id, name, email, password, language, employeeId);
		this.logFiles = new ArrayList<>();
	}

	public void addUser(User user) {
		System.out.println("User added: " + user.getName());
		logFiles.add("ADD: " + user.getName());
	}

	public void removeUser(User user) {
		System.out.println("User removed: " + user.getName());
		logFiles.add("REMOVE: " + user.getName());
	}

	public void updateUser(User user) {
		System.out.println("User updated: " + user.getName());
		logFiles.add("UPDATE: " + user.getName());
	}

	public List<String> viewLogFiles() {
		return logFiles;
	}

	@Override
	public String toString() {
		return "Admin{id=" + id + ", name='" + name + "'}";
	}
}
