public class ShapeExampleApp {
    public static double epsilon = 0.00001;
    public static boolean eq(double x, double y){
        return Math.abs(x-y) < epsilon;
    }

    public static void out(Object o){
        System.out.println(o.toString());
    }


    public static void main(String[] args){
        out("Simple Shape Example Program");
        out("----------------------------");

        XYCoord point = new XYCoord(1.0,1.0);

        // make a rectangle shape

        Shape s = new Rectangle(point, 10, 25);
        out("\nRectangle!");
        out(s.toString());
        out("Rectangle's area = " + s.area());
        out("...expecting 250.0 : " + eq(250,s.area()));
        out("Rectangle's circumference = " + s.circumference());
        out("...expecting 70.0 : " + eq(70,s.circumference()));

        // make a square
        s = new Square(new XYCoord(0,0), 25.5);
        out("\nSquare!");
        out(s.toString());
        out("Square's area = " + s.area());
        out("...expecting 650.25 : " + eq(650.25,s.area()));
        out("Square's circumference = " + s.circumference());
        out("...expecting 102.0 : " + eq(102,s.circumference()));
        out(".is Square a Shape     :" + (s instanceof Shape));
        out(".is Square a Rectangle :" + (s instanceof Rectangle));
        out(".is Square a Square    :" + (s instanceof Square));


        // make a circle
        s = new Circle(new XYCoord(3,1.5), 7.2);
        out("\nCircle!");
        out(s.toString());
        out("Circle's area = " + s.area());
        out("...expecting 162.8601631620949 : " + eq(162.8601631620949,s.area()));
        out("Circle's circumference = " + s.circumference());
        out("...expecting 45.23893421169302 : " + eq(45.23893421169302,s.circumference()));


        // make a triangle
        s = new Triangle(new XYCoord(1,1), new XYCoord(1,3), new XYCoord(2,1));
        out("\nTriangle! (easy case... right angle horizontal base)");
        out(s.toString());
        out("Triangle's area = " + s.area());
        out("...expecting 1.0 : " + eq(1.0,s.area()));
        out("Triangle's circumference = " + s.circumference());
        out("...expecting 5.23606797749979 : " + eq(5.23606797749979,s.circumference()));


        // make a triangle
        s = new Triangle(new XYCoord(1,1), new XYCoord(1,3), new XYCoord(2,1));
        out("\nTriangle! (arbitrary orientation)");
        out(s.toString());
        out("Triangle's area = " + s.area());
        out("...expecting 1.0 : " + eq(1.0,s.area()));
        out("Triangle's circumference = " + s.circumference());
        out("...expecting 5.23606797749979 : " + eq(5.23606797749979,s.circumference()));
    }
}
