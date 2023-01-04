package structure;

import java.util.List;
import java.util.Objects;

public class State {
    Station station;
    Student student;
    State Parent;
    List<State> states;
    TransportType transportType;
    int traveledDistance;
    int Distance;
    int TotalDistance;
    double heuristic = 0;
    double TotalCost;

    public State(Station station, Student student, int totalDistance, TransportType type) {
        this.station = station;
        this.student = student;
        this.transportType = type;
        this.traveledDistance = 0;
        this.Distance = 0;
        this.TotalDistance = totalDistance;
    }

    public void setTraveledDistance() {
        this.traveledDistance = this.getParent().traveledDistance + this.Distance;
    }

    public void setDistance(int distance) {
        this.Distance = distance;
    }

    public void CalcTotalCost(int num) {
        int remainDistance = this.TotalDistance - this.traveledDistance;
        this.setHeuristic(num, remainDistance);
        this.TotalCost = student.getMany()+student.getHealth()+student.getTime() + this.heuristic;
    }

    public void printState() {
        System.out.println("Station Name: " + station.getName());
        System.out.println("Health: " + student.getHealth());
        System.out.println("Many: " + student.getMany());
        System.out.printf("time: %.2f\n", student.getTime());
        if (this.getTransportType() == TransportType.SERVICE_BUS)
            System.out.println("Transport Type: Service Bus");
        else if (this.getTransportType() == TransportType.TAXI)
            System.out.println("Transport Type: Taxi");
        else System.out.println("Transport Type: Walk");
//        System.out.println("Total Distance :" + this.TotalDistance);
//        System.out.println("Travel Distance :" + this.traveledDistance);
//        System.out.println("Distance :" + this.Distance);
//        System.out.println("h: " + this.heuristic);
//        System.out.println("Total Cost:" + this.TotalCost);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return station.equals(state.station) &&
                student.equals(state.student) &&
                Parent.equals(state.Parent) &&
                states.equals(state.states) &&
                transportType == state.transportType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(station, student, Parent, states, transportType);
    }

    public State(State state) {
        this(state.station, state.student, state.TotalDistance, state.transportType);
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

    public void setHeuristic(int num, int remainDistance) {

        switch (num) {
            case 1: {
//                1-only faster time
                this.heuristic = (remainDistance * student.getTime()) / this.traveledDistance;
            }
            break;
            case 2: {
//                2-only lower cost
                this.heuristic = (remainDistance * student.getMany()) / this.traveledDistance;

            }
            break;
            case 3: {
//                3-only higher health
                this.heuristic = (remainDistance * student.getHealth()) / this.traveledDistance;


            }
            break;
            case 4: {
//                4- fast time - low cost - high health
                double time = (remainDistance * student.getTime()) / this.traveledDistance;
                double health = (remainDistance * student.getHealth()) / this.traveledDistance;
                double many = (remainDistance * student.getMany()) / this.traveledDistance;
                this.heuristic = time + health + many;

            }
            break;
        }

    }

    public double getHeuristic() {
        return heuristic;
    }

    public double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(double totalCost) {
        TotalCost = totalCost;
    }
}
