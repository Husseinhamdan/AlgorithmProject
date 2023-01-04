package structure;

import java.util.ArrayList;
import java.util.List;

public class Action {

    Initialize initialize;


    public Action() {
        initialize = new Initialize();
    }

    public double getMoveTime(Street street, TransportType type) {
        double distance = street.getDistance();
        double speed = 0;
        if (type == TransportType.SERVICE_BUS) {
            speed = street.getBusSpeed();
        } else if (type == TransportType.TAXI) {
            speed = street.getTaxiSpeed();
        } else {
            speed = street.getStudentSpeed();
        }
        double time = distance / speed;
        return time;
    }

    public int getHealth(Street street, TransportType type) {
        int health = 0;
        if (type == TransportType.SERVICE_BUS) {
            health = -5 * street.getDistance();

        } else if (type == TransportType.TAXI) {
            health = +5 * street.getDistance();
        } else {
            health = -10 * street.getDistance();
        }
        return health;
    }

    public int getMany(Street street, TransportType type) {
        int many = 0;
        if (type == TransportType.SERVICE_BUS) {
            many = 400;

        } else if (type == TransportType.TAXI) {
            many = 1000 * street.getDistance();
        } else {
            many = 0;
        }
        return many;
    }

    public List<State> getNext(State state) {

        List<State> getNext = new ArrayList<>();
        // next station
        int num = state.getStation().getNum() + 1;
        Station NextStation = this.initialize.getStations().get(num);
        // next Street
        int numStreet = state.getStation().getNum();
        Street Nextstreet = this.initialize.getStreets().get(numStreet);
//        bre Street
        Street breStreet = this.initialize.getStreets().get(numStreet - 1);
//        Student of Current State
        Student currStudent = state.getStudent();
//     check if can use Bus or taxi
        if (Nextstreet.isIfTransport()) {
            //State 1 Transport service Bus
            int many1 = 0;
            double time1 = 0;
            if (state.getTransportType() == TransportType.SERVICE_BUS && breStreet.getServiceBus().getName().equals(Nextstreet.getServiceBus().getName())) {

                many1 = currStudent.getMany();
                time1 = currStudent.getTime() + getMoveTime(Nextstreet, TransportType.SERVICE_BUS);


            } else {
                many1 = currStudent.getMany() - getMany(Nextstreet, TransportType.SERVICE_BUS);
                time1 = currStudent.getTime() + getMoveTime(Nextstreet, TransportType.SERVICE_BUS) + state.getStation().getBusWaitTime();


            }
            int health1 = currStudent.getHealth() + getHealth(Nextstreet, TransportType.SERVICE_BUS);

            if (health1 > 0 && health1 <= 100 && many1 > 0 && many1 <= getStartState().getStudent().getMany()) {
                Student student1 = new Student(many1, health1, time1);
                State state1 = new State(NextStation, student1, TransportType.SERVICE_BUS);
                state1.setParent(state);
                getNext.add(state1);

            }
            // State 2  Transport Taxi
            int many2 = currStudent.getMany() - getMany(Nextstreet, TransportType.TAXI);
            int health2 = currStudent.getHealth() + getHealth(Nextstreet, TransportType.TAXI);
            double time2;
            if (state.getTransportType() == TransportType.TAXI) {

                time2 = currStudent.getTime() + getMoveTime(Nextstreet, TransportType.TAXI);


            } else {
                time2 = currStudent.getTime() + getMoveTime(Nextstreet, TransportType.TAXI) + state.getStation().getTaxiWaitTime();


            }

            if (health2 > 0 && health2 <= 100 && many2 > 0 && many2 <= getStartState().getStudent().getMany()) {
                Student student2 = new Student(many2, health2, time2);
                State state2 = new State(NextStation, student2, TransportType.TAXI);
                state2.setParent(state);
                getNext.add(state2);
            }
        }
        // State 3 Transport Walk
        int many3 = currStudent.getMany() - getMany(Nextstreet, TransportType.WALK);
        int health3 = currStudent.getHealth() + getHealth(Nextstreet, TransportType.WALK);
        double time3 = currStudent.getTime() + getMoveTime(Nextstreet, TransportType.WALK);
//        System.out.println("health: "+health3+" "+"many: "+many3+" "+"time: "+time3);
        if (health3 > 0 && health3 <= 100 && many3 > 0 && many3 <= getStartState().getStudent().getMany()) {
            Student student3 = new Student(many3, health3, time3);
            State state3 = new State(NextStation, student3, TransportType.WALK);
            state3.setParent(state);
            getNext.add(state3);
        }
        return getNext;
    }

    public State getStartState() {
        Station station = getInitialize().getStations().get(1);
        Student student = new Student(1000, 100, 0);
        State state = new State(station, student, TransportType.WALK);
        return state;
    }

    public boolean isGoalState(State GoalState, State StarState) {
        if (GoalState.getStation().getNum() == 8) {
            if (GoalState.getStudent().getMany() <= StarState.getStudent().getMany()) {
                if (GoalState.getStudent().getHealth() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public Initialize getInitialize() {
        return initialize;
    }

    public void setInitialize(Initialize initialize) {
        this.initialize = initialize;
    }
}
