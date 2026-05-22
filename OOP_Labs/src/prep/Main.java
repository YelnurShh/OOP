package prep;

public class Main {

	public static void main(String[] args) {
		
		 //Problem1
		 Book b = new Book("Book" , "Yelnur" , 12);
		 b.displayInfo();
		    
		 //Problem
		 BankAcc a = new BankAcc(3000);
		    
	     a.deposit(300);
	     System.out.println(a.getBalance());
	     a.withdraw(4000);
	     System.out.println(a.getBalance());
	     
	     //Problem3
	     Dog g = new Dog("Ақтөс");
	     g.makeSound();
	     Cat c = new Cat("Киса");
	     c.makeSound();
	     
	     //Problem4
	     Calculator r = new Calculator();
	     System.out.println(r.add(2.4, 2.4));
	     
	     //Problem5
	     Circle cir = new Circle(6);
	     cir.getArea();
	     
	     Rectangle re = new Rectangle(2,3);
	     re.getArea();
	     
	     //Problem6
	     Car car = new Car();
	     car.move();
	     
	     Bycikle bi = new Bycikle();
	     bi.move();
	}

}
