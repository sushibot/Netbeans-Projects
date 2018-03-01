 package mst_prim;

import java.io.*;
import java.util.*;

/* Name: Candace Farris 
 * Date: 4/21/17 
 * Task: UVA Freckles with Prim implementation
 */
public class MST_Prim {

    public static void main(String[] args) throws IOException {

        //No need for user prompt

        Scanner read = new Scanner(System.in);
        int testCase = read.nextInt(); // # of test cases
        
        for (int z = 1; z <= testCase; z++) {//start test case
            int nodes = read.nextInt(); //number of nodes

            /**********************************
             *
             * Coordinates are stored as Freckle objects (x, y). Distances
             * stores the distance from root to destination. Entered = false
             * until new nodes are entered.
             *
             *********************************/
            
            //list of coordinates
            Freckle[] coord = new Freckle[nodes];
            double[][] totalDist = new double[nodes][nodes];
            boolean[] entered = new boolean[nodes];
            double pathTotal = 0;

            /**********************************
             *
             * Creating the ArrayList of ArrayLists that contain edges as well
             * as the ArrayList of edges
             *
             *********************************/
            
            ArrayList<ArrayList<Edge>> outerList = new ArrayList<ArrayList<Edge>>();
            ArrayList<Edge> innerList = null;
            //Inner is the array coordinates per freckle

            //Enter the coord into the new array
            for (int i = 0; i < nodes; ++i) {
                Freckle point = new Freckle();
                point.x = read.nextDouble();
                point.y = read.nextDouble();
                coord[i] = point;
            }

        /**********************************
        *
        * Calculate the distance b/w each freckle object and make Edge objects
        * from those distances and store into an ArrayList
        *
        *********************************/
        
        Edge edge = null;
            for (int i = 0; i < nodes; ++i) {
                innerList = new ArrayList<Edge>();
                for (int j = 0; j < nodes; ++j) {
                    if (i == j) {
                        totalDist[i][j] = 0;
                        //otherwise compute the distance
                    } else {
                        //totalDist[i][j] = coord[i].distance(coord[j]);
                        totalDist[i][j] = distance(coord[i], coord[j]);
                    }
                        edge = new Edge();
                        edge.target = j;
                        edge.weight = totalDist[i][j];
                        innerList.add(edge);
                    
                }
                outerList.add(i, innerList); //add to outer list
            }
    
        /**********************************
         *
         * Prim Algorithm
         *
         *********************************/
        
        //Got a lot of help from Daniel, Paul, and Gary for Prim
        
        PriorityQueue<Edge> pq = new PriorityQueue<>(); //switch to lengthy
        pq.addAll(outerList.get(0));
        while (!pq.isEmpty()) {
            Edge E = pq.remove(); //remove the head
            if (entered[E.target]) {
                continue;
            }
            pathTotal += E.weight;
            entered[E.target] = true;
            pq.addAll(outerList.get(E.target)); //add target to pq

        }
        System.out.printf("%.2f\n", pathTotal);
        if(z<testCase){
            System.out.println("");
        } 
    }//End of Test Case For-Loop 
        
        
    }/*******************************************************************
     * 
     *          -------------------END OF MAIN------------------
     * 
     ********************************************************************/

    /**********************************
     *
     * Freckle Class Used to create points
     *
     **********************************/
    
    static class Freckle {
        double x;
        double y;

    }//end of Freckle class
    
    /**********************************
     *
     * Distance Method calculates the distance between two points
     *
     *********************************/
    
    public static double distance(Freckle point1, Freckle point2) {
        return Math.sqrt((Math.pow((point2.x - point1.x), 2)) + (Math.pow((point2.y - point1.y), 2)));
    }

    /**********************************
     *
     * Edge Class
     * For edges between points. Contains both the target and totalDist from
     * the source to the destination. Distance method implemented.
     *
     *********************************/
        
        static class Edge implements Comparable<Edge> {

            int target;
            double weight;

            @Override //Necessary to implement Comparable for compareTo.
            public int compareTo(Edge e) {

                if (this.weight == e.weight) {
                    return 0;
                } else if (this.weight > e.weight) {
                return 1;
            } else {
                return -1;
            }
        }
    } //End of Edge Class
}
