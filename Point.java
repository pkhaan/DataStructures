
//Class Point for Processing Geometrical Methods and Elements
class Point {
    double x, y;
    Point() { x = Math.random(); y = Math.random(); }
     Point(double x, double y) {this.x = x;this.y = y;}
     double r() { return Math.sqrt(x*x + y*y); }
     double theta() { return Math.atan2(y, x); }
     double distance(Point p) {
    	 double dx = x - p.x, dy = y - p.y;
    	 return Math.sqrt(dx*dx + dy*dy); }
     public String toString() {
    	 return "(" + x + "," + y + ")"; }
}