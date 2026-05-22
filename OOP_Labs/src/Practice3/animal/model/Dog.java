package Practice3.animal.model;

public class Dog extends Animal{
	private String breed;
	
	public Dog(String name, int age, String breed) {
		super(name,age);
		this.breed = breed;
	}
	
	@Override
    public void makeSound() {
		
        System.out.println(name + " says: Woof Woof!");
    }
	
	@Override
    public void getInfo() {
        super.getInfo(); 
        System.out.println(", Breed: " + breed);
    }
}
