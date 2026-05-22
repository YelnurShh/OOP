package lab3.problem2;

public class Problem2 {
	public static void main(String[] args) {
		Car c = new Car("Toyota", 0, 0);
		Drone d = new Drone("DJI", 0, 0, 0);
		c.move(10, 5);
		d.move(3, 4);
		d.fly(100);
		System.out.println(c);
		System.out.println(d);
	}
}
