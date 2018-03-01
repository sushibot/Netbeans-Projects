/********************
 * Gabriel Fontanilla 
 * 10/31/14 
 * 2916 A 
 ********************
 */
package madlibsgf;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class MadLibsGF 
{

   
    
    public static void main(String[] args) throws IOException 
    {
        
        Scanner readFile = new Scanner(new File("madLibs.txt"));
        
       
        while (readFile.hasNext()) 
        {
            
            String read = readFile.nextLine();
            String[] readLine = read.split(" +");
            //System.out.println(read);
           
            for(int i = 0;i<readLine.length;i++)
            {
                char letterOne = readLine[i].charAt(0);
                
                if(Character.isLetter(letterOne))
                        {
                            System.out.print(" "+readLine[i]);
                        }
                else if (readLine[i].charAt(0)=='_')
                {
                    
                
                
               switch (readLine[i])
                 {
                     case  "_noun_":
                         readLine[i]=noun();
                         System.out.println(" "+readLine[i]);
                         break;
                         
                     case "_exclamation_":
                         readLine[i]=exclamation();
                         System.out.println(" "+readLine[i]);
                         break;
                         // System.out.println(exclamation());
                     
                     case "_actionVerb":
                         readLine[i]=actionVerb();
                         System.out.println(" "+readLine[i]);
                         break;
                      //   System.out.println(actionVerb());
                     
                     case "_adverb_":
                         readLine[i]=adverb();
                         System.out.println(" "+readLine[i]);
                         break;
                         //System.out.println(adverb());
                     
                     case  "_adjective_":
                         readLine[i]=adjective();
                         
                         while(readLine[i].matches(readLine[i-2]))
                         {
                             readLine[i]=adjective();
                         }
                         System.out.println(" "+readLine[i]);
                         break;
                        // System.out.println(adjective());
                         
                     case "_animal_":
                         readLine[i]=animal();
                         System.out.println(" "+readLine[i]);
                         break;
                        // System.out.println(animal());
                         
                         
                 }
             
                }
            }
         }
     }


    public static String noun()//method for choosing a noun
    {
        Random bag = new Random();
        String[] someNouns = {"Alter", "Jason", "Shark", "Dick", "Hemp", "Master Cheif", "Suzies", "Emma Watson"};
        int randomChoice = bag.nextInt(6);
        return someNouns[(randomChoice)];
    }

   public static String exclamation()//method for choosing an exclamation
    {
        Random bag = new Random();
        String[] someExclamation = {"Holy geezus", "HOLY RED HERRING", "Oh Lawd!", "Holy Balls!", "WTF", "Damn Son"};
        int randomChoice = bag.nextInt(6);
        return someExclamation[(randomChoice)];
    }
    

    public static String actionVerb() //method for choosing an action verb
    {
        Random bag = new Random();
        String[] someActionVerb = {"Squeeze", "jerks", "lift", "murder", "touch", "sex"};
        int randomChoice = bag.nextInt(6);
        return someActionVerb[(randomChoice)];
    }

    public static String adverb()//method for choosing an adverb
    {
        Random bag = new Random();
        String[] someAdverb = {"ferociously", "mockingly", "dramatically", "faithfully", "fatally", "totally"};
        int randomChoice = bag.nextInt(6);
        return someAdverb[(randomChoice)];
    }

    public static String adjective()//method for choosing an adjective
    {
        Random bag = new Random();
        String[] someAdjective = {"pleasent", "witty", "moaning", "ancient", "demonic", "salty"};
        int randomChoice = bag.nextInt(6);
        return someAdjective[(randomChoice)];
    }

    public static String animal()//method for choosing an animal
    {
        Random bag = new Random();
        String[] someAnimal = {"Cock", "Mongoose", "Humuhumunukunukuapua\'a", "gorilla", "wilderbeast", "mosquito"};
        int randomChoice = bag.nextInt(6);
        return someAnimal[(randomChoice)];
    }

    public String halloweentreats()//method for choosing halloween treats
    {
        Random bag = new Random();
        String[] someTreats = {"cocaine", "ecstasy", "birth-control", "cough syrup", "weed", "halo-halo"};
        int randomChoice = bag.nextInt(6);
        return someTreats[(randomChoice)];
    }
}
