package structure;

import java.util.Objects;

public class Station {
    int num;
    String Name;
    double BusWaitTime;
    double TaxiWaitTime;


    public Station(int num, String name, double busWaitTime, double taxiWaitTime) {
        this.num = num;
        this.Name = name;
        this.BusWaitTime = busWaitTime;
        this.TaxiWaitTime = taxiWaitTime;


    }

    public Station(Station station) {
        this(station.getNum(),station.getName(),station.getBusWaitTime(),station.getTaxiWaitTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return num == station.num &&
                Double.compare(station.BusWaitTime, BusWaitTime) == 0 &&
                Double.compare(station.TaxiWaitTime, TaxiWaitTime) == 0 &&
                Objects.equals(Name, station.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, Name, BusWaitTime, TaxiWaitTime);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getBusWaitTime() {
        return BusWaitTime;
    }

    public void setBusWaitTime(double busWaitTime) {
        BusWaitTime = busWaitTime;
    }

    public double getTaxiWaitTime() {
        return TaxiWaitTime;
    }

    public void setTaxiWaitTime(double taxiWaitTime) {
        TaxiWaitTime = taxiWaitTime;
    }
}
