package prep;

public class Circle extends Shape{
	
	private double p = 3.14;
	private int r;
	
	public Circle(int r) {
		this.r = r;
	}
	
	@Override
	public void getArea() {
		System.out.println(p*r);
	}
}
