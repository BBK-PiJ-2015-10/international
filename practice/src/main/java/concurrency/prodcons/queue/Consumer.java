package concurrency.prodcons.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

public class Consumer implements Runnable{

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Queue<String> buffer;

    private boolean onOf;

    public Consumer(Queue<String> queue,boolean onOf) {
        this.buffer = queue;
        this.onOf = true;
    }

    @Override
    public void run() {
        consume();
    }

    public void consume(){
        while (onOf){
            if (!buffer.isEmpty()){
                logger.info(String.format("Queue size is %s",buffer.size()));
                String item = buffer.poll();
                logger.info(String.format("Consumed item %s",item));
            }
        }
    }


}
