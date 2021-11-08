public class XYCoord {
    public static final double epsilon = 0.000001;
    private double x;
    private double y;

    public XYCoord(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){return this.x;}
    public double getY(){ return this.y;}
    public double[] getXY(){ return new double[]{this.x, this.y};}

    /** Computes the distance between two points (XYCoord objects)
     *
     * @param other is anopther <code>XYCoord</code> object that is not <code>null</code>.
     * @return the distance between <code>this</code> point and the input point.
     */
    public double distance(XYCoord other){
        return Math.sqrt( (this.x-other.x)*(this.x-other.x) + (this.y-other.y)*(this.y-other.y) );
    }

    /** Checks if a point (XYCoord) is close enough this point (XYCoord) so that
     *  they can be considered the same point.
     *
     * @param other is anopther <code>XYCoord</code> object that is not <code>null</code>.
     * @return true of this and other are essentially the same (with epsilon tolerence), false otherwise.
     */
    public boolean closeTo(XYCoord other){
        return this.distance(other) < epsilon;
    }

    @Override
    public String toString(){
        return String.format("(%.3f,%.3f)", this.x, this.y);
    }
}
