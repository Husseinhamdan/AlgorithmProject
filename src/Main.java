import Strategy.Astar;
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
//        BFS bfs=new BFS();
//        bfs.search();
        Astar astar=new Astar();
        astar.search();

    }
}
