import java.util.ArrayList;

class Node {
    int id;
    String location_name,working_hours,purpose;

    String isVisitorsAllowed;
    String contactDetails;

    public Node(int id){
        this.id = id;
    }

    public Node(int id, String location_name, String working_hours, String purpose, String isVisitorsAllowed, String contactDetails) {
        this.id = id;
        this.location_name = location_name;
        this.working_hours = working_hours;
        this.purpose = purpose;
        this.isVisitorsAllowed = isVisitorsAllowed;
        this.contactDetails = contactDetails;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", location_name='" + location_name + '\'' +
                '}';
    }
}


