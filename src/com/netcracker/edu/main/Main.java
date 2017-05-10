package com.netcracker.edu.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("Thread 1 start");
//        Thread thread = new Thread(new MyRunable());
//        thread.setName("Second");
//        System.out.println(Thread.currentThread());
//        thread.start();
//        Thread.sleep(100);
//        System.out.println("Thread 1 fin");

        //создать ExecutorService как пул из пяти потоков
        ExecutorService es1= Executors.newFixedThreadPool(5);
//поместить задачу в очередь на выполнение
        Future<String> f1 = es1.submit(new CallableSample());
        while(!f1.isDone()) {//подождать выполнения задачи
        }
        try { //получить результат выполнения задачи
            System.out.println("task completed : " + f1.get());
        } catch (InterruptedException ie) {
            ie.printStackTrace(System.err);
        } catch (ExecutionException ee) {
            ee.printStackTrace(System.err);
        }
        es1.shutdown();
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
