package com.example.mordenjava.section5;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.mordenjava.section4.Dish;

/**
 * 슬라이싱.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/01/22
 */
public class 슬라이싱 {
	List<Dish> dishes;

	@BeforeEach
	void setUp() {
		dishes = new ArrayList<>();
		IntStream.range(0, 10)
			.forEach(i -> dishes.add(new Dish("pork", false, i * 100, Dish.Type.MEAT)));
	}

	@Test
	@DisplayName("TakeWhile")
	void TakeWhile() {
		//Arrange
		dishes.sort(Comparator.comparing(Dish::getCalories));

		//Act
		List<Dish> collect =
			dishes.stream()
				.takeWhile(dish -> dish.getCalories() < 500)
				.collect(java.util.stream.Collectors.toList());

		//Assert
		assertThat(collect.size()).isEqualTo(dishes.stream().filter(dish -> dish.getCalories() < 500).count());
		collect.stream().forEach(dish -> assertThat(dish.getCalories()).isLessThan(500));
	}

	@Test
	@DisplayName("DropWhile")
	void DropWhile() {
		//Arrange
		dishes.sort(Comparator.comparing(Dish::getCalories));

		//Act
		List<Dish> collect =
			dishes.stream()
				.dropWhile((dish) -> dish.getCalories() < 500)
				.collect(Collectors.toList());

		//Assert
		assertThat(collect.size()).isEqualTo(dishes.stream().filter(dish -> dish.getCalories() >= 500).count());
		collect.stream().forEach(dish -> assertThat(dish.getCalories()).isGreaterThanOrEqualTo(500));
	}



}

