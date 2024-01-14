package com.example.mordenjava.section2.동작파라미터화;

/**
 * AppleHeavyFormatter.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2024/01/14
 */
public class AppleHeavyFormatter implements AppleFormatter{


  @Override
  public String accept(Apple apple) {
    if (apple.getWeight() > 10)
      return "Heavy";
    return "Not Heavy";
  }
}
