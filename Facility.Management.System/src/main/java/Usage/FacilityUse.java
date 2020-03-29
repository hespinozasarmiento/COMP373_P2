package Usage;

import Facility.Facility_Interface;
import Facility.Inspection;
import Client_Detail.Client;



public class FacilityUse implements Use_Interface{
    private Client client;
    private Inspection inspection;

    public void assignFacilityToUse(Client client, Facility_Interface facility) {
        client.usesFacility.add(facility);
    }

    public boolean vacateFacility(Client client, Facility_Interface facility) {
        if (client.usesFacility.contains(facility))
            client.usesFacility.remove(facility);
        return true;
    }

    public void addInspection(Facility_Interface facility, Inspection inspection) {
        facility.addInspection(inspection);
    }

    public void listInspection(Facility_Interface facility) {
        for(Inspection i : facility.getInspections()){
            System.out.println(i.toString());
        }
    }

    public void listActualUsage(Facility_Interface facility) {
        System.out.println(facility.getUsage());
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setInspection(Inspection inspection) {
        this.inspection = inspection;
    }

    public Inspection getInspection() {
        return inspection;
    }


}
