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
//         applying dijkstra's algo for all the destination;
        for(int i = 1;i<n;i++){
            System.out.println(intermediateLocations[i-1]+"  "+intermediateLocations[i]);
            graph.dijkstrasAlgo(Integer.parseInt(intermediateLocations[i-1]), Integer.parseInt(intermediateLocations[i]), 34);
//            graph.shortest_path(intermediateLocations[i-1],intermediateLocations[i]);
        }
    }
    public static Node[] locationInput() throws FileNotFoundException {
        String data = "", locationName = "", workingHour = "", purpose= "", contactDetails = "";
        boolean isVisitorsAllowed = true;
        System.out.println("This are some of the locations in NITK");
        File myObj = new File("src/locations.txt");
        Scanner myReader = new Scanner(myObj);
        if(myReader.hasNextLine()) data = myReader.nextLine();
        int n = Integer.parseInt(data);
        Node[] nodes = new Node[n];
        int i = 0;
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            if(myReader.hasNextLine()) workingHour = myReader.nextLine();
            if(myReader.hasNextLine()) purpose = myReader.nextLine();
            if(myReader.hasNextLine()) isVisitorsAllowed = Boolean.parseBoolean(myReader.nextLine());
            if(myReader.hasNextLine()) contactDetails = myReader.nextLine();
            nodes[i] = new Node(Integer.parseInt(data.substring(0,2)),data.substring(3),workingHour,purpose,isVisitorsAllowed,contactDetails);
            i++;
        }
        myReader.close();
        return nodes;
    }
    public static void dataInput() throws FileNotFoundException {
        String csvFile = "src/edgesResponse.csv";
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

                Node source = new Node(sourceNode);
                Node destination = new Node(destinationNode);

                Edges edge = new Edges(distance, source, destination);

                // Set allowed vehicles
                for (String vehicle : allowedVehiclesArray) {
                    switch (vehicle) {
                        case "WALKING":
                            edge.getAllowedVehicles().add(Vehicle.WALKING);
                            break;
                        case "BICYCLES":
                            edge.getAllowedVehicles().add(Vehicle.BICYCLES);
                            break;
                        case "MOTORCARS":
                            edge.getAllowedVehicles().add(Vehicle.MOTORCARS);
                            break;
                    }
                }

                // Set instructions and landmarks if available
                edge.setInstructions(instructions);
                if (data.length >= 6) {
                    String landmarks = data[5];
                    edge.setLandmarks(landmarks);
                }

                graph.insertEdge(sourceNode, destinationNode, distance);
                edgesList.add(edge);
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
