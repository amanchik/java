import java.util.Scanner;
public class DiamondInheritance{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=1;t<=T;t++) {
            int n = in.nextInt();
            Graph g = new Graph(n+1);
            for(int i=1;i<=n;i++) {
                int m = in.nextInt();
                for(int j=0;j<m;j++) {
                    int nm = in.nextInt();
                    g.addEdge(i,nm);
                }
            }
            boolean yes = false;
            for(int i=1;i<=n;i++)
            {
                DepthFirstSearch search = new DepthFirstSearch(g, i);
                if(search.twice) {
                    yes = true;
                    break;
                }

            }
                if(yes)
            System.out.println("Case #"+t+": Yes");
            else
                    System.out.println("Case #"+t+": No");

        }

    }

}