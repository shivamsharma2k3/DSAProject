import java.util.ArrayList;

class Edges {
    int distance;
    int sourceId, destinationId;
    ArrayList<Vehicle> allowedVehicles;
    String instructions;
    String landmarks;

    Edges(int distance,int sourceId, int destinationId,String[] allowedVehicle,String instructions){
        this.distance = distance;
        this.sourceId = sourceId;
        this.destinationId = destinationId;
        this.allowedVehicles = new ArrayList<>();
        for(String txt : allowedVehicle){
            if(txt.compareTo("Walking")==0) allowedVehicles.add(Vehicle.WALKING);
            else if(txt.compareTo("Bicycle")==0) allowedVehicles.add(Vehicle.BICYCLES);
            else allowedVehicles.add(Vehicle.MOTORCARS);
        }
        this.landmarks = "none";
        this.instructions = instructions;
    }
    Edges(Edges edge){
        this.distance = edge.distance;
        this.sourceId = edge.sourceId;
        this.destinationId = edge.destinationId;
        this.allowedVehicles = new ArrayList<>();
        this.allowedVehicles.addAll(edge.allowedVehicles);
        this.landmarks = edge.landmarks;
        this.instructions = edge.instructions;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
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
                ", source=" + sourceId +
                ", destination=" + destinationId +
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
