package com.netcracker.edu.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread 1 start");
        Thread thread = new Thread();
        thread.setName("Second");
        System.out.println(Thread.currentThread());
        thread.start();
        Thread.sleep(100);
        System.out.println("Thread 1 fin");

//        ExecutorService es1= Executors.newFixedThreadPool(5);
//        Future<String> f1 = es1.submit(new CallableSample());
//        while(!f1.isDone()) {
//            Thread.sleep(100);
//        }
//        try {
//            System.out.println("task completed : " + f1.get());
//        } catch (InterruptedException ie) {
//            ie.printStackTrace(System.err);
//        } catch (ExecutionException ee) {
//            ee.printStackTrace(System.err);
//        }
//        es1.shutdown();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Thread 2 start");
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 fin");
        }
    }

    static class MyRunable implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread 2 start");
            System.out.println(Thread.currentThread());
            try {
                Thread.sleep(95);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 fin");
        }
    }
}
