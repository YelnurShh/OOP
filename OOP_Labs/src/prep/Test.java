package prep;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		ArrayList<Emplyee> list = new ArrayList<>();
		
		
		Emplyee e1 = new Emplyee(1, "Yelnur");
		Emplyee e2 = new Emplyee(2, "Yelnur");
		Emplyee e3 = new Emplyee(3, "Miras");
		
		
		list.add(e2);
		list.add(e3);
		list.add(e1);
		
		
		System.out.println("До сорта:");
		System.out.println(list);
		Collections.sort(list);
		System.out.println("Плсле сорта:");
		System.out.println(list);
		
	
	}

}

class Emplyee implements Comparable<Emplyee>{
	int id;
	String name;
	
	public Emplyee(int id , String name) {
		this.id = id;
		this.name =name;
	}
	

	@Override
	public int compareTo(Emplyee o) {
		int res = this.name.compareTo(o.name);
		
		if(res == 0) {
			res = this.id - o.id;
		}
		return res;
		
	}
	
	@Override
	public String toString() {
		
		return id + " " + name;
	}
	
}
