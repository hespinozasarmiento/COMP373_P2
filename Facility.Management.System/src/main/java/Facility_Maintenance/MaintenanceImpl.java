package Facility_Maintenance;

import Facility.Facility_Interface;


public class MaintenanceImpl implements Maintenance {
    private String Id;
    private String Type;
    private double Cost;
    private Facility_Interface facility;

    public MaintenanceImpl(){
        this.Id = null;
        this.Type = null;
        this.Cost = 0.0;
    }

    public MaintenanceImpl(String id, String type, double cost){
        this.Id = id;
        this.Type = type;
        this.Cost = cost;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setCost(double cost){
        Cost = cost;
    }

    public double getCost(){
        return Cost;
    }

    public void setFacility(Facility_Interface facility) {
        this.facility = facility;
    }

    public Facility_Interface getFacility() {
        return facility;
    }
}
