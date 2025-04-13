package Lab1;

public class Circle2 {
	private double radius;

	public Circle2() {
		radius = 1.0;
	}

	public Circle2(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * 3.14;
	}

	public double getCircumference() {
		return 2 * radius * 3.14;
	}

	public String toString() {
		return "Circle2 [radius=" + radius + "]";
	}

}
