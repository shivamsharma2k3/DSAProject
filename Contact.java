public class Contact {
    String name,email;
    int contactNumber;

    public Contact(String name, String email, int contactNumber) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void printDetails(){
        String temp = "Name: "+name+"\nEmail: "+email+"\nPhone: "+contactNumber+"\n";
        System.out.println(temp);
    }
}
