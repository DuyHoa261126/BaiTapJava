package Lab1;

public class Circle1 {
	private double radius;
	private String color;

	public Circle1() {
		radius = 1.0;
		color = "red";
	}

	public Circle1(double radius) {
		this.radius = radius;
		color = "red";
	}

	public Circle1(double radius, String color) {
		this.radius = radius;
		this.color = color;
	}

	public double getRadius() {
		return radius;
	}

	public String getColor() {
		return color;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String toString() {
		return "Circle [radius=" + radius + ", color=" + color + "]";
	}

	public double getArea() {
		return radius * radius * 3.14;
	}

}
