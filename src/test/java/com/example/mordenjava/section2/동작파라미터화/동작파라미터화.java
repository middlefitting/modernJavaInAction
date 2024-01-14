package com.example.mordenjava.section2.동작파라미터화;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 동작파라미터화.
 *
 * <p>
 *
 * </p>
 *
 * @author : middlefitting
 * @see :
 * @since : 2024/01/14
 */
public class 동작파라미터화 {

  @Test
  @DisplayName("동작파라미터화")
  void 동작파라미터화() {
    //Arrange
    List<Apple> apples = new ArrayList<>();
    apples.add(new Apple(15));
    apples.add(new Apple(6));
    AppleHeavyFormatter formatter = new AppleHeavyFormatter();
    //Act
    ApplePrinter.prettyPrintApple(apples, formatter);
  }

}
