package Usage;

import Facility.Facility_Interface;
import Facility.Inspection;
import Client_Detail.Client;

public interface Use_Interface {
    void assignFacilityToUse(Client client, Facility_Interface facility);
    boolean vacateFacility(Client client, Facility_Interface facility);
    void listInspection(Facility_Interface facility);
    void listActualUsage(Facility_Interface facility);
    void addInspection(Facility_Interface facility, Inspection inspection);

}