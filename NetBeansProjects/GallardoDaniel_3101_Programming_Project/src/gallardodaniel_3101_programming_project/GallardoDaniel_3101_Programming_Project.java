package gallardodaniel_3101_programming_project;

import java.io.*;
import java.util.*;

/**
 *
 * @author Daniel Gallardo
 */
public class GallardoDaniel_3101_Programming_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Enter # of Test Cases:");

        Scanner input = new Scanner(System.in);

        //headerish for the file
        int tCase = input.nextInt();//number of test cases to run:
        System.out.println("Enter # of nodes:");
        int nodes = input.nextInt();//number of nodes to test
        //System.out.println(tCase + "\n");
        //System.out.println(nodes);
        System.out.println("Input node coordinates:");
        /*coordA stores all the coordinates as Point objects consisting of x 
         and y double values. Distances stores the distances from a root Point 
         object to the destination Point object. Visited is a boolean 2D array 
         that is initially all false but then as new nodes are visited changes 
         to true.*/
        Point[] coordA = new Point[nodes];
        double[][] distances = new double[nodes][nodes];
        boolean[] visited = new boolean[nodes];
        double sPathSum = 0;

        //creating the arraylist of arraylists that contain edges
        //and the arraylist of edges
        ArrayList<ArrayList<Edge>> oList = new ArrayList<ArrayList<Edge>>();
        ArrayList<Edge> iList = null;

        // I am mapping the coordinates to the coordA array
        for (int i = 0; i < nodes; ++i) {
            System.out.println("____");
            Point p = new Point();
            p.xCoord = input.nextDouble();
            p.yCoord = input.nextDouble();
            coordA[i] = p;
            System.out.println("____");
        }
        //printing the points out uncomment for testing
//        for (int i = 0; i < nodes; ++i) {
//            System.out.println("(" + coordA[i].xCoord + ","
//                    + coordA[i].yCoord + ")");
//        }

        /*Now I calculate the distance between each Point object to all other
         Point objects and create Edge objects from those Point objects and put 
         each Edge into the inner ArrayList (iList)*/
        Edge e = null;
        for (int i = 0; i < nodes; ++i) {
            iList = new ArrayList<Edge>();
            for (int j = 0; j < nodes; ++j) {

                distances[i][j] = distance2(coordA[i], coordA[j]);

                e = new Edge();
                e.target = j;
                e.weight = distances[i][j];
                iList.add(e);
            }
            oList.add(i, iList);
        }

        /*Prim's algorithm part...look how short this is its crazy apparently,
        Kruskal is even shorter*/
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.addAll(oList.get(0));
        while (!pq.isEmpty()) {
            Edge ed = pq.poll();
            if (visited[ed.target]) {
                continue;
            }
            sPathSum += ed.weight;
            visited[ed.target] = true;
            pq.addAll(oList.get(ed.target));

        }
        System.out.println(sPathSum);
        
        //Test code comment out if you wish.
//        System.out.println("ILIST SIZE:" + iList.size());
//        System.out.println("OLIST SIZE: " + oList.size());
//        for (int i = 0; i < oList.size(); ++i) {
//            System.out.println("oList item: " + i);
//            for (int j = 0; j < iList.size(); ++j) {
//                System.out.println("ELEMENT TARGET: (" + coordA[oList.get(i).get(j).target].xCoord
//                        + ", " + coordA[oList.get(i).get(j).target].yCoord
//                        + ") Distance: " + oList.get(i).get(j).weight);
//            }
//            System.out.println("");
//
//        }

    }//end of main class

    static class Point {

        double xCoord;
        double yCoord;
    }//end of Point class

    /*Class for edges between points. Each Edge object contains the target for
     the edge as well as the distance from the source to the destination which 
     is calculated via the distance method.*/
    static class Edge implements Comparable<Edge> {

        //int from;
        int target;
        double weight;

        /*This override is necessary to implement Comparable. Also the
         Priority Queue I will create will determine the Priority of a Edge
         based on the weight*/
        @Override
        public int compareTo(Edge e) {

            if (this.weight == e.weight) {
                return 0;
            } else if (this.weight > e.weight) {
                return 1;
            } else {
                return -1;
            }
        }
    }//end of Edge class

    //distance method
    public static double distance(double x1, double y1, double x2, double y2) {
        //calculates the distance between two points
        return Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2)));
    }//end of distance method

    /*This method was created after I created the Point object which I did
     not previously. This makes code above a bit shorters*/
    public static double distance2(Point point1, Point point2) {
        return Math.sqrt((Math.pow((point2.xCoord - point1.xCoord), 2))
                + (Math.pow((point2.yCoord - point1.yCoord), 2)));
    }//end of distance 2 method

}
