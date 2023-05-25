import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Graph graph = new Graph(34);

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to NITK!");
        Node[] nodes = locationInput();
//        for (int i = 0; i < nodes.length; i++) {
//            nodes[i].print();
//        }
        dataInput();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your current location: ");
        String curr = sc.nextLine();
        System.out.print("Enter your destination location: ");
        String dest = sc.nextLine();
        System.out.println("for eg. [Nescafe,Chaitanya,LHC A]");
        System.out.print("Enter the no of intermediate locations you want to visit: ");
        int n = sc.nextInt();
        System.out.println("Enter the intermediate locations: ");
        String[] intermediateLocations = new String[n+2];
        intermediateLocations[0] = curr;
        intermediateLocations[n+1] = dest;
        sc.nextLine();
        for (int i = 1; i <= n; i++) {
            intermediateLocations[i] = sc.nextLine();
        }
        n+=2;
        System.out.println("Enter the mode of transportation{WALKING(0), BICYCLES(1), MOTORCARS(2)}: ");
        int m = sc.nextInt();
        Vehicle mode;
        if(m==0) mode = Vehicle.WALKING;
        else if(m==1) mode = Vehicle.BICYCLES;
        else mode = Vehicle.MOTORCARS;
//         applying dijkstra's algo for all the destination;
        for(int i = 1;i<n;i++){
            System.out.println(intermediateLocations[i-1]+"  "+intermediateLocations[i]+"  "+mode);
            graph.dijkstrasAlgo(mode,Integer.parseInt(intermediateLocations[i-1]), Integer.parseInt(intermediateLocations[i]), 34);
//            graph.shortest_path(intermediateLocations[i-1],intermediateLocations[i]);
        }
    }
    public static Node[] locationInput() throws FileNotFoundException {
        String csvFile = "nodesResponse.csv";
        String line;
        String csvSplitBy = ",";
        int n ;
        Node[] nodes = new Node[0];

        ArrayList<Edges> nodesList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header row
            n = Integer.parseInt(br.readLine());
            br.readLine();
            nodes = new Node[n];
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String locationName = "", workingHour = "", purpose= "", contactDetails = "",isVisitorsAllowed;
                int id;
                id = Integer.parseInt(data[1].substring(0,2));
                locationName = data[1].substring(3);
                workingHour = data[2];
                purpose = data[3];
                isVisitorsAllowed = data[4];
                contactDetails = "Contact Number: "+data[5]+"\nEmail Address: "+data[6]+"\nWebsite: "+data[7];
                nodes[i] = new Node(id,locationName,workingHour,purpose,isVisitorsAllowed,contactDetails);
                i++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        System.out.println("This are some of the locations in NITK");
        for (Node node: nodes) {
            System.out.println(node.toString());
        }
        return nodes;
    }
    public static void dataInput() throws FileNotFoundException {
        String csvFile = "edgesResponse.csv";
        String line;
        String csvSplitBy = ",";

        ArrayList<Edges> edgesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header row
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                int distance = Integer.parseInt(data[1]);
                String[] allowedVehiclesArray = data[2].split(" ");
                String instructions = data[3];
                int sourceNode = Integer.parseInt(""+data[4].charAt(0)+data[4].charAt(1));
                int destinationNode = Integer.parseInt(""+data[5].charAt(0)+data[5].charAt(1));
                String landmarks;
                Edges leftEdge = new Edges(distance,sourceNode,destinationNode,allowedVehiclesArray,instructions);
                Edges rightEdge = new Edges(distance,destinationNode,sourceNode,allowedVehiclesArray,instructions);
                if (data.length >= 6) {
                    landmarks = data[5];
                    leftEdge.setLandmarks(landmarks);
                    rightEdge.setLandmarks(landmarks);
                }
                graph.insertEdge(leftEdge);
                graph.insertEdge(rightEdge);
                edgesList.add(leftEdge);
                edgesList.add(rightEdge);
            }

            // Print the edges
//            for (Edges edge : edgesList) {
//                System.out.println(edge);
//            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
