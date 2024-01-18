public class Point {
    int x;
    int y;

    public Point(int a, int b) {
        x = a; y = b;
    }
    public Point() { }
    public void print() {
        System.out.println("Point("+x+","+y+")");
    }

    public boolean equal(Point p) {
        return p.x == x && p.y == y;
    }

    public Point add(Point p) {
        //Point r  = new Point();
        //r.x = x + p.x;
        //r.y = y + p.y;
        // referência para o objecto
        //return r;
        return new Point(x+p.x,y+p.y);
    }
}
