package com.example.mordenjava.section2.동작파라미터화;

import java.util.List;

/**
 * ApplePrinter.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2024/01/14
 */
public class ApplePrinter {
  public static void prettyPrintApple(List<Apple> apples, AppleFormatter formatter) {
    for (Apple apple : apples) {
      System.out.println(formatter.accept(apple));
    }
  }
}
