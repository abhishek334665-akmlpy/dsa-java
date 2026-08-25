/**
 * Demonstrates a min-heap using {@link java.util.PriorityQueue}.
 *
 * <p>The smallest element is returned first when polling the queue.
 *
 * <p>Building the example queue takes O(n log n) for the inserted elements,
 * and each poll operation takes O(log n).
 *
 * <p>Space complexity: O(n)
 */

package dsa;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args){

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        pq.offer(20);
        pq.offer(5);
        pq.offer(15);
        pq.offer(2);

        while(!pq.isEmpty())
            System.out.println(pq.poll());
    }
}