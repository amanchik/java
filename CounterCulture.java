import java.util.Scanner;
public class CounterCulture{
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
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++) {
            int n = in.nextInt();
            int ans =(int)sp.distTo(n)+1;
            System.out.println("Case #"+t+": "+ans);
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