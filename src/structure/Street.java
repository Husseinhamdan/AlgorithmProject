package structure;

public class Street {
    private int distance;
    private Station station1;
    private Station station2;
    private boolean ifTransport;
    private double BusSpeed;
    private double TaxiSpeed;
    private double StudentSpeed;
    private ServiceBus serviceBus;
    private Taxi taxi;
    private Walk walk;


    public Street(Station station1, Station station2,int distance,boolean ifTransport) {
        this.station1 = station1;
        this.station2 = station2;
        this.ifTransport=ifTransport;
        this.distance=distance;
        this.BusSpeed=80;
        this.TaxiSpeed=100;
        this.StudentSpeed=5.5;
    }
    public Street(Street street){
        this(street.getStation1(),street.station2,street.getDistance(),street.ifTransport);
    }
    public Station getFirstStation(){
        return this.station1;
    }
    public Station getSecondStation(){
        return this.station2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Station getStation1() {
        return station1;
    }

    public void setStation1(Station station1) {
        this.station1 = station1;
    }

    public Station getStation2() {
        return station2;
    }

    public void setStation2(Station station2) {
        this.station2 = station2;
    }

    public boolean isIfTransport() {
        return ifTransport;
    }

    public void setIfTransport(boolean ifTransport) {
        this.ifTransport = ifTransport;
    }

    public double getBusSpeed() {
        return BusSpeed;
    }

    public void setBusSpeed(int busSpeed) {
        BusSpeed = busSpeed;
    }

    public double getTaxiSpeed() {
        return TaxiSpeed;
    }

    public void setTaxiSpeed(int taxiSpeed) {
        TaxiSpeed = taxiSpeed;
    }

    public ServiceBus getServiceBus() {
        return serviceBus;
    }

    public void setServiceBus(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public Walk getWalk() {
        return walk;
    }

    public void setWalk(Walk walk) {
        this.walk = walk;
    }

    public double getStudentSpeed() {
        return StudentSpeed;
    }

    public void setStudentSpeed(float studentSpeed) {
        StudentSpeed = studentSpeed;
    }
}
