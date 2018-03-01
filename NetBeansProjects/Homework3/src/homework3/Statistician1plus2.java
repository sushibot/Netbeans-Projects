
package homework3;
/**
 *
 * @author Owner
 */
public class Statistician1plus2 {
    //initializes variables and encrypts each number
 private double small=Double.NaN;
 private double large;
 private double length;
 private double lastNum;
 private double numSum=0;
public Statistician1plus2()
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
  public double getLastNum()
  {
      if(length == 0) return Double.NaN;
      return lastNum;
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
  /**
   * Method takes in two Statistician objects and compares them with each other
   * If 1st Statistician has 0 length, store 2nd Statistician into parameter S
   * If 2nd Statistician has 0 length, store 1st Statistician into Parameter S
   * If both Statisticians have 0 length, return S
   * If both Statisticians have input, compare both and store either one into S 
   * @param H1 Takes in 1 Statistician object 
   * @param H2 Takes in another Statistician object
   * 
   */
  public static Statistician1plus2 add(Statistician1plus2 H1, Statistician1plus2 H2)
  {
      Statistician1plus2 S = new Statistician1plus2();
 
    if((H1.getLength()!=0&&H2.getLength()==0))
     {
         S.large=H1.getLarge();
         S.small=H1.getSmall();
         S.length=H1.getLength();
         S.numSum=H1.getSum();
         S.lastNum=H1.getLastNum();
     }     
    else if((H1.getLength()==0&&H2.getLength()!=0))
    {
        S.large=H2.getLarge();
        S.small=H2.getSmall();
        S.length=H2.getLength();
        S.numSum=H2.getSum();
        S.lastNum=H2.getLastNum();
    }
    else if((H1.getLength()==0&&H2.getLength()==0)){       
          return S;       
    }
    else
    {
        if(H1.getLarge()>H2.getLarge())
            S.large=H1.getLarge();
        if (H2.getLarge()>H1.getLarge())
            S.large=H2.getLarge();
        if(H1.getSmall()<H2.getSmall())
            S.small=H1.getSmall();
        if(H2.getSmall()<H1.getSmall())
            S.small=H2.getSmall();       
      S.length=H1.getLength()+H2.getLength();
      S.numSum=H1.getSum()+H2.getSum();
      S.lastNum=H2.getLastNum();
    }
    return S;
  }
}