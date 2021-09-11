package stacksqueues;

import javax.lang.model.element.Element;
import java.util.Queue;
import java.util.Stack;

public class QueueViaStack<E> {

    private Stack<E> enqueueStack;

    private Stack<E> dequeueStack;

    public QueueViaStack() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(E element){
        enqueueStack.push(element);
    }

    public E dequeue(){
        if (!dequeueStack.isEmpty()){
            return dequeueStack.pop();
        }
        while (!enqueueStack.isEmpty()){
            dequeueStack.push(enqueueStack.pop());
        }
        return dequeueStack.pop();
    }

    public int size(){
        return dequeueStack.size() + enqueueStack.size();
    }

}
