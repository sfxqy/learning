package com.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author sfx
 * @Description
 */
public class BlockingQueue {


  public static void main(String[] args) {
    ArrayBlockingQueue queue1 = new ArrayBlockingQueue<String>(2);
    queue1.add("1");
    queue1.add("2");
    queue1.remove();
    queue1.element();

    LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>();
    PriorityBlockingQueue<Object> objects1 = new PriorityBlockingQueue<>();
    DelayQueue<Delayed> delayeds = new DelayQueue<>();

    SynchronousQueue<Object> objects2 = new SynchronousQueue<>();
  }
}
