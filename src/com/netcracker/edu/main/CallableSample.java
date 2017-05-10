package com.netcracker.edu.main;

/**
 * Created by admin on 10.05.2017.
 */
public class CallableSample implements java.util.concurrent.Callable<String> {
//    @Override
//    public void run() {
//
//    }

    @Override
    public String call() throws Exception {

        return Thread.currentThread().toString();
    }
}
