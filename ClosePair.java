import java.util.*;

class Point {
        double x;
        double y;
        public Point(double x, double y) {
                this.x =x;
                this.y =y;
        }
}
class ClosPa {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[36m";
                public double p1;
           public double p2;
           public double p3;
           public double p4;
        public double cloPaFind() {
                Point[] poi = new Point[5];
                poi[0]=new Point(2,3);
                poi[1]=new Point(12,3);
                poi[2]=new Point(4,5);
                poi[3]=new Point(5,1);
                poi[4]=new Point(6,2);


                 double d=99999;
                 double d1;
                for(int i =0;i<4;i++) {
                        for(int j=i+1;j<5;j++) {
                                d1=Math.sqrt(Math.pow((poi[j].x-poi[i].x),2)+Math.pow((poi[j].y-poi[i].y),2));
                                d=Math.min(d,d1);
                                System.out.printf("The distance between the points "+RED+"(%d,%d)"+RESET+" and "+RED+"(%d,%d) "+RESET+"is "+GREEN+"%2.2f\n"+RESET,(int)poi[i].x,(int)poi[i].y,(int)poi[j].x,(int)poi[j].y,d1);

                                if(d == d1) {
                                        p1=poi[j].x;
                                        p2=poi[j].y;
                                        p3=poi[i].x;
                                        p4=poi[i].y;
                                }
                        }
                }
                return d;


        }
}

public class ClosePair {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
        public static void main(String[] args) {
                ClosPa cp = new ClosPa();
                double dis = cp.cloPaFind();
                System.out.println("============================================================================");
                System.out.printf("The minimum distance between the points "+GREEN+"(%d,%d)"+RESET+" and "+GREEN+"(%d,%d)"+RESET+ "is "+RED+"%2.2f\n"+RESET,(int)cp.p1,(int)cp.p2,(int)cp.p3,(int)cp.p4,dis);

        }
}