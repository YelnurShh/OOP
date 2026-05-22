package Practice4.problem3.main;

import pr4.interfaces.model.LogicGame;
import pr4.interfaces.model.MemoryGame;
import pr4.interfaces.model.iPhone;
import pr4.interfaces.services.App;

public class Main {

	public static void main(String[] args) {
		
		 App app = new App();
	        app.getStatistics(new LogicGame());
	        app.getStatistics(new MemoryGame());

	        iPhone ip = new iPhone();
	        ip.sell();
	        ip.plug();
	        

	}

}
