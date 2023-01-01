package Strategy;


import structure.Action;
import structure.State;

import java.util.*;

public class Astar {
    Action action;
    int many;
    int depthTree;
    public PriorityQueue<State> pQueue;
    public HashMap<Integer, State> visited;
    Scanner sc = new Scanner(System.in);    //System.in is a standard input stream

    public Astar(int many) {
        this.many=many;
        action=new Action();
        visited = new HashMap<Integer, State>();
        this.depthTree = 1;

    }

    public int getDepthTree() {

        return depthTree;
    }

    public void setDepthTree(int depthTree) {
        if (depthTree > this.depthTree) {
            this.depthTree = depthTree;
        }
    }

    public void setPQueue(Comparator c) {

        pQueue = new PriorityQueue<State>(c);
    }

    public boolean search() {
//        long startTime = System.nanoTime();
//        State node =action.getStartState(many);
//        setPQueue(new AstarComparator1());
//        pQueue.add(node);
//        while (!(pQueue.isEmpty())) {
//            node = pQueue.poll();
//            setDepthTree(node.getDepth());
//            visited.put(node.hashCode(), node);
//            if (action.isGoal(node, goal)) {
//                node.printGrid();
//                System.out.println("*********** AStar ************");
//                System.out.println("number of visited node: " + visited.size());
//                System.out.println("solution depth :" + node.getDepth());
//                long endTime = System.nanoTime();
//                long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
//                double durationInSecond = (double) durationInNano / 1000000000;
//                System.out.println("time of execution:" + durationInSecond + " seconds.");
//                System.out.println("cost of path : " + node.getMaxCost());
//                System.out.println("depth tree =" + this.getDepthTree());
//                System.out.println("---------------------------------------------------------");
//                System.out.println("******** Path ************");
//                System.out.println("print path: 1-yes   2-no");
//                int select = sc.nextInt();
//                if (select == 1) {
//                    Path path = new Path(start, node);
//                    path.printPath();
//
//                }
//                return true;
//            }
//            List<Grid> list = action.getNext(node);
//            for (Grid temp : list) {
//                boolean ans = visited.containsKey(temp.hashCode());
//                // if not in open and close
//                if (ans == false && !pQueue.contains(temp)) {
//                    pQueue.add(temp);
//                }
////                open condition
//                else if (pQueue.removeIf(grid -> (grid.hashCode() == temp.hashCode() && grid.getMaxCost() > temp.getMaxCost()))) {
//                    pQueue.add(temp);
//                }
////                close condition
//                else if (ans == true && visited.get(temp.hashCode()).getMaxCost() > temp.getMaxCost()) {
//                    visited.get(temp.hashCode()).setAStarCost(temp.getAStarCost());
//                    visited.get(temp.hashCode()).setParent(temp.getParent());
//                } else continue;
//            }
//        }
        return false;
    }


}
