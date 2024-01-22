package com.example.mordenjava.section4;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Dish.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2024/01/17
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Dish {
  private final String name;
  private final boolean vegetarian;
  private final int calories;
  private final Type type;

  public enum Type { MEAT, FISH, OTHER };
}
