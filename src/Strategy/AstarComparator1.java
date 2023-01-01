package Strategy;



import structure.State;

import java.util.Comparator;

public class AstarComparator1 implements Comparator<State> {

    @Override
    public int compare( State s1,State s2) {
//        if (s1.t > s2.getAStarCost())
//            return 1;
//        else if (s1.getAStarCost()< s2.getAStarCost())
//            return -1;
//        else {
//                return 0;
//        }
        return 0;
    }

}
