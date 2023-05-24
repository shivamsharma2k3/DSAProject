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

    public void insertEdge(int source, int destination, int distance){
        Node src = new Node(source);
        Node dest = new Node(destination);
        graph[src.id].add(new Edges(distance,src,dest));
    }
    public void shortest_path(String curr, String dest){
        System.out.println(curr+" "+dest);
    }

    public void dijkstrasAlgo(int src,  int destination, int V) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> intermediaryNodes = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        priorityQueue.add(new Pair(src, 0));
        while (!priorityQueue.isEmpty()) {
            Pair curr = priorityQueue.remove();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                for (Edges e : graph[curr.node]) {
                    Node u = e.source;
                    Node v = e.destination;
                    if (dist[u.id] + e.distance < dist[v.id]) {
                        dist[v.id] = dist[u.id] + e.distance;
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(u.id);
                        temp.add(v.id);
                        intermediaryNodes.add(temp);
                        priorityQueue.add(new Pair(v.id, dist[v.id]));
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
            for (ArrayList<Integer> nodes : intermediaryNodes) {
                if (nodes.get(1) == current) {
                    current = nodes.get(0);
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


