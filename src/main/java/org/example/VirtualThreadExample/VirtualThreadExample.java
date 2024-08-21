package org.example.VirtualThreadExample;

public class VirtualThreadExample {
    public static void main(String[] args) {
        // Example 1: Create Runnable. Create and start virtual thread
        Runnable runnable = () ->{
            for(int i = 0; i<10; i++){
                System.out.println("Index: " + i);
            }
        };

        Thread vThread1 = Thread.ofVirtual().start(runnable);

        // Example 2: Create but do not start virtual thread
        Thread unstarted = Thread.ofVirtual().unstarted(runnable);

        unstarted.start();

        // How to jon a virtual thread
        try{
            unstarted.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
