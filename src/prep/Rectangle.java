package prep;

public class Rectangle extends Shape{
	
	private int a;
	private int b;
	
	public Rectangle(int a , int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void getArea() {
		System.out.println(a*b);
	}
}
