package communication;

import enums.RequestStatus;
import users.Employee;
import java.io.Serializable;
import java.util.Objects;

public class Request implements Serializable {

	private static final long serialVersionUID = 1L;

	private String description;
	private RequestStatus status;
	private Employee createdBy;

	public Request() {
		this.status = RequestStatus.VIEWED;
	}

	public Request(String description, Employee createdBy) {
		this.description = description;
		this.createdBy = createdBy;
		this.status = RequestStatus.VIEWED;
	}

	public void updateStatus(RequestStatus status) {
		this.status = status;
		System.out.println("Request status updated to: " + status);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Request))
			return false;
		Request that = (Request) o;
		return Objects.equals(description, that.description) && Objects.equals(createdBy, that.createdBy);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, createdBy);
	}

	@Override
	public String toString() {
		return "Request{description='" + description + "', status=" + status + ", createdBy="
				+ (createdBy != null ? createdBy.getName() : "N/A") + "}";
	}
}
