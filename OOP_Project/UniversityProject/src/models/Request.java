package models;

import enums.RequestStatus;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Request implements Serializable {
	private static final long serialVersionUID = 1L;
	private String description;
	private RequestStatus status;
	private Employee createdBy;
	private Date createdAt;
	private boolean signed;
	private Manager signedBy;

	public Request(String description, Employee createdBy) {
		this.description = description;
		this.createdBy = createdBy;
		this.createdAt = new Date();
	}

	public void updateStatus(RequestStatus s) {
		this.status = s;
	}

	public String getDescription() {
		return description;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setStatus(RequestStatus s) {
		this.status = s;
	}

	@Override
	public String toString() {
		return "Request[" + description + ", status=" + status + ", by="
				+ (createdBy == null ? "?" : createdBy.getName()) + ", signed=" + signed + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Request))
			return false;
		Request r = (Request) o;
		return Objects.equals(description, r.description) && Objects.equals(createdAt, r.createdAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, createdAt);
	}

	public boolean isSigned() {
		return signed;
	}

	public Manager getSignedBy() {
		return signedBy;
	}

	public void sign(Manager m) {
		this.signed = true;
		this.signedBy = m;
		System.out.println("Request signed by " + m.getName());
	}
}
