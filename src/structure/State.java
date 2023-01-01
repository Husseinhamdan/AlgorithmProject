package structure;

import java.util.List;
import java.util.Objects;

public class State {
    Station station;
    Student student;
    State Parent;
    List<State> states;
    TransportType transportType;
    double TotalCost;


    public State(Station station, Student student, TransportType type) {
        this.station = station;
        this.student = student;
        this.transportType = type;
        this.TotalCost = 0;

    }

    public void printState() {
        System.out.println("Station Name: " + station.getName());
        System.out.println("Health: " + student.getHealth());
        System.out.println("Many: " + student.getMany());
        System.out.printf("time: %.2f\n" , student.getTime());
        if (this.getTransportType() == TransportType.SERVICE_BUS)
            System.out.println("Transport Type: Service Bus");
        else if (this.getTransportType() == TransportType.TAXI)
            System.out.println("Transport Type: Taxi");
        else System.out.println("Transport Type: Walk");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Double.compare(state.TotalCost, TotalCost) == 0 &&
                station.equals(state.station) &&
                student.equals(state.student) &&
                Parent.equals(state.Parent) &&
                states.equals(state.states) &&
                transportType == state.transportType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(station, student, Parent, states, transportType, TotalCost);
    }

    public State(State state) {
        this(state.station, state.student, state.transportType);
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public State getParent() {
        return Parent;
    }

    public void setParent(State parent) {
        Parent = parent;
    }

    public double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(double totalCost) {
        TotalCost = totalCost;
    }
}
