import java.util.*;
public class testing {
      public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int []a = new int[cases];
        int []b = new int[cases];
        int []c = new int[cases];
        for(int i = 0; i<cases; i++){
          a[i]= in.nextInt();
        }
        for(int i = 0; i<cases; i++){
          b[i]= in.nextInt();
        }
        for(int i =0; i<cases; i++)
        {
          c[i]= in.nextInt();
        }
        int fire1 = salCheck(a);
        int fire2 = salCheck(b);
        int fire3 = salCheck(c);
        System.out.println("Case 1: " + fire1);
        System.out.println("Case 2: " +fire2);
        System.out.println("Case 3: "+fire3);

      }
      public static int salCheck(int a[]){
        for(int i = 0; i<a.length; i++){
          if((a[i]>a[i+1]) && (a[i]<a[i+2]))
            return a[i];

          else if((a[i+1]>a[i])&&(a[i+1]<a[i+2]))
          return a[i+1];

          else
          return a[i+2];
      }
      return 0;
}
}
