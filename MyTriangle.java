package ex2;

public class MyTriangle {
private MyPoint v1;
private MyPoint v2;
private MyPoint v3;
public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
	this.v1 = v1;
	this.v2 = v2;
	this.v3 = v3;
}
public MyTriangle(int x1,int y1,int x2,int y2,int x3,int y3) {
	this.v1= new MyPoint(x1,y1);
	this.v2= new MyPoint(x2, y2);
	this.v3 = new MyPoint(x3, y3);
	
	
}
@Override
public String toString() {
	return "MyTriangle [v1=(" +v1.getX()+","+v1.getY()  + "), v2=(" + v2.getX()+","+v2.getY() + "), v3=(" + v3.getX()+","+v3.getY() + ")]";
}
public double getPerimeter() {
	return v1.distance(v2)+v2.distance(v3)+v3.distance(v1);
	
}
public String getType() {
    double AB = v1.distance(v2);
    double BC = v2.distance(v3);
    double AC = v3.distance(v1);

    if (AB == BC && AB == AC) {
        return "Equilateral";  // Tam giác đều
    } else if (AB == AC || BC == AC || AB == BC) {
        return "Isosceles";    // Tam giác cân
    } else {
        return "Scalene";      // Tam giác thường
    }
}
public static void main(String[] args) {
	MyTriangle t1 = new MyTriangle(0, 0, 3, 0, 0, 4);
    System.out.println(t1);  // MyTriangle [v1=(0,0), v2=(3,0), v3=(0,4)]
    
    System.out.println("Chu vi tam giác: " + t1.getPerimeter()); // 12.0
    System.out.println("Loại tam giác: " + t1.getType()); // Tam giác vuông cân
}
}


