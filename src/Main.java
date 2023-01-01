import Strategy.BFS;
import Strategy.DFS;
import structure.Action;
import structure.Initialize;
import structure.Street;
import structure.TransportType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        Action action=new Action();
        BFS bfs=new BFS();
        bfs.search();
//        Street  street=action.getInitialize().getStreets().get(2);
//        System.out.println(action.getHealth(street, TransportType.WALK));
//        System.out.println(action.getInitialize().getStations().size());

    }
}
