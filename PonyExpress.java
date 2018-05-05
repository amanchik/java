import java.util.Scanner;
public class PonyExpress{

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++) {
            int n = in.nextInt();
            int q = in.nextInt();
            int[] e = new int[n];
            int[] s = new int[n];
            int[] st = new int[q];
            int[] ends = new int[q];
            int[][] matrix = new int[n][n];
            for(int i=0;i<n;i++){
                e[i] = in.nextInt();
                s[i] = in.nextInt();
            }
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    matrix[i][j] = in.nextInt();
            for(int i=0;i<q;i++)
            {
                st[i] = in.nextInt();
                ends[i] = in.nextInt();
            }
            EdgeWeightedDigraph ed = new EdgeWeightedDigraph(n+1);
            EdgeWeightedDigraph eds = new EdgeWeightedDigraph(n+1);
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++){
                    if(matrix[i-1][j-1]!=-1) {
                        DirectedEdge de = new DirectedEdge(i,j,(1.0*matrix[i-1][j-1]));
                        eds.addEdge(de);
                    }
                }
            for(int i=1;i<=n;i++) {
                DijkstraSP sp = new DijkstraSP(eds,i);
                for (int j = 1; j <= n; j++) {
                    if (sp.hasPathTo(j) && sp.distTo(j) <= e[i - 1]) {
                        DirectedEdge de = new DirectedEdge(i, j,  sp.distTo(j) / s[i - 1]);
                        ed.addEdge(de);
                    }
                }
            }

            System.out.printf("Case #%d:",t);


            for(int i=0;i<q;i++){
                    DijkstraSP sp = new DijkstraSP(ed,st[i]);
                    System.out.printf(" %.15f",sp.distTo(ends[i]));
                }
                System.out.println();
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