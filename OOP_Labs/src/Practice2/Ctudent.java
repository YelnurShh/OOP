package Practice2;

public class Ctudent {
	enum Degree {BACHELOR, MASTER, PHD}
	
	private String name;
	private int age;
	private static int count = 0;
	private final String university = "KBTU";
	
	Degree degree;
	
	public Ctudent(String name, int age, Degree degree) {
		this.name = name;
		this.age = age;
		this.count++;
		this.degree = degree;
		
	}
	
	static int getCount() {
		return count;
	}
	
	public void printDetayl() {
		System.out.print("Студент оқып жатыр");
	}
	
	public void printDetayl(String subj) {
		System.out.print("Студент" + subj + "пәнін оқып жатыр" );
	}
	
	public void displayInfo() {
		System.out.print(name + ' ' + age);
	}

	public static void main(String[] args) {
		Ctudent student = new Ctudent("Yelnur", 19, Degree.MASTER);
		
		student.displayInfo();

	}

}
