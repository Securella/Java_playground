import java.io.*;
import java.util.*;

// This class extends "Thread" class
// to execute code in "run" method
// in a new thread 
public class StopWatch extends Thread {
    // Field for elapsed time in ms
    private int ElapsedTime = 0;

    @Override
    public void run() {
        do {
            try {
                // Wait 10ms
                Thread.sleep(10);
            } catch (InterruptedException ie) { // If thread is interrupted
                System.err.println("Error: " + ie.getMessage());
            }
            ElapsedTime += 10;
            System.out.println("Stopwatch thread. Elapsed: " + (ElapsedTime / 1000.) + " seconds.");
        } while (ElapsedTime < 60000); // Until elapsed time reaches 60000ms = 60s
    }
    
    public static void main(String[] args) throws InterruptedException {
        // Create new thread object
        Thread thread = new StopWatch();
        System.out.println("Main thread. Waiting for stopwatch thread...");
        // Starting the execution of thread
        thread.start();
        // Invoking method join, to wait until the new Thread is finished
        // If this method is not executed, current thread will continue to work,
        // not waiting for new thread to finish
        thread.join();
        // If Thread.join() isn't invoked, message below will be printed immediately
        System.out.println("Main thread. Finished stopwatch thread.");
    }
}
