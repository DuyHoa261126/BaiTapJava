package ex2;

public class MyLine {
private MyPoint begin;
 
private MyPoint end;
public MyLine( ) {
	
	
}
public MyLine(MyPoint begin, MyPoint end) {
	this.begin = begin;
	this.end = end;
}
public MyLine(int x1, int y1, int x2, int y2) {
    this.begin = new MyPoint(x1, y1);
    this.end = new MyPoint(x2, y2);
}
public MyPoint getBegin() {
	return begin;
}
public void setBegin(MyPoint begin) {
	this.begin = begin;
}
public MyPoint getEnd() {
	return end;
}
public void setEnd(MyPoint end) {
	this.end = end;
}
 
public int  getBeginX() {
	return this.begin.getX();
}
public void setBeginX(int x) {
	this.begin.setX(x);
}
public int  getBeginY() {
	return this.begin.getY();
}
public void setBeginY(int y) {
	this.begin.setY(y);
}


public int  getEndX() {
	return this.end.getX();
}
public void setEndX(int x) {
	this.end.setX(x);
}
public int  getEndY() {
	return this.end.getY();
}
public void setEndY(int y) {
	this.end.setY(y);
}

public int [] getBeginXY() {
	return new int[] {begin.getX(),begin.getY()};
	
}
public void setBeginXY(int x,int y) {
	this.begin.setX(x);
	this.begin.setY(y);
	
	
}

public int [] getEndXY() {
	return new int[] {end.getX(),end.getY()};
	
}
public void setEndXY(int x,int y) {
	this.end.setX(x);;
	this.end.setY(y);
	
	
}


public double getLength() {
	
	return begin.distance(end) ;
}
public double getGradient() {
	
	 int yDiff = end.getY() - begin.getY();
    int xDiff = end.getX() - begin.getX();
   return  Math.atan2(yDiff, xDiff);
}

public String toString() { 
	
	return "MyLine[begin=("+begin.getX()+","+begin.getY()+"),end=("+end.getX()+","+end.getY()+")]";
}

public static void main(String[] args) {
	 MyLine line1 = new MyLine(1, 2, 4, 6);
     System.out.println(line1);  // MyLine[begin=(1,2), end=(4,6)]
     
     System.out.println("Length: " + line1.getLength()); // 5.0
     System.out.println("Gradient: " + Math.toDegrees(line1.getGradient())); // ~ 53.13 độ

     line1.setBeginXY(2, 3);
     System.out.println("New Begin: " + line1.getBegin()); // (2,3)
 }
}















