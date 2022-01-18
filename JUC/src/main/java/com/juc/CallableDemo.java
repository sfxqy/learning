package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author sfx
 * @Description
 */
public class CallableDemo implements Callable<Integer> {


  @Override
  public Integer call() throws Exception {
    System.out.println("call");
    return 123;
  }
}


class CallableTest{

  public static void main(String[] args) throws Exception{
    FutureTask<Integer> futureTask = new FutureTask<>(new CallableDemo());
    Thread thread = new Thread(futureTask);
    thread.start();
    System.out.println(futureTask.get());
  }
}