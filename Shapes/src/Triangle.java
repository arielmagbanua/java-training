public class Triangle extends Shape {
    private XYCoord p2;
    private XYCoord p3;

    public Triangle(XYCoord p1, XYCoord p2, XYCoord p3) {
        super(p1);
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double area() {
        // get the distance between anchor and p2
        double xDifferenceSquares =  Math.pow(Math.abs(p2.getX() - anchor.getX()), 2);
        double yDifferenceSquares =  Math.pow(Math.abs(p2.getY() - anchor.getY()), 2);
        double b = Math.sqrt(xDifferenceSquares + yDifferenceSquares);

        // get the base height, basically distance between x coordinates from either anchor or p2
        // since the anchor and p2 resides in x coordinates
        double hb = Math.abs(p3.getX() - anchor.getX());

        return (hb * b) / 2;
    }

    @Override
    public double circumference() {
        // distance between anchor to p2
        double xDifferenceSquares =  Math.pow(Math.abs(p2.getX() - anchor.getX()), 2);
        double yDifferenceSquares =  Math.pow(Math.abs(p2.getY() - anchor.getY()), 2);
        double a = Math.sqrt(xDifferenceSquares + yDifferenceSquares);

        // distance between anchor to p3
        xDifferenceSquares =  Math.pow(Math.abs(p3.getX() - anchor.getX()), 2);
        yDifferenceSquares =  Math.pow(Math.abs(p3.getY() - anchor.getY()), 2);
        double b = Math.sqrt(xDifferenceSquares + yDifferenceSquares);

        // distance between p2 to p3
        xDifferenceSquares =  Math.pow(Math.abs(p3.getX() - p2.getX()), 2);
        yDifferenceSquares =  Math.pow(Math.abs(p3.getY() - p2.getY()), 2);
        double c = Math.sqrt(xDifferenceSquares + yDifferenceSquares);

        return a + b + c;
    }
}
