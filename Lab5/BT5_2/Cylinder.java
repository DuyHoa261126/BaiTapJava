package BT5_2;

public class Cylinder {
private Circle base;
private double height;

public Cylinder() {
	base=new Circle();
	height=1.0;
}

public Circle getBase() {
	return base;
}

public void setBase(Circle base) {
	this.base = base;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public double getArea() {
	return 2*Math.PI*base.getRadius()*height;
}

}
