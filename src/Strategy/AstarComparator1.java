package Strategy;


import structure.State;

import java.util.Comparator;

//depend on total of time and health and many
public class AstarComparator1 implements Comparator<State> {

    int num;
    @Override
    public int compare(State s1, State s2) {
        if (s1.getTotalCost() < s2.getTotalCost())
            return 1;
        else if (s1.getTotalCost() > s2.getTotalCost())
            return -1;
        return 0;
    }

}
