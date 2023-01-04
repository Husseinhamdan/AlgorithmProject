package Strategy;


import structure.State;

import java.util.Comparator;

//depend on total of time and health and many
public class AstarComparator implements Comparator<State> {
    int num;

    public AstarComparator(int num) {
        this.num = num;
    }

    @Override
    public int compare(State s1, State s2) {
        if (this.num == 1 || this.num==3) {
            if (s1.getTotalCost() > s2.getTotalCost())
                return 1;
            else if (s1.getTotalCost() < s2.getTotalCost())
                return -1;
            else {
                if (s1.getHeuristic() > s2.getHeuristic())
                    return 1;
                else if (s1.getHeuristic() < s2.getHeuristic())
                    return -1;

                return 0;
            }
        } else {
            if (s1.getTotalCost() < s2.getTotalCost())
                return 1;
            else if (s1.getTotalCost() > s2.getTotalCost())
                return -1;
            else {
                if (s1.getHeuristic() < s2.getHeuristic())
                    return 1;
                else if (s1.getHeuristic() > s2.getHeuristic())
                    return -1;

                return 0;
            }
        }
    }

}
