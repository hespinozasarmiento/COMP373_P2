package Facility;
import Client_Detail.Address;
import java.util.ArrayList;


public interface Facility_Interface {
    void listUnits();
    String getFacilityInfo();
    int getAvailableCapacity();
    boolean addNewUnit(Unit unit);
    void addFacilityDetail(String detail);
    boolean removeUnit(Unit unit);
    ArrayList<Inspection> getInspections();
    void addInspection(Inspection inspection);
    double getUsage();
    void setUsage(double use);
    String getName();
    void setName(String name);
    String getFacilityType();
    void setFacilityType(String facilityType);
    String getDimensions();
    void setDimensions(String dimensions);
    Address getAddress();
    void setAddress(Address address);
    void setCapacity(int capacity);

}
