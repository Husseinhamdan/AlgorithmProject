package Strategy;

import structure.State;

import java.util.ArrayList;
import java.util.List;

public class Path {

    List<State> path;

    public Path(State initialNode, State goalNode) {
        path = this.getPath(initialNode, goalNode);
    }


    private List<State> getPath(State initialNode, State goalNode) {
        State tempNode = goalNode;
        List<State> list = new ArrayList<State>();

        while (!(tempNode.equals(initialNode))) {
            list.add(tempNode);
            tempNode = tempNode.getParent();

        }
        list.add(initialNode);
        return list;
    }


    public void printPath() {
        int size = path.size();
        System.out.println("number of steps:" + size);
        for (int i = size - 1; i >= 0; i--) {
            path.get(i).printState();
            System.out.println("--------------------------------");
        }

    }
}
