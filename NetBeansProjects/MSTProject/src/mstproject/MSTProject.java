package mstproject;
/*
 * @author Gabriel Fontanilla
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class MSTProject {
    static double calculatedWeight[][];//stores all the calculated weights of each coordinate
    static boolean known[];//true or false if path is known or not
    static double shortestPathTotal;//the output of the mst
    static int nodes;
    static Scanner in;
    static cords c[];//cords object array
    static ArrayList<ArrayList<Edge>> outsideL = new ArrayList<ArrayList<Edge>>();
    //array list used to represent collection of edges
    static ArrayList<Edge> innerL = null;   
    /**
     * This class will contain the coordinates needed to calculate the weight
     * to determine the MST using Prim's algorithm. 
     */
    public static class cords
    {
        double x,y;

        public cords(double x, double y) {
            this.x = x;
            this.y = y;
        }
        public double getX() {
            return this.x;
        }

        public double getY() {
            return this.y;
        }  
    }  
    /**
     * This class is needed to determine the distance from source to destination
     * by using the weight method.
     */
    public static class Edge implements Comparable<Edge>
    {//start edge class
        int dest;
        double weight;    
        @Override //Needed to implement Comparable for compareTo.
            public int compareTo(Edge e) {
                if (this.weight == e.weight) 
                {
                    return 0;
                } else if (this.weight > e.weight) 
                {
                return 1;
            } else {
                return -1;
            }
        }
    }//end edge class
    public static void main(String[] args) throws Exception { //main start 
           in = new Scanner(System.in);
   int numTestCase = in.nextInt();//takes in the number of test cases that are to be solved
   /**
    * This for loop will set the sizes of the arrays and will 
    * iterate x number of times according to the number of test cases
    * in order to solve for the MST.
    */
        for (int i = 0; i < numTestCase; i++) 
        {/////for loop start     
    nodes = in.nextInt();//stores the size of the array of nodes
    c = new cords[nodes];//builds an array of size n
    calculatedWeight= new double [nodes][nodes]; //builds a 2d array of size n
    shortestPathTotal = 0;   
    intoArray();
    Navigation();       
        }//////or loop end
        MST();
    }//main end
  /**
   * The Navigation method will be used to determine the distance between each coordinate.
   * It will also store those values into the ArrayList.
   */
    public static void Navigation()
    {
         Edge edge = null;
            for (int j = 0; j < nodes; j++) 
            {
            innerL = new ArrayList<Edge>();
                for (int k = 0; k < 2; k++) 
                {
                  calculatedWeight[j][k]=weight(c[j],c[k]);
                  edge = new Edge();
                  edge.dest =j;
                  edge.weight =  calculatedWeight[j][k];
                  innerL.add(edge);
                }
                  outsideL.add(j,innerL);
            } 
    }
         /**
        * The following method will stuff each of the points into 
        * an array.
        */
    public static void intoArray()
    {
          for (int o = 0; o < nodes; o++) 
        {
            cords point = new cords(in.nextDouble(),in.nextDouble());
            point.x = in.nextDouble();
            point.y = in.nextDouble();
            c[o]=point;
        }
    }
    /**
     * The following method will be used to determine the Minimum
     * spanning tree of the nodes and will contain Prim's algorithm
     * which is essential to figuring out the MST.
     */
    public static void MST()
    {
  
    known= new boolean[nodes];
    /**
     * Priority queue is used to pull first point from list to solve
     * for MST using prims
     */
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            queue.addAll(outsideL.get(0));
            
            while(!queue.isEmpty())
            {
                /**
                 * This will remove any edges from the list and add calculated 
                 * weight to the Minimum Spanning Tree
                 */
                Edge to = queue.remove();
                if(known[to.dest]){continue;}
                shortestPathTotal += to.weight;
                known[to.dest] = true;
                queue.addAll(outsideL.get(to.dest));
            }
            System.out.println(shortestPathTotal);   
    }
    /** 
     * @param n1 x coordinate value
     * @param n2 y coordinate value
     * @return calculated weight between two points aka two freckles
     */
    public static double weight(cords n1, cords n2)
    {//start weight
     return Math.sqrt((Math.pow((n2.x - n1.x), 2)) + (Math.pow((n2.y - n1.y), 2)));
    }//end weight   
    }//////////////////////////////////////////END PROJECT///////////////////////////////////////////////////////