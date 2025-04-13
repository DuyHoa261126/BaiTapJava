package ex7;

import java.util.ArrayList;
import java.util.List;

public class PolyLine {
private  List<Point> Points;

public PolyLine() {
	Points = new ArrayList<Point>();
}

public PolyLine(List<Point> points) {
	this.Points = points;
}
public void appendPoint(int x,int y) {
	Point newPoint= new Point(x,y);
	Points.add(newPoint);
	
}
public void appendPoint (Point point) {
	Points.add(point);
	
}
public String toString() {
    // Use a StringBuilder to efficiently build the return String
    StringBuilder sb = new StringBuilder("{");
    for (Point aPoint : Points) {
        sb.append(aPoint.toString());
    }
    sb.append("}");
    return sb.toString();
 }
public double getLength() {
	double totalLength =0.0;
	for(int i=0;i<Points.size();i++) {
		totalLength+=Points.get(i-1).distance(Points.get(i));
		
	}
	return totalLength;
}
public static void main(String[] args) {
	
	// Test default constructor and toString()
    PolyLine l1 = new PolyLine();
    System.out.println(l1);  // {}

    // Test appendPoint()
    l1.appendPoint(new Point(1, 2));
    l1.appendPoint(3, 4);
    l1.appendPoint(5, 6);
    System.out.println(l1);  // {(1,2)(3,4)(5,6)}

    // Test constructor 2
    List<Point> points = new ArrayList<Point>();
    points.add(new Point(11, 12));
    points.add(new Point(13, 14));
    PolyLine l2 = new PolyLine(points);
    System.out.println(l2);  // {(11,12)(13,14)}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
