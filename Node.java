import java.util.ArrayList;

class Node {
    int id;
    String distance,location_name,working_hours,purpose;
    ArrayList<Node> nearNodes;

    boolean isVisitorsAllowed;
    String contactDetails;

    public Node(int id){
        this.id = id;
    }

    public Node(int id, String location_name, String working_hours, String purpose, boolean isVisitorsAllowed, String contactDetails) {
        this.id = id;
        this.location_name = location_name;
        this.working_hours = working_hours;
        this.purpose = purpose;
        this.isVisitorsAllowed = isVisitorsAllowed;
        this.contactDetails = contactDetails;
    }

    public Node(int id, String distance, String location_name, String working_hours, String purpose, ArrayList<Node> nearNodes, boolean isVisitorsAllowed, String contactDetails) {
        this.id = id;
        this.distance = distance;
        this.location_name = location_name;
        this.working_hours = working_hours;
        this.purpose = purpose;
        this.nearNodes = nearNodes;
        this.isVisitorsAllowed = isVisitorsAllowed;
        this.contactDetails = contactDetails;
    }

    public void print(){
        System.out.println(id+" "+location_name+"\nWorking Hour: "+working_hours+"\nPurpose: "+purpose+"\nisVisitorsAllowed: "+isVisitorsAllowed+"\nContact Details: "+contactDetails);
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(String working_hours) {
        this.working_hours = working_hours;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ArrayList<Node> getNearNodes() {
        return nearNodes;
    }

    public void setNearNodes(ArrayList<Node> nearNodes) {
        this.nearNodes = nearNodes;
    }

    public boolean isVisitorsAllowed() {
        return isVisitorsAllowed;
    }

    public void setVisitorsAllowed(boolean visitorsAllowed) {
        isVisitorsAllowed = visitorsAllowed;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}


