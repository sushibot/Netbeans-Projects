/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexceptions;

/**
 *
 * @author Owner
 */
public class JavaExceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Calling my method...");
        try{ myMethod();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Main is done!");
        }
        
        }
    private static void myMethod() throws Exception
    {
        System.out.println("Calling ProduceError...");
        produceError();
        System.out.println("myMethod is done.");
    }
    private static void produceError ()throws Exception
    {
        String str = "CSCI2912";
        int i = 100;
        if(i<0 || i >=str.length())
            throw new Exception("Invalid position!");
                    else System.out.println(str.charAt(i));
        System.out.println("produceError is done.");
    }
    }

