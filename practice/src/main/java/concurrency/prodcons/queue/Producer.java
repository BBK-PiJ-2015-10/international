package concurrency.prodcons.queue;

import java.util.Queue;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private Logger logger = Logger.getLogger(Producer.class.getName());

    private Queue<String> buffer;

    private boolean onOf;

    private int counter= 0;

    public Producer(Queue<String> buffer, boolean onOf) {
        this.buffer = buffer;
        this.onOf = onOf;
    }

    public void produce(){
        while (onOf){
            if (buffer.isEmpty()){
                String item = String.format("Item - %s",counter);
                counter++;
                buffer.offer(item);
                logger.info(String.format("Produced item %s",item));
            }
        }
    }

    @Override
    public void run() {
        produce();
    }
}
