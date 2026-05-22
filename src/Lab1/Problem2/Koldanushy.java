package Lab1.Problem2;

public class Koldanushy {

	public static void main(String[] args) {
		Koldan.showSchool();

		Koldan kol1 = new Koldan("Yelnur", Koldan.Status.OKUSHY);
		Koldan kol2 = new Koldan();

		System.out.println(kol1.toString());
		System.out.println(kol2.toString());

		kol1.neIstep();
		kol1.neIstep("Алгебра");

		Koldan.showSchool();
	}

}

class Koldan {
	// 1
	public enum Status {
		APAI, OKUSHY
	}

	// 2
	private static String mektepAty = "264-Mektep";
	private static int barlykOkushy = 0;
	private final int id;

	private String name;
	private Status role;

	// 3
	{
		barlykOkushy++;
		System.out.println("Жүйеге жаңа қолданушы қосылуда...");
	}

	// 4
	public Koldan() {
		this("Unknown", Status.OKUSHY);
	}

	public Koldan(String name, Status role) {
		this.id = barlykOkushy;
		this.name = name;
		this.role = role;
	}

	// 5
	public void neIstep() {
		if (role == Status.OKUSHY) {
			System.out.println(name + " Үй жұмысын жасап жатыр");
		} else if (role == Status.APAI) {
			System.out.println(name + " Баға қойып жатыр");
		}
	}

	public void neIstep(String pan) {
		if (role == Status.OKUSHY) {
			System.out.println(name + " " + pan + " сабағынан үй жұмысын жасап жатыр");
		} else if (role == Status.APAI) {
			System.out.println(name + " " + pan + " сабағынан баға қойып жатыр");
		}
	}

	// Static method
	public static void showSchool() {
		System.out.println("Name of School: " + mektepAty);
		System.out.println("Barlyk okushylar sany: " + barlykOkushy);
	}

	@Override
	public String toString() {
		return "ID:" + id + " Есімі: " + name + "," + " Рөлі: " + role;
	}

}
