import java.util.LinkedList;
import java.util.List;

import javax.management.Query;

public class BlockingQueue<T> {

    private List<T> queue = new LinkedList<>();
    
    BlockingQueue(){
    	queue = new LinkedList<>();
    }

    private int limit = 10;

    public synchronized void put(T item) throws InterruptedException{
    	while(queue.size() == limit) {
    		wait();
    	}
    	queue.add(item);
    	notifyAll();
    }

    public synchronized T take() throws InterruptedException{
    	while(queue.isEmpty()) {
    		wait();
    	}
    	notifyAll();
    	return queue.remove(0);
    	
    }
    
}