package com.example.mordenjava.section2.동작파라미터화;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Apple.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2024/01/14
 */
@Data
@AllArgsConstructor
public class Apple implements Comparable<Apple>{
  private int weight;

  @Override
  public int compareTo(Apple o) {
    return Integer.compare(this.weight, o.weight);
  }
}
