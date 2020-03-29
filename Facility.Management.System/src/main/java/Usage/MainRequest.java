package Usage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import Facility.Facility_Interface;
import Facility_Maintenance.Maintenance;

public class MainRequest implements MaintenanceUsage_Interface{

    private ArrayList<Facility_Interface> facilities = new ArrayList<Facility_Interface>();
    public HashMap<Maintenance,Facility_Interface> maintenanceRequests = new HashMap<Maintenance,Facility_Interface>();
    public HashMap<Facility_Interface, ArrayList<Maintenance>> scheduledMaintenances = new HashMap<Facility_Interface, ArrayList<Maintenance>>();
    private Maintenance maintenance;
    private Facility_Interface facility;

    public MainRequest(){}


    public void makeFacilityMaintRequest(Maintenance maintenance, Facility_Interface facility) {
        maintenanceRequests.put(maintenance, facility);
    }

    public void listMaintenanceRequest() {
        for (Entry<Maintenance, Facility_Interface> entry : maintenanceRequests.entrySet())
            System.out.println("MAINTENANCE TYPE: " + entry.getKey().getType() + " made by FACILITY " + entry.getValue().getFacilityInfo());
    }

    public void scheduleMaintenance(Facility_Interface facility, ArrayList<Maintenance> maintenance) {
        scheduledMaintenances.put(facility,maintenance);
    }

    public void listMaintenance() {
        for (Entry<Facility_Interface, ArrayList<Maintenance>> entry : scheduledMaintenances.entrySet()){
            System.out.println("FACILITY: " + entry.getKey().getFacilityInfo() + "\nREQUESTED FOLLOWING MAINTENANCE(S):");
            for (Maintenance m : entry.getValue()){
                System.out.print(m.getType() + ", ");
            }
        }
    }

    public void calcMaintenanceCost(Facility_Interface facility) {
        double cost = 0.0;
        for (Entry<Facility_Interface, ArrayList<Maintenance>> entry : scheduledMaintenances.entrySet()) {
            if (entry.getKey() == facility) {
                for (Maintenance m : entry.getValue()){
                    cost += m.getCost();}
            }
        }
        System.out.println(cost);
    }

    public void calcProblemRate(Facility_Interface facility) {
        int problemrate = 0;
        for (Entry<Maintenance, Facility_Interface> entry : maintenanceRequests.entrySet()){
            if (entry.getValue() == facility){
                if (entry.getKey().getType() == "Broken Light")
                    problemrate = 2;
                else if (entry.getKey().getType() == "Clogged Toilet")
                    problemrate = 2;
                else if (entry.getKey().getType() == "Pest Infestation")
                    problemrate = 3;
            }
        }
        System.out.println(problemrate);
    }

    public void calcDownTime(Facility_Interface facility) {
        int closed=0;
        for (Entry<Maintenance, Facility_Interface> entry : maintenanceRequests.entrySet()){
            if (entry.getValue() == facility){
                if (entry.getKey().getType() == "Broken Light")
                    closed+=3;
                else if (entry.getKey().getType() == "Clogged Toilet")
                    closed+=4;
                else if (entry.getKey().getType() == "Pest Infestation")
                    closed+=5;
            }
        }
        System.out.println("The facility is closed for "+closed+" hour(s).");
    }

    public void listFacilityProblems(Facility_Interface facility) {
        for (Entry< Facility_Interface , ArrayList<Maintenance>> entry : scheduledMaintenances.entrySet()){
            if (entry.getKey() == facility){
                for (Maintenance m : entry.getValue())
                        System.out.println(m.getType());
            }
        }
    }


    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setFacility(Facility_Interface facility) {
        this.facility = facility;
    }

    public Facility_Interface getFacility() {
        return facility;
    }

    public void setFacilities(ArrayList<Facility_Interface> facilities) {
        this.facilities = facilities;
    }
}