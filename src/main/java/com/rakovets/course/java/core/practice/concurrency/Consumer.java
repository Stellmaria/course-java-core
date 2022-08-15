package com.rakovets.course.java.core.practice.concurrency;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.Queue;
import java.util.logging.Logger;

public class Consumer implements Runnable {
    public static final Logger LOGGER = Logger.getLogger(Consumer.class.getName());
    private final Queue<Integer> queue;
    private final Path path;

    public Consumer(Queue<Integer> queue, Path path) {
        this.queue = queue;
        this.path = path;
    }

    /**
     * Consumer thread that takes numbers from the Queue and sleeps for a number of seconds equal to this number.
     * In this case, the Consumer thread is sleeping in the order in which the integer values were entered by the user.
     */
    @Override
    public void run() {
        try (OutputStreamWriter output = new OutputStreamWriter(
                new FileOutputStream(path.toFile()))) {
            while (true) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                if (!(queue.isEmpty())) {
                    Integer integer;
                    if (queue.peek() == -1) {
                        break;
                    }
                    integer = queue.poll();
                    Thread.sleep(integer * 1000L);
                    output.write("\n" + timestamp + " " + Thread.currentThread().getName() +
                            " I slept " + integer + " seconds\n");
                } else {
                    output.write("\n" + timestamp + " - " + Thread.currentThread().getName() + " ...\n");
                    Thread.sleep(1000L);
                }
                output.flush();
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        } catch (InterruptedException e) {
            LOGGER.info(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
