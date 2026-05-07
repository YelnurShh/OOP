package users;

import communication.Request;
import enums.Language;
import enums.RequestStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TechSupportSpecialist extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Request> requests;

	public TechSupportSpecialist() {
		this.requests = new ArrayList<>();
	}

	public TechSupportSpecialist(int id, String name, String email, String password, Language language,
			String employeeId) {
		super(id, name, email, password, language, employeeId);
		this.requests = new ArrayList<>();
	}

	public List<Request> viewNewRequests() {
		List<Request> newRequests = new ArrayList<>();
		for (Request r : requests) {
			r.updateStatus(RequestStatus.VIEWED);
			newRequests.add(r);
		}
		return newRequests;
	}

	public void acceptRequest(Request request) {
		request.updateStatus(RequestStatus.ACCEPTED);
		System.out.println(name + " accepted request: " + request.getDescription());
	}

	public void rejectRequest(Request request) {
		request.updateStatus(RequestStatus.REJECTED);
		System.out.println(name + " rejected request: " + request.getDescription());
	}

	public void markAsDone(Request request) {
		request.updateStatus(RequestStatus.DONE);
		System.out.println(name + " marked done: " + request.getDescription());
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "TechSupportSpecialist{id=" + id + ", name='" + name + "'}";
	}
}
