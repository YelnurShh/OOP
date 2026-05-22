package models;

import enums.Language;
import database.Database;
import java.util.*;

public class Admin extends Employee {
	private static final long serialVersionUID = 1L;

	public Admin(int id, String name, String email, String pass, Language l, String empId) {
		super(id, name, email, pass, l, empId);
	}

	public void addUser(User u) {
		Database.getInstance().addUser(u);
		Database.getInstance().log("Admin " + name + " added user " + u.getName());
		System.out.println("Admin added user: " + u.getName());
	}

	public void removeUser(User u) {
		Database.getInstance().removeUser(u);
		Database.getInstance().log("Admin " + name + " removed user " + u.getName());
		System.out.println("Admin removed user: " + u.getName());
	}

	public void updateUser(User u, String newName, String newEmail) {
		u.setName(newName);
		u.setEmail(newEmail);
		Database.getInstance().log("Admin " + name + " updated user id=" + u.getId());
		System.out.println("Admin updated user: " + u.getName());
	}

	public List<String> viewLogFiles() {
		return Database.getInstance().getLogs();
	}

	@Override
	public String toString() {
		return "Admin " + name;
	}
}
