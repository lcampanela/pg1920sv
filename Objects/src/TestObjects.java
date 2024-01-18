public class TestObjects {
    public static void main(String[] args) {
        Point pt = new Point();
        System.out.println(pt.x);   // 0
        pt.x = 10;
        pt.y = 20;
        System.out.println(pt.x);   // 10
        Point p = pt;
        p.x = 30;
        System.out.println(pt.x);   // 30
        Point p1 = new Point();
        p1.x  = 10; p1.y = 20;
        //Point p2 = new Point();
        //p2.x = 20; p2.y = 20;
        Point p2 = new Point(20, 20);
        System.out.println(p.x);    // 30
        System.out.println(p2.x);   // 20

        pt.print();     // Point(30,20)
        p.print();      // Point(30,20)
        p1.print();     // Point(10,20)
        p2.print();     // Point(20,10)

        if(pt==p) System.out.println("== 1");   // ok
        if(p2==p) System.out.println("== 2");   // nok

        if(pt.equal(p2)) System.out.println("== 3");    // nok
        pt.x = 20;
        if(pt.equal(p2)) System.out.println("== 4");    // ok
        if(pt==p2) System.out.println("== 5");          // nok

        Point p3 = pt.add(p2);
        p3.print();     // Point(40,40)
    }
}
