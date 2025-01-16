package model.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadLogin extends Thread {
    
    public void run (){
        while (true){
            System.out.println("Oi Carlos");
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main (String []args)
    {
        new ThreadLogin().start();
    }
}
