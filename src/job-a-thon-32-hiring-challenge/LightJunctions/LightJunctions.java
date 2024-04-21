//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    

    /**
     * You have got the job of installing street lights in your city. In your city,
     * there are n junctions (numbered 1 to n), and m directed roads connecting
     * two junctions which is given as 2d integer array Edges where Edges[i]=
     * [x,y] means there exists an directed edge from x to y.
     * You want to install streetlights at these junctions. The street light
     * installed at junction i can light all the junctions j such that there is a way
     * to go from i to j and come back to i from j or if i=j.
     * Each junction has a cost associated with it for the installation purpose.
     * You are given an array Cost[] where Cost[i] represents the cost
     * associated to install light at ith junction. You need to find the minimum
     * cost for lighting all the junctions of the city.
     * 
     * Example 1:
     * Input:
     * N=2
     * M=1
     * Edges[][]={{1,2}}
     * Cost[]={10,20}
     * Output:
     * 30
     * Explanation:
     * We need to install lights at every junction because from junction 1
     * we can go to junction 2 but cannot come back to junction 1 from 2.
     * 
     * Example 2:
     * Input:
     * N=4
     * M=4
     * Edges[][]={{1,2},{2,3},{3,4},{4,1}}
     * Cost[] {10,20,30,40}
     * Output:
     * 10
     * Explanation:
     * We can install a light at the first junction only because it
     * will light up all the other junctions as well.
     * 
     * Your Task:
     * You don't need to read input or print anything. Your task is to complete
     * the function minCost() which takes the integers N the number of
     * junctions, M the number of roads connecting the roads, Edges the 2-d
     * array containing the edges, the cost array Cost and returns the
     * minimum cost you need to light up all the junctions.
     * 
     * Constraints:
     * 2<=N<=5*105
     * 1 <= M,Cost[I] <= 105
     * 1 <= Edges [1][0], Edges [1][1] <= N
     * 
     */
    class LightJunctions {

        public static void main(String[] args) throws IOException {
            int N = 3;
            int M = 3;
            int[][] Edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}};
            int[] Cost = {1, 2, 3, 4};
            System.out.println(minCost(N, M, Edges, Cost));

        }


        // TODO:  Need to rewrite the code to make it work
        public static long minCost(int N, int M, int[][] Edges, int[] Cost) {
            // Create an adjacency list to represent the directed graph
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : Edges) {
                int u = edge[0];
                int v = edge[1];
                adjList.get(u).add(v);
            }
            
            // Perform a depth-first search to find the strongly connected components
            boolean[] visited = new boolean[N + 1];
            Stack<Integer> stack = new Stack<>();
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                   
                    dfs(i, adjList, visited, stack.stream().mapToInt(Integer::intValue).toArray());
                }
            }
            
            // Create a transpose graph by reversing the direction of edges
            List<List<Integer>> transpose = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                transpose.add(new ArrayList<>());
            }
            for (int[] edge : Edges) {
                int u = edge[0];
                int v = edge[1];
                transpose.get(v).add(u);
            }
            
            // Perform a depth-first search on the transpose graph to find the components
            Arrays.fill(visited, false);
            long totalCost = 0;
            while (!stack.isEmpty()) {
                int v = stack.pop();
                if (!visited[v]) {
                    long componentCost = dfs(v, transpose, visited, Cost);
                    totalCost += componentCost;
                }
            }
            
            return totalCost;
        }

        private static long dfs(int v, List<List<Integer>> graph, boolean[] visited, int[] cost) {
            visited[v] = true;
            Stack<Integer> stack = new Stack<>();
            long componentCost = cost[v];
            for (int u : graph.get(v)) {
                if (!visited[u]) {
                    componentCost = Math.min(componentCost, dfs(u, graph, visited, cost));
                }
            }
            return componentCost;
        }
    }


    
    