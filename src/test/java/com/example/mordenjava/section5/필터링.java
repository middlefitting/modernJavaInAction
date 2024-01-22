package com.example.mordenjava.section5;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.mordenjava.section4.Dish;

/**
 * 필터링.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/01/22
 */
public class 필터링 {
	@Test
	@DisplayName("고유요소필터링")
	void 고유요소필터링() {
		//Arrange
		List<Dish> dishes = new ArrayList<>();
		dishes.add(new Dish("pork", false, 800, Dish.Type.MEAT));
		dishes.add(new Dish("pork", false, 800, Dish.Type.MEAT));
		dishes.add(new Dish("pork", false, 800, Dish.Type.OTHER));

		//Act
		List<Dish> collect = dishes.stream().distinct().collect(Collectors.toList());

		//Assert
		assertThat(collect.size()).isEqualTo(2);
	}
}
