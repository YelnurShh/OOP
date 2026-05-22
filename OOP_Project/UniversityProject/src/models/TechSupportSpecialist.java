package models;

import enums.Language;
import enums.RequestStatus;
import database.Database;
import java.util.*;

public class TechSupportSpecialist extends Employee {
	private static final long serialVersionUID = 1L;

	public TechSupportSpecialist(int id, String name, String email, String pass, Language l, String empId) {
		super(id, name, email, pass, l, empId);
	}

	public List<Request> viewNewRequests() {
		List<Request> all = Database.getInstance().getRequests();
		List<Request> result = new ArrayList<>();
		for (Request r : all) {
			if (r.getStatus() == null) {
				r.setStatus(RequestStatus.VIEWED);
				result.add(r);
			} else if (r.getStatus() == RequestStatus.VIEWED) {
				result.add(r);
			}
		}
		return result;
	}

	public void acceptRequest(Request r) {
		r.setStatus(RequestStatus.ACCEPTED);
		System.out.println(name + " accepted request: " + r.getDescription());
	}

	public void rejectRequest(Request r) {
		r.setStatus(RequestStatus.REJECTED);
		System.out.println(name + " rejected request: " + r.getDescription());
	}

	public void markAsDone(Request r) {
		r.setStatus(RequestStatus.DONE);
		System.out.println(name + " marked as done: " + r.getDescription());
	}

	@Override
	public String toString() {
		return "TechSupport " + name;
	}
}
