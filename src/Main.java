import Strategy.Astar;
import structure.Action;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("select heuristic number: ");
        System.out.println("1-only fast time");
        System.out.println("2-only lower cost");
        System.out.println("3-only higher health ");
        System.out.println("4- fast time - low cost - high health");
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        System.out.println("Enter number :");
        int num=sc.nextInt();
        Astar astar=new Astar(num);
        astar.search();

    }
}
