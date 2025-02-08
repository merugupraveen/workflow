package org.example;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ExecutionListener.class})
public class OrderTests {
  @Test
  public void test1(){
    System.out.println("Order tests");
  }

}
