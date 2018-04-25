import java.util.Scanner;
public class CounterCultureTest{
    public static void main(String[] args){
        EdgeWeightedDigraph ed = new EdgeWeightedDigraph(9999999);
        int rn;
        for(int i=1;i<=1000000;i++) {
            rn = reverse(i);
            DirectedEdge de = new DirectedEdge(i,i+1,1.0);
            ed.addEdge(de);
            if(rn>i) {
                de = new  DirectedEdge(i,rn,1.0);
                ed.addEdge(de);
            }
        }
        DijkstraSP sp = new DijkstraSP(ed,1);
        for(int i=2;i<1000000;i++) {
            int dist1 = (int) sp.distTo(i) + 1;
            int dist2 = (int) sp.distTo(i - 1) + 1;
            if (dist2 > dist1)
                System.out.println(i + " " + (dist1));
        }

    }
    public static int reverse(int n) {
        int ans = 0;
        while (n>0) {
            ans += n%10;
            n=n/10;
            if(n>0)
            ans = ans*10;
        }
        return ans;
    }
}