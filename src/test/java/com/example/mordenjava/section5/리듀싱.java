package com.example.mordenjava.section5;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 리듀싱.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/01/26
 */
public class 리듀싱 {
	ArrayList<Integer> numbers;
	@BeforeEach
	void init() {
		numbers = new ArrayList<>();
		IntStream.range(1, 11).forEach(numbers::add);
	}

	@Test
	@DisplayName("요소의 합")
	void 요소의합() {
		//Arrange

		//Act
		int sum = numbers.stream().reduce(0, (a, b) -> a + b);
		//Assert
		assertThat(sum).isEqualTo(55);
	}

	@Test
	@DisplayName("요소의 합 초기값 없음")
	void 초기값없음() {
		//Arrange

		//Act, 오토박싱과 언박싱이 많이 일어나는 코드
		Optional<Integer> reduce = numbers.stream().reduce((a, b) -> a + b);
		//Assert
		assertThat(reduce.get()).isEqualTo(55);
	}

	@Test
	@DisplayName("최댓값과 최소값")
	void 최댓값과최소값() {
		//Arrange

		//Act
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		Optional<Integer> min = numbers.stream().reduce(Integer::min);
		//Assert
		assertThat(max.get()).isEqualTo(10);
		assertThat(min.get()).isEqualTo(1);
	}

	@Test
	@DisplayName("맵리듀스")
	void 맵리듀스패턴() {
		//Arrange

		//Act
		int size = numbers.stream().map(d -> 1).reduce(0, (a, b) -> a + b);
		//Assert
		assertThat(size).isEqualTo(numbers.size());
		assertThat(size).isEqualTo(numbers.stream().count());
	}

	@Test
	@DisplayName("병렬화")
	void 병렬화() {
		//Arrange

		//Act, 람다의 상태가 바뀌지 않아야 한다. 순서에 관계없어야 한다.
		int size = numbers.parallelStream().map(d -> 1).reduce(0, (a, b) -> a + b);
		//Assert
		assertThat(size).isEqualTo(numbers.size());
		assertThat(size).isEqualTo(numbers.stream().count());
	}


}
