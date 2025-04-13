package ex2;

public class MyPoint {
private int x=0;
private int y=0;

public MyPoint() {
	
}
public MyPoint(int x, int y) {
	this.x = x;
	this.y = y;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
};
public int[] getXY(){
	return new int[] {x,y} ;
}
public void setXY(int x,int y) {
	this.x=x;
	this.y=y;
	
}
public String toString() {
	return "("+x+","+y+")";
}
public double distance(int x,int y) {
	int a=this.x-x;
	int b=this.y-y;
	return Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)) ;
	
}
public double distance(MyPoint another) {
	int a=another.x-x;
	int b=another.y-y;
	return Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));
	
	
}
public double distance() {
	return distance(0, 0);
	
	
}
public static void main(String[] args) {
	MyPoint p1 = new MyPoint();  // Test constructor
	System.out.println(p1);      // Test toString()
	p1.setX(8);   // Test setters
	p1.setY(6);
	System.out.println("x is: " + p1.getX());  // Test getters
	System.out.println("y is: " + p1.getY());
	p1.setXY(3, 0);   // Test setXY()
	System.out.println(p1.getXY()[0]);  // Test getXY()
	System.out.println(p1.getXY()[1]);
	System.out.println(p1);

	MyPoint p2 = new MyPoint(0, 4);  // Test another constructor
	System.out.println(p2);
	// Testing the overloaded methods distance()
	System.out.println(p1.distance(p2));    // which version?
	System.out.println(p2.distance(p1));    // which version?
	System.out.println(p1.distance(5, 6));  // which version?
	System.out.println(p1.distance());      // which version?
	MyPoint[] points = new MyPoint[10];  // Declare and allocate an array of MyPoint
	for (int i = 0; i < points.length; i++) {
	   points[i] = new MyPoint(i+1,i+1);    // Allocate each of MyPoint instances
	}
	// use a loop to print all the points
	for (int i = 0; i < points.length; i++) {
	    System.out.println(points[i]); 
	}
}
}
