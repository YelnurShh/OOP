package Practice4.problem2.main;

import pr4.interfaces.model.Cat;
import pr4.interfaces.model.Student;
import pr4.interfaces.services.Restaurant;

public class Main {

	public static void main(String[] args) {
		
		 Restaurant r = new Restaurant();
	        r.servePizza(new Cat());
	        r.servePizza(new Student("Aibek", 3.5));

	}

}
