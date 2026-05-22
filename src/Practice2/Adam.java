package Practice2;

public class Adam {
	
	public static void main(String[] args) {
		AdamC adam = new AdamC("Yelnur" , 19, 64);
		
		System.out.println(adam.getName());
		System.out.println(adam.getAge());
		System.out.println(adam.getWeight());

	}

}


class AdamC{
	private String aName;
	private int aAge;
	private int aWeight;
	
	public AdamC(String name, int age, int weight) {
		this.aName = name;
		this.aAge = age;
		this.aWeight = weight;
	}
	
//	Void Method
//	public void displayContent() {
//		System.out.print("Name: " + aName);
//		System.out.print("Age: " + aAge);
//		System.out.print("Weight: " + aWeight);
//	}
	
	
	
//	Method Getter Setter
	public String getName(){
		return this.aName;
	}
	
	public int getAge(){
		return this.aAge;
	}
	
	public int getWeight(){
		return this.aWeight;
	}
	
	
}
