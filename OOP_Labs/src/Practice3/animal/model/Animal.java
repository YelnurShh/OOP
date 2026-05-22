package Practice3.animal.model;

public abstract class Animal {
	
	protected String name;
	protected int age;
	
	
	public Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public abstract void makeSound();
	
	public void eat() {
		System.out.println(name + " is eating");
	}
	
	public void eat(String food) {
		System.out.println(name + " is eating " + food);
	}
	
	public void getInfo() {
	     System.out.print("Name: "+ name + ", Age: " + age);
	}

}
