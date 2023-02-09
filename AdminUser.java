import java.util.ArrayList;
import java.util.Date;
// ... imports class definition...

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<>();

    public AdminUser(Integer id, String role) {
        super(id);
        this.role = role;
        //TODO Auto-generated constructor stub
    }


    // TO DO: Implement a constructor that takes an ID and a role

    public void newIncident(String notes) {
        String report = String.format(
                "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
                new Date(), this.id, notes);
        securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
                "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
                new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
        securityIncidents.add(report);
    }
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!

    @Override
    public ArrayList<String> reportSecurityIncidents() {
        // TODO Auto-generated method stub

        return securityIncidents;
    }

    @Override
    public boolean assignPin(int pin) {
        // TODO Auto-generated method stub
        int length = String.valueOf(pin).length();
        if (length == 6) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        // TODO Auto-generated method stub
        if (confirmedAuthID == this.getId()) {
            return true;
        } else {
            authIncident();
            return false;
        }
    }

    // TO DO: Setters & Getters

    public Integer getEmployeeID() {
        return this.employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return this.securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }

}