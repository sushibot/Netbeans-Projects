/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3;

/**
 *
 * @author Gabriel Fontanilla
 * 9/17/16
 * CSCI 2913
 */
public class Homework3 {
    
    public static void main(String[] args) 
    {
        //Standard test case of both Statistician Input
        System.out.println("_____[Standard Case]_____");
        Statistician1plus2 S1 = new Statistician1plus2();
        S1.nextNumber(1.1);
        S1.nextNumber(-2.4);
        S1.nextNumber(0.8);
        System.out.println("|Statistician 1|");
        System.out.println("The max number of S1 is: "+S1.getLarge());
        System.out.println("The minimum number of S1 is: "+S1.getSmall());
        System.out.println("The length of S1 is: "+S1.getLength());
        System.out.println("The mean of S1 is: "+S1.getMean());
        System.out.println("The sum of S1 is: "+S1.getSum());
        System.out.println("The last number of S1 is: "+S1.getLastNum());
        System.out.println("------------------------------------"); 
        Statistician1plus2 S2 = new Statistician1plus2();
        S2.nextNumber(5.0);
        S2.nextNumber(9.0);
        S2.nextNumber(5.0);
        System.out.println("|Statistician 2|");
        System.out.println("The max number of S2 is: "+S2.getLarge());
        System.out.println("The minimum number of S2 is: "+S2.getSmall());
        System.out.println("The length of S2 is: "+S2.getLength());
        System.out.println("The mean of S2 is: "+S2.getMean());
        System.out.println("The sum of S2 is: "+S2.getSum());
        System.out.println("The last number of S2 is: "+S2.getLastNum());
        System.out.println("------------------------------------");
        Statistician1plus2 sAdd = Statistician1plus2.add(S1, S2);
        System.out.println("|S1 + S2|");
        System.out.println("The max number of sAdd is: "+ sAdd.getLarge());
        System.out.println("The minimum number of sAdd is: "+sAdd.getSmall());
        System.out.println("The length of sAdd is: "+sAdd.getLength());
        System.out.println("The mean of sAdd is: "+sAdd.getMean());
        System.out.println("The sum of sAdd is: "+sAdd.getSum());
        System.out.println("The last number of sAdd is: "+sAdd.getLastNum());
        System.out.println("\n");
        
        //1st Statistician empty test case, 2nd is not empty
        System.out.println("__[1st Statistician is empty]__");
        Statistician1plus2 E1 = new Statistician1plus2();
        System.out.println("|Empty Statistician|");
        System.out.println("The max number of E1 is: "+E1.getLarge());
        System.out.println("The minimum number of E1 is: "+E1.getSmall());
        System.out.println("The length of E1 is: "+E1.getLength());
        System.out.println("The mean of E1 is: "+E1.getMean());
        System.out.println("The sum of E1 is: "+E1.getSum());
        System.out.println("The last number of E1 is: "+E1.getLastNum());
        System.out.println("--------------------------------");
        Statistician1plus2 NE1 = new Statistician1plus2();
        NE1.nextNumber(7.3);
        NE1.nextNumber(-2.1);
        NE1.nextNumber(4.8);
        System.out.println("|Not empty Statistician|");
        System.out.println("The max number of NE1 is: "+NE1.getLarge());
        System.out.println("The minimum number of NE1 is: "+NE1.getSmall());
        System.out.println("The length of NE1 is: "+NE1.getLength());
        System.out.println("The mean of NE1 is: "+NE1.getMean());
        System.out.println("The sum of NE1 is: "+NE1.getSum());
        System.out.println("The last number of NE1 is: "+NE1.getLastNum());
        System.out.println("---------------------------------");
        System.out.println("|E1 + NE1|");
        Statistician1plus2 sAdd2 = Statistician1plus2.add(E1, NE1);
        System.out.println("The max number of sAdd2 is: "+sAdd2.getLarge());
        System.out.println("The minimum number of sAdd2 is: "+sAdd2.getSmall());
        System.out.println("The length of sAdd2 is: "+sAdd2.getLength());
        System.out.println("The mean of sAdd2 is: "+sAdd2.getMean());
        System.out.println("The sum of sAdd2 is: "+sAdd2.getSum());
        System.out.println("The last number of sAdd2 is: "+sAdd2.getLastNum());
        System.out.println("\n");
        
        //2nd Statistician empty test case, 1st is not empty
        System.out.println("__[2nd Statistician is Empty]__");
        System.out.println("|Not Empty Statistician|");
        Statistician1plus2 NE2 = new Statistician1plus2();
        NE2.nextNumber(45.6);
        NE2.nextNumber(-23.7);
        NE2.nextNumber(17.5);
        System.out.println("The max number of NE2 is:  "+NE2.getLarge());
        System.out.println("The minimum number of NE2 is: "+NE2.getSmall());
        System.out.println("The length of NE2 is: "+NE2.getLength());
        System.out.println("The mean of NE2 is: "+NE2.getMean());
        System.out.println("The sum of NE2 is: "+NE2.getSum());
        System.out.println("The last number of NE2 is: "+NE2.getLastNum());
        System.out.println("-------------------------------------");
        System.out.println("|Empty Statistician|");
        Statistician1plus2 E2 = new Statistician1plus2();
        System.out.println("The max number of E2 is: "+E2.getLarge());
        System.out.println("The minimum number of E2 is: "+E2.getSmall());
        System.out.println("The length of E2 is: "+E2.getLength());
        System.out.println("The mean of E2 is: "+E2.getMean());
        System.out.println("The sum of E2 is: "+E2.getSum());
        System.out.println("The last number of E2 is: "+E2.getLastNum());
        System.out.println("-------------------------------------");
        Statistician1plus2 sAdd3 = Statistician1plus2.add(NE2, E2);
        System.out.println("|NE2+E2|");
        System.out.println("The max number of sAdd3 is: "+sAdd3.getLarge());
        System.out.println("The minimum number of sAdd3 is: "+sAdd3.getSmall());
        System.out.println("The length of sAdd3 is: "+sAdd3.getLength());
        System.out.println("The mean of sAdd3 is: "+sAdd3.getMean());
        System.out.println("The sum of sAdd3 is: "+sAdd3.getSum());
        System.out.println("The last number of sAdd3 is: "+sAdd3.getSum());
        System.out.println("\n");
        
        //Test case for both empty statisticians
        System.out.println("__[Both Statisticians are Empty]__");
        Statistician1plus2 E3 = new Statistician1plus2();
        System.out.println("|1st Empty Statistician|");
        System.out.println("The max number of E3 i: "+E3.getLarge());
        System.out.println("The minimum number of E3 is: "+E3.getSmall());
        System.out.println("The length of E3 is: "+E3.getLength());
        System.out.println("The mean of E3 is: "+E3.getMean());
        System.out.println("The sum of E3 is: "+E3.getSum());
        System.out.println("The last number of E3 is: "+E3.getLastNum());
        System.out.println("-------------------------------------");
        Statistician1plus2 E4 = new Statistician1plus2();
        System.out.println("|2nd Empty Statistician|");
        System.out.println("The max number of E4 is: "+E4.getLarge());
        System.out.println("The minimum number of E4 is: "+E4.getSmall());
        System.out.println("The length of E4 is: "+E4.getLength());
        System.out.println("The mean of E4 is: "+E4.getMean());
        System.out.println("The sum of E4 is: "+E4.getSum());
        System.out.println("The last number of E4 is: "+E4.getLastNum());
        System.out.println("-------------------------------------");
        Statistician1plus2 sAdd4 = Statistician1plus2.add(E3, E4);
        System.out.println("|E3+E4|");
        System.out.println("The max number of sAdd4 is: "+sAdd4.getLarge());
        System.out.println("The minimum number of sAdd4 is: "+sAdd4.getSmall());
        System.out.println("The length of sAdd4 is: "+sAdd4.getLength());
        System.out.println("The mean of sAdd4 is: "+sAdd4.getMean());
        System.out.println("The sum of sAdd4 is: "+sAdd4.getSum());
        System.out.println("The last number of sAdd4 is: "+sAdd4.getLastNum());
        System.out.println("\n");
        
        //1st Statistician test case for 1 item
        System.out.println("__[1st Statistician has 1 item ]__");
        Statistician1plus2 S4 = new Statistician1plus2();
        S4.nextNumber(6.3);
        System.out.println("|1 item Statistician|");
        System.out.println("The max number in S4 is: "+S4.getLarge());
        System.out.println("The minimum number in S4 is: "+S4.getSmall());
        System.out.println("The length of S4 is: "+S4.getLength());
        System.out.println("The mean of S4 is: "+S4.getMean());
        System.out.println("The sum of S4 is: "+S4.getSum());
        System.out.println("The last number of S4 is: "+S4.getLastNum());
        System.out.println("-------------------------------------");
        System.out.println("2nd Statistician");
        Statistician1plus2 S5 = new Statistician1plus2();
        S5.nextNumber(8.9);
        S5.nextNumber(2.5);
        S5.nextNumber(-1.3);
        System.out.println("The max number of S5 is: "+S5.getLarge());
        System.out.println("The minimum number of S5 is: "+S5.getSmall());
        System.out.println("The length of S5 is: "+S5.getLength());
        System.out.println("The mean of S5 is: "+S5.getMean());
        System.out.println("The sum of S5 is: "+S5.getSum());
        System.out.println("The last number of S5 is: "+S5.getLastNum());
        System.out.println("-------------------------------------");
        Statistician1plus2 sAdd5 = Statistician1plus2.add(S4,S5);
        System.out.println("|S4+S5|");
        System.out.println("The max number of sAdd5 is: "+sAdd5.getLarge());
        System.out.println("The minimum number of sAdd5 is: "+sAdd5.getSmall());
        System.out.println("The length of sAdd5 is: "+sAdd5.getLength());
        System.out.println("The mean of sAdd5 is: "+sAdd5.getMean());
        System.out.println("The sum of S5 is: "+sAdd5.getSum());
        System.out.println("The last number of S5 is: "+sAdd5.getLastNum());  
        System.out.println("\n");
        
        System.out.println("Test case for 2 items");
        Statistician1plus2 S6 = new Statistician1plus2();
        S6.nextNumber(-9.2);
        S6.nextNumber(3.5);
        Statistician1plus2 S7 = new Statistician1plus2();
        S7.nextNumber(23.1);
        S7.nextNumber(11.2);
        S7.nextNumber(-1.2);
        Statistician1plus2 sAdd6 = Statistician1plus2.add(S6, S7);
        System.out.println("The maximum number of sAdd6 is: "+sAdd6.getLarge());
        System.out.println("Th minimum number of sAdd6 is: "+sAdd.getSmall());
        System.out.println("The length of sAdd6 is: "+sAdd.getLength());
        System.out.println("The mean of sAdd6 is: "+sAdd6.getMean());
        System.out.println("The sum of sAdd6 is: "+sAdd6.getSum());
        System.out.println("The last number of S5 is: "+sAdd6.getLastNum());
        
        System.out.println("Test case for \"null\"");
        Statistician1plus2 SN1 = new Statistician1plus2();
        SN1.nextNumber(0);
        
        
          
    }
}
