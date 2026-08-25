package main.java.dsa;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Demonstrates the Producer-Consumer concurrency pattern.
 *
 * <p>A producer places items into a bounded blocking queue while
 * a consumer removes and processes them.
 *
 * <p>BlockingQueue handles the synchronization and automatically
 * blocks the producer when the queue is full and the consumer when
 * the queue is empty.
 *
 * <p>Java concurrency example.
 */
public class ProducerConsumerExample {

    private static final int POISON_PILL = -1;

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> queue =
                new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(() -> {

            try {

                for (int i = 1; i <= 5; i++) {

                    queue.put(i);

                    System.out.println(
                            "Produced: " + i
                    );
                }

                queue.put(POISON_PILL);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }

        });

        Thread consumer = new Thread(() -> {

            try {

                while (true) {

                    int value = queue.take();

                    if (value == POISON_PILL) {
                        break;
                    }

                    System.out.println(
                            "Consumed: " + value
                    );
                }

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }

        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Producer-Consumer completed.");
    }
}