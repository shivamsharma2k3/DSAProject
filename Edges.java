import java.util.ArrayList;

class Edges {
    int distance;
    Node source,destination;
    ArrayList<Vehicle> allowedVehicles;
    String instructions;
    String landmarks;

    public Edges(int distance, Node source, Node destination) {
        this.distance = distance;
        this.source = source;
        this.destination = destination;
        this.allowedVehicles = new ArrayList<>();
        allowedVehicles.add(Vehicle.WALKING);
        allowedVehicles.add(Vehicle.BICYCLES);
        allowedVehicles.add(Vehicle.MOTORCARS);
        this.landmarks = "none";
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public ArrayList<Vehicle> getAllowedVehicles() {
        return allowedVehicles;
    }

    public void setAllowedVehicles(ArrayList<Vehicle> allowedVehicles) {
        this.allowedVehicles = allowedVehicles;
    }

    public String getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(String landmarks) {
        this.landmarks = landmarks;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Edges{" +
                "distance=" + distance +
                ", source=" + source +
                ", destination=" + destination +
                ", allowedVehicles=" + allowedVehicles +
                ", instructions='" + instructions + '\'' +
                ", landmarks='" + landmarks + '\'' +
                '}';
    }
}
enum Vehicle {
    WALKING,
    BICYCLES,
    MOTORCARS
}
