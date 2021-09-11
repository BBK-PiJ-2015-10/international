package concurrency.prodcons.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class TaskRunner {

    public static void main(String[] args) {

        Queue<String> buffer = new ConcurrentLinkedQueue<>();
        Producer producer = new Producer(buffer,true);
        Consumer consumer = new Consumer(buffer,true);

        ExecutorService ec = Executors.newFixedThreadPool(3);

        ec.submit(producer);
        ec.submit(consumer);

        while(true){
            //System.out.println("DOG");
        }



    }



}
