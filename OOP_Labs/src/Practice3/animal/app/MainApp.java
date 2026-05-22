package Practice3.animal.app;

import Practice3.animal.model.*;
import java.util.ArrayList;
import java.util.List;


public class MainApp {
		public static void main(String[] args) {
			List<Animal> animals = new ArrayList<>();
		
		
		Animal genericDog = new Dog("Buddy", 3, "Golden Retriever");
		
		Dog dog1 = new Dog("Rex", 5, "German Shepherd");
        Dog dog2 = new Dog("Max", 2, "Beagle");

        animals.add(genericDog);
        animals.add(dog1);
        animals.add(dog2);

        for (Animal animal : animals) {
            animal.getInfo();
            animal.makeSound();
            animal.eat();
            animal.eat("meat");
            System.out.println("--------------------");
        }
    }
}
