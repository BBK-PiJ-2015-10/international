package codility.deutsche;

import java.util.Optional;

public class PointAnalyzer {


    public static boolean overlap(int distance, Point a, Point b) {
        var xa = a.x;
        var ya = a.y;
        var xb = b.x;
        var yb = b.y;
        var xal = xa - distance;
        var xah = xa + distance;
        var yal = ya - distance;
        var yah = ya + distance;

        var xbl = xb - distance;
        var xbh = xb + distance;
        var ybl = yb - distance;
        var ybh = yb + distance;

        //compare x
        if (xal >= xbl && xal <= xbh || xah >= xbl && xah <= xbh) {
            System.out.println("Found an overlapping point in x");
            if (yal >= ybl && yal <= ybh || yah >= ybl && yah <= ybh) {
                System.out.println("Found an overlapping point in y");
                return true;
            }
        }
        return false;
    }

    public static Optional<Boolean> overlap2(int distance, Point a, Point b) {
        var xa = a.x;
        var ya = a.y;
        var xb = b.x;
        var yb = b.y;
        var xal = xa - distance;
        var xah = xa + distance;
        var yal = ya - distance;
        var yah = ya + distance;

        var xbl = xb - distance;
        var xbh = xb + distance;
        var ybl = yb - distance;
        var ybh = yb + distance;

        //compare x
        if (xal == xbl && xal <= xbh || xah == xbl && xah <= xbh) {
            System.out.println("Found an overlapping point in x");
            if (yal == ybl && yal <= ybh || yah == ybl && yah <= ybh) {
                System.out.println("Found an overlapping point in y");
                return Optional.of(false);
            }
        }
        if (xal > xbl && xal <= xbh || xah > xbl && xah <= xbh) {
            System.out.println("Found an overlapping point in x");
            if (yal >= ybl && yal <= ybh || yah >= ybl && yah <= ybh) {
                System.out.println("Found an overlapping point in y");
                return Optional.of(true);
            }
        }

        return Optional.empty();
    }



}
