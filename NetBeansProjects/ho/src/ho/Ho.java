package ho;
import java.util.Scanner;

  class makeThread extends Thread{
     static Thread t;
    static String threadName;

    makeThread(String name){
        threadName =name;
        System.out.println("Created"+threadName);
    }
    
    /**
     * This method will execute whatever this thread will do
     */
    
    public void run(){
        System.out.println("Running this thread: "+threadName);
        try{
            for (int i = 1; i<17; i++) {
                System.out.println("Running: "+threadName);
                Thread.sleep(500);
            }
        }catch (InterruptedException e){
            System.out.println("Thread: " + threadName + " interrupted.");
            } 
        System.out.println("Exiting out of "+threadName);
    }
  }

public class Ho {
    public static void main (String[]args) throws InterruptedException{
          makeThread t1 = new makeThread("Thread_1");
          makeThread t2 = new makeThread("Thread_2_");
          t1.start();
          t1.join();
          
          t2.start();
          t2.join();
          
    
      }
}
