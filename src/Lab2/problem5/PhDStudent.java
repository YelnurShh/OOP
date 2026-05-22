package Lab2.problem5;

public class PhDStudent extends Person {
	private String dept, area;

	public PhDStudent(String n, int a, String d, String ar) {
		super(n, a);
		dept = d;
		area = ar;
	}

	public String getDept() {
		return dept;
	}

	public String getArea() {
		return area;
	}

	public void assignPet(Animal p) {
		if (p instanceof Dog) {
			System.out.println("PhDStudent cannot have a dog");
			return;
		}
		super.assignPet(p);
	}

	public String getOccupation() {
		return "PhD in " + dept + " (" + area + ")";
	}
}
