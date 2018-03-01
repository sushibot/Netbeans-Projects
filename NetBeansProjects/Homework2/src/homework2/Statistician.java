/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;


public class Statistician 
//initialize variables and hides it
{
 private double small=Double.NaN;
 private double large;
 private double length;
 private double lastNum;
 private double numSum=0;
public Statistician()
{
    length=0;
}
/**
 * nextNumber method takes in any real number and updates variables accordingly
 * @param number Any real number
 */
  public void nextNumber(double number)
{
    this.lastNum=number;
    if (length ==0)
    {
       this.large=number;
       this.small=number;
       length++;
    }
    else
    {
       if(number>large)
       {
           large=number;      
          
       }   
       if(number<small)
       {
           small=number;          
       }             
       length++;
     
    } 
    numSum+=number;
} 
    //returns the large number of the number sequence passed into the class   
  public double getLarge()
  {
    if(length==0) return Double.NaN;    
    else   return large;
  }
  //returns smallest number of the number sequence passed into the class
  public double getSmall()
  {
    if(length==0) return Double.NaN;   
    else  return small;  
  }
  //The sum returns the added number sequence together
  public double getSum()
  {
      return numSum;
  }
  //This method returns the elongation of the number sequence
  public double getLength()
  {
      return length;
  }
  //This method returns the average of the numbers passed into the class
  public double getMean()
  {
   if(length ==0) return Double.NaN;
   else return numSum/(double)length; 
  }
  //This method returns the last number of the sequence
  public double getLast()
  {
      return lastNum;
  }
}


