/******************************************************************************
 *  Compilation:  javac AllPaths.java
 *  Execution:    java AllPaths
 *  Depedencies:  Graph.java
 *  
 *  Find all paths from s to t.
 *  
 *  % java AllPaths
 *  A: B C 
 *  B: A F 
 *  C: A D F 
 *  D: C E F G 
 *  E: D G 
 *  F: B C D 
 *  G: D E 
 * 
 *  [A, B, F, C, D, E, G]
 *  [A, B, F, C, D, G]
 *  [A, B, F, D, E, G]
 *  [A, B, F, D, G]
 *  [A, C, D, E, G]
 *  [A, C, D, G]
 *  [A, C, F, D, E, G]
 *  [A, C, F, D, G]
 *
 *  [B, A, C, D, F]
 *  [B, A, C, F]
 *  [B, F]
 *
 *  Remarks
 *  --------
 *   -  Currently prints in reverse order due to stack toString()
 *
 ******************************************************************************/

public class AllPaths<Vertex> {
    public int count  = 0;
    private Stack<Integer> path  = new Stack<Integer>();   // the current path
    private SET<Integer> onPath  = new SET<Integer>();     // the set of vertices on the path

    public AllPaths(Graph G, int s, int t) {
        enumerate(G, s, t);
    }

    // use DFS
    private void enumerate(Graph G, int v, int t) {

     //   System.out.println("coming "+v+" "+t);
        // add node v to current path from s
        path.push(v);
        onPath.add(v);

        // found path from s to t - currently prints in reverse order because of stack
        if (v==t) {
            count++;
           // System.out.println("["+path+"]");
        }

        // consider all neighbors that would continue path with repeating a node
        else {
            for (int w : G.adj(v)) {
                if (!onPath.contains(w)) enumerate(G, w, t);
            }
        }

        // done exploring from v, so remove from path
        path.pop();
        onPath.delete(v);
    }

    public static void main(String[] args) {
       
    }

}
