package BT5_2;

public class Circle {
private double radius;
private String color;

public Circle(double Radius,String Color) {
	this.radius=Radius;
	this.color=Color;
}
public Circle() {
	
}

public double getRadius() {
	return radius;
}

public void setRadius(double radius) {
	this.radius = radius;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public double getArea() {
	return radius*radius*Math.PI;
}

public double getCircumference() {
	return 2*radius*Math.PI;
}
public static void main(String[] args) {
	Circle c=new Circle(2,"Red");
	c.getArea();
}
}
