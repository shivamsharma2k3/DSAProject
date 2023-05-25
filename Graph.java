import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {
    private ArrayList<Edges>[] graph;

    Graph(int n){
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edges>();
        }
    }


    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair(int node,int dist){
            this.dist = dist;
            this.node = node;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist-p2.dist;
        }
    }

    public void insertEdge(Edges edge){
        graph[edge.sourceId].add(new Edges(edge));
    }
    public void shortest_path(String curr, String dest){
        System.out.println(curr+" "+dest);
    }

    public void dijkstrasAlgo(Vehicle mode,int src,  int destination, int V) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        ArrayList<Edges> intermediaryNodes = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        priorityQueue.add(new Pair(src, 0));
        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                for (Edges e : graph[curr.node]) {
                    boolean  isThisWayAvailable = false;
                    for(Vehicle vv : e.allowedVehicles){
                        if(vv.compareTo(mode)==0)  isThisWayAvailable = true;
                    }
                    if(!isThisWayAvailable) continue;
                    int u = e.sourceId;
                    int v = e.destinationId;
                    if (dist[u] + e.distance < dist[v]) {
                        dist[v] = dist[u] + e.distance;
                        intermediaryNodes.add(e);
                        priorityQueue.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        System.out.println("Shortest path from Node " + src + " to Node " + destination + ":");
        System.out.println("Distance: " + dist[destination]);
        System.out.print("Path: ");
        Stack<Integer> pathStack = new Stack<>();
        int current = destination;
        while (current != src) {
            pathStack.push(current);
            for(Edges edge : intermediaryNodes){
                if(edge.destinationId==current) {
                    current = edge.sourceId;
                    break;
                }
            }
        }
        System.out.print(src + " ");
        while (!pathStack.isEmpty()) {
            System.out.print(pathStack.pop() + " ");
        }
        System.out.println();
    }
}


