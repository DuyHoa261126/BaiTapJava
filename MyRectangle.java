package ex2;

public class MyRectangle {
private MyPoint topleft;
private MyPoint bottomRight;
public MyRectangle(int x1,int y1,int x2,int y2) {
	this.topleft =new MyPoint(x1, y1);
	this.bottomRight = new MyPoint(x2, y2);
	
	
}
public MyRectangle(MyPoint topleft, MyPoint bottomRight) {
	this.topleft = topleft;
	this.bottomRight = bottomRight;
}
public int getWidth() {
	 return Math.abs(bottomRight.getX()-topleft.getX());
	 
	
}
public int getHeight() {
	return Math.abs( bottomRight.getY()-topleft.getY());
	
}
public int getArea() {
	return getWidth()*getHeight();
	
	
}
public int getPerimeter() {
	
	return 2*((getWidth()+getHeight()));
}
public String toString() {
	
	return "HCN[TopLeft=" + topleft + ", BottomRight=" + bottomRight +
		       ", Width=" + getWidth() + ", Height=" + getHeight() + "]";
}
public static void main(String[] args) {
	
	        MyRectangle rect1 = new MyRectangle(2, 5, 8, 1);
	        System.out.println(rect1);
	        System.out.println("Diện tích: " + rect1.getArea());
	        System.out.println("Chu vi: " + rect1.getPerimeter());

	        MyPoint p1 = new MyPoint(1, 4);
	        MyPoint p2 = new MyPoint(6, 2);
	        MyRectangle rect2 = new MyRectangle(p1, p2);
	        System.out.println(rect2);
	        System.out.println("Diện tích: " + rect2.getArea());
	        System.out.println("Chu vi: " + rect2.getPerimeter());
	    }
	

	
	
	
	
	
	
	
	
	
	
	
	
}

