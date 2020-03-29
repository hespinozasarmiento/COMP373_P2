package Main;

import java.util.ArrayList;
import Facility.Facility_Interface;
import Facility.Floors;
import Facility.Inspection;
import Facility.Unit;
import Facility_Maintenance.Maintenance;
import Usage.Use_Interface;
import Usage.MaintenanceUsage_Interface;
import Client_Detail.Address;
import Client_Detail.Client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;


public class Main 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        System.out.println("***************** Application Context Instantiated ******************");
        Address address = (Address) context.getBean("address");
        address.setAddress1("233 S Wacker Dr");
        address.setCity("Chicago");
        address.setCountry("United States");
        address.setId("");
        address.setState("IL");
        address.setZip("60626");
        
        //Using Spring to implement Floors
        Floors floors = (Floors) context.getBean("floors");
        floors.setID("230");
        floors.setHeight(100.0);
        floors.setWidth(100.0);
        floors.setLength(200.0);
        floors.setNumFacility(4);
        floors.setNumRooms(200);
        
        //Using Spring to implement object Facility
        Facility_Interface facility = (Facility_Interface) context.getBean("facility");
        facility.setName("Penthouse");
        facility.setFacilityType("Luxery Apartment");
        facility.setDimensions("5000*5000*50");
        facility.setCapacity(5);
        facility.setAddress(address);
        facility.setUsage(2000.00);
        
        //Use Spring to implement object Unit
        Unit unit = (Unit) context.getBean("unit");
        unit.setId("4");
        unit.setWidth(10.0);
        unit.setHeight(10.0);
        unit.setLength(10.0);
        unit.setType("Penthouse");
        
        //Spring to implement object Client
        Client client = (Client) context.getBean("client");
        client.setId("4");
        client.setFirstName("Henry");
        client.setLastName("Espinoza");
        client.setDateOfBirth("01-01-95");
        client.usesFacility.add(facility);
        
        //Spring to implement object Inspection
        Inspection inspection = (Inspection) context.getBean("inspection");
        inspection.setId("1");
        inspection.setTime("2:00 pm");
        inspection.setSummary("Inspection for broken light:");
        
        //Spring to implement object Maintenance
        Maintenance maintenance = (Maintenance) context.getBean("maintenance");
        maintenance.setId("1");
        maintenance.setType("Broken Light");
        maintenance.setCost(50.00);
        
        Use_Interface use = (Use_Interface) context.getBean("facilityUse");
        use.assignFacilityToUse(client,facility);
        use.addInspection(facility, inspection);
        System.out.println();
        System.out.println("INSPECTIONS FOR FACILITY " + facility.getFacilityInfo());
        use.listInspection(facility);
        System.out.println();
        System.out.println("FACILITIES USED BY PERSON: " + client.getFullName());
        //client.listPersonFacilities();
        System.out.println();
        System.out.println("ACTUAL USAGE FOR FACILITY: " + facility.getFacilityInfo());
        use.listActualUsage(facility);
        MaintenanceUsage_Interface maintenance_Usage = (MaintenanceUsage_Interface) context.getBean("maintenanceUsage");
        maintenance_Usage.makeFacilityMaintRequest(maintenance, facility);
        System.out.println();
        System.out.println("LIST OF MAINTENANCE REQUESTS BY FACILITIES: ");
        maintenance_Usage.listMaintenanceRequest();
        System.out.println();
        System.out.println("LIST OF SCHEDULED MAINTENANCE: ");
        ArrayList<Maintenance> temp = new ArrayList<Maintenance>();
        temp.add(maintenance);
        maintenance_Usage.scheduleMaintenance(facility, temp);
        maintenance_Usage.listMaintenance();
        System.out.println();
        System.out.println();
        System.out.println("MAINTENANCE COST FOR FACILITY: "+facility.getName());
        maintenance_Usage.calcMaintenanceCost(facility);
        maintenance_Usage.calcDownTime(facility);
        System.out.println();
        System.out.println("PROBLEM RATE FOR MAINTENANCE: ");
        maintenance_Usage.calcProblemRate(facility);
        System.out.println();
        System.out.println();
        System.out.println("***************** End Of Program ******************");
    }
}
