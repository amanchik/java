import java.util.Scanner;
public class SwingingWild{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++) {
            int n = in.nextInt();
            int D;
            int[] d = new int[n+1];
            int[] l = new int[n+1];
            for(int i=0;i<n;i++)
            {
                d[i]= in.nextInt();
                l[i] = in.nextInt();
            }
            D=in.nextInt();

            d[n]=D;
            l[n]=0;

            Graph g = new Graph((n+1)*(n+1));

            for(int i=1;i<n;i++) {
                int cf = i-1;
                int cg = i+1;
                while (cf>=0&&cg<=n){
                    if(l[cf]<d[i]-d[cf]){
                        cf--;
                        continue;
                    }
                    int p = min(l[i],d[i]-d[cf]);
                    while (cg<=n&&d[i]+p>=d[cg]){
                        g.addEdge(cf*(n+1)+i,i*(n+1)+cg);
                        if(cg==n){
                            g.addEdge(i*(n+1)+cg,(n+1)*(n+1)-1);
                        }
                        cg++;
                    }
                    cf--;
                }
                if(d[i]<=2*d[0]) {
                    g.addEdge(0,i);
                }
            }
            if(d[n]<=2*d[0]) {
                g.addEdge(0,(n+1)*(n+1)-1);
            }
            if(t==6)
            System.out.println(g);
            DepthFirstSearch search = new DepthFirstSearch(g, 0);

            if(search.marked((n+1)*(n+1)-1))
            System.out.println("Case #"+t+": YES");
            else
            System.out.println("Case #"+t+": NO");

        }

    }
    public static int  min(int a,int b){
        return a>b?b:a;
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