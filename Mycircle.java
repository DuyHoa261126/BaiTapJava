package ex2;

public class Mycircle {
 private MyPoint center=new MyPoint(0,0);
 private int radius =1;
public Mycircle() {
	center = new MyPoint();
	this.radius=radius;
}
public Mycircle(int x,int y, int radius) {
	center = new MyPoint(x,y);
	this.radius = radius;
}

public Mycircle(MyPoint center, int radius) {
	this.center = center;
	this.radius = radius;
}
public MyPoint getCenter() {
	return center;
}
public void setCenter(MyPoint center) {
	this.center = center;
}
public int getRadius() {
	return radius;
}
public void setRadius(int radius) {
	this.radius = radius;
}
  public int  getCenterX() {
	  return center.getX();
	  
  }
  public void setCenterX(int x) {
	  this.center.setX(x);
  }
  public int  getCenterY() {
	  return center.getY();
	  
  }
  public void setCenterY(int y) {
	  this.center.setY(y);
  }
  
  public int[]getCenterXY(){
	  return new int [] {center.getX(),center.getY()};
	  
  }
  public void setCenterXY(int x,int y) {
	  this.center.setX(x);
	  this.center.setY(y);
	  
	  
  }
  public String toString() {
	  
	  return "Mycircle[radius="+radius+",center=("+center.getX()+","+center.getY()+")]";
  }
  public double getArea() {
	  
	  return Math.pow(radius, 2)*Math.PI;
  }
  public double getCircumference() {
		
		
		return 2*Math.PI*radius;
	}
  public double distance(Mycircle another) {
	  return center.distance(another.center);
	  
  }
  public static void main(String[] args) {
	
	  // Tạo hai đối tượng MyCircle
      Mycircle c1 = new Mycircle(0, 0, 5);
      Mycircle c2 = new Mycircle(3, 4, 2);

      // Kiểm tra phương thức toString()
      System.out.println(c1); // Mycircle[radius=5,center=(0,0)]
      System.out.println(c2); // Mycircle[radius=2,center=(3,4)]

      // Kiểm tra phương thức getArea() và getCircumference()
      System.out.println("Diện tích của c1: " + c1.getArea()); // 78.54
      System.out.println("Chu vi của c1: " + c1.getCircumference()); // 31.42

      // Kiểm tra phương thức distance()
      System.out.println("Khoảng cách giữa c1 và c2: " + c1.distance(c2)); // 5.0

      // Thay đổi tâm của c1 và bán kính
      c1.setCenterXY(1, 1);
      c1.setRadius(6);
      System.out.println("Sau khi thay đổi, c1: " + c1); // Mycircle[radius=6,center=(1,1)]

      // Kiểm tra lại khoảng cách sau khi thay đổi
      System.out.println("Khoảng cách mới giữa c1 và c2: " + c1.distance(c2));
}
  
  
  
  
  
  
  
  
  
  
  
  
}
