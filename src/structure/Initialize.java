package structure;

import java.util.HashMap;

public class Initialize {


    HashMap<Integer, Station> stations;
    HashMap<Integer, Street> streets;
    ServiceBus serviceBus1, serviceBus2;
    int serviceBusCost;
    int taxiCost;
    int walkCost;

    public Initialize() {
        this.stations=new HashMap<>();
        this.streets=new HashMap<>();
        this.serviceBusCost=400;
        this.taxiCost=1000;
        this.walkCost=0;
        InitializeStation();
        InitializeStreet();
        InitializeTransport();
    }

    //    Initialize Station
    public void InitializeStation() {
        stations.put(1, new Station(1,"collage", 0.083, 0.016));
        stations.put(2, new Station(2,"Parking", 0.16, 0.083));
        stations.put(3, new Station(3,"bab sharqi", 0.16, 0.083));
        stations.put(4, new Station(4,"bab toma", 0.083, 0.083));
        stations.put(5, new Station(5,"sahet alabaseen", 0.03, 0));
        stations.put(6, new Station(6,"karagat alabaseen", 0.25, 0.083));
        stations.put(7, new Station(7,"adra", 0, 0.083));
        stations.put(8, new Station(8,"my home", 0, 0));
    }

    //    Initialize Streets
    public void InitializeStreet() {
        streets.put(1, new Street(stations.get(1), stations.get(2), 1, false));
        streets.put(2, new Street(stations.get(2), stations.get(3), 2, true));
        streets.put(3, new Street(stations.get(3), stations.get(4), 2, true));
        streets.put(4, new Street(stations.get(4), stations.get(5), 3, true));
        streets.put(5, new Street(stations.get(5), stations.get(6), 1, true));
        streets.put(6, new Street(stations.get(6), stations.get(7), 7, true));
        streets.put(7, new Street(stations.get(7), stations.get(8), 1, false));

    }

    //   Initialize Transport
    public void InitializeTransport() {
        // Service Bus
        serviceBus1 = new ServiceBus("Dwel3ah karagt", serviceBusCost);
        serviceBus2 = new ServiceBus("adra karagt", serviceBusCost);
        streets.get(2).setServiceBus(serviceBus1);
        streets.get(3).setServiceBus(serviceBus1);
        streets.get(4).setServiceBus(serviceBus1);
        streets.get(5).setServiceBus(serviceBus1);
        streets.get(6).setServiceBus(serviceBus2);
//        Taxi
        Taxi taxi = new Taxi(taxiCost);
        streets.get(2).setTaxi(taxi);
        streets.get(3).setTaxi(taxi);
        streets.get(4).setTaxi(taxi);
        streets.get(5).setTaxi(taxi);
        streets.get(6).setTaxi(taxi);
//        Walk
        Walk walk = new Walk(walkCost);
        streets.get(1).setWalk(walk);
        streets.get(2).setWalk(walk);
        streets.get(3).setWalk(walk);
        streets.get(4).setWalk(walk);
        streets.get(5).setWalk(walk);
        streets.get(6).setWalk(walk);
        streets.get(7).setWalk(walk);



    }

    public HashMap<Integer, Station> getStations() {
        return stations;
    }

    public void setStations(HashMap<Integer, Station> stations) {
        this.stations = stations;
    }

    public HashMap<Integer, Street> getStreets() {
        return streets;
    }

    public void setStreets(HashMap<Integer, Street> streets) {
        this.streets = streets;
    }

    public ServiceBus getServiceBus1() {
        return serviceBus1;
    }

    public void setServiceBus1(ServiceBus serviceBus1) {
        this.serviceBus1 = serviceBus1;
    }

    public ServiceBus getServiceBus2() {
        return serviceBus2;
    }

    public void setServiceBus2(ServiceBus serviceBus2) {
        this.serviceBus2 = serviceBus2;
    }

    public int getServiceBusCost() {
        return serviceBusCost;
    }

    public void setServiceBusCost(int serviceBusCost) {
        this.serviceBusCost = serviceBusCost;
    }

    public int getTaxiCost() {
        return taxiCost;
    }

    public void setTaxiCost(int taxiCost) {
        this.taxiCost = taxiCost;
    }

    public int getWalkCost() {
        return walkCost;
    }

    public void setWalkCost(int walkCost) {
        this.walkCost = walkCost;
    }
}
