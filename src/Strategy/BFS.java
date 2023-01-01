package Strategy;

import structure.Action;
import structure.State;

import java.util.*;

public class BFS {
    Action action;
    State start;
    int depthTree;
    public Queue<State> queue;
    public HashMap<Integer, State> visited;
    Scanner sc = new Scanner(System.in);    //System.in is a standard input stream

    public BFS() {
        this.action = new Action();
        this.start = action.getStartState();
        queue = new LinkedList<State>();
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

    public boolean search() {
        long startTime = System.nanoTime();
        State node = start;
        queue.add(node);

        while (!(queue.isEmpty())) {
            node = queue.remove();
            node.printState();
            System.out.println("---------------------------------------");
            visited.put(node.hashCode(), node);
            if (action.isGoalState(node, start)) {
                System.out.println("yes");
                node.printState();
                System.out.println("***********BFS************");
                long endTime = System.nanoTime();
                long durationInNano = (endTime - startTime);  //Total execution time in nano seconds
                double durationInSecond = (double) durationInNano / 1000000000;
                System.out.println("time of execution:" + durationInSecond + " seconds.");
                System.out.println("---------------------------------------------------------");
                System.out.println("******** Path ************");
                System.out.println("print path: 1-yes   2-no");
                int select = sc.nextInt();
                if (select == 1) {
                    Path path = new Path(start, node);
                    path.printPath();

                }
                return true;
            }

            List<State> list = action.getNext(node);
            for (State temp : list) {
                boolean ans = visited.containsKey(temp.hashCode());
                if (ans == false) {
                    if (!(queue.contains(temp))) {
                        queue.add(temp);
                    }

                }
            }

        }

        return false;


    }
}



