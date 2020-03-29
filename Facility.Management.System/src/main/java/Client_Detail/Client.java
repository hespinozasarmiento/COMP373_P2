package Client_Detail;

import Facility.Facility_Interface;

import java.util.ArrayList;

public interface Client {
    String getId();
    void setId(String id);
    String getFirstName();
    void setFirstName(String FirstName);
    String getLastName();
    void setLastName(String LastName);
    String getFullName();
    ArrayList<Address> getAddress();
    void addAddress(Address address);
    boolean removeAddress(Address address);
    String getDateOfBirth();
    void setDateOfBirth(String DateOfBirth);
    void listPersonFacilities();
    ArrayList<Facility_Interface> usesFacility = new ArrayList<Facility_Interface> ();
}
