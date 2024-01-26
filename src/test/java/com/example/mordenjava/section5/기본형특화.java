package com.example.mordenjava.section5;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 기본형특화.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/01/26
 */
public class 기본형특화 {

	Trader raoul;
	Trader mario;
	Trader alan;
	Trader brian;
	List<TranSaction> transactions;

	@BeforeEach
	void init() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		transactions = Arrays.asList(
			new TranSaction(brian, 2011, 300),
			new TranSaction(raoul, 2012, 1000),
			new TranSaction(raoul, 2011, 400),
			new TranSaction(mario, 2012, 710),
			new TranSaction(mario, 2012, 700),
			new TranSaction(alan, 2012, 950)
		);
	}

	@Test
	@DisplayName("기본형스트림 박싱")
	void plus() {
		IntStream intStream = transactions
			.stream()
			.map(TranSaction::getValue)
			.mapToInt(Integer::intValue);
		Stream<Integer> boxed = intStream.boxed();
	}

	@Test
	@DisplayName("기본값처리하기")
	void 없을경우() {
		OptionalInt max = transactions
			.stream()
			.map(TranSaction::getValue)
			.mapToInt(Integer::intValue)
			.max();
		System.out.println(max.orElse(0));
	}

	@Test
	@DisplayName("피타고라스")
	void 피타고라스() {
		IntStream.rangeClosed(1, 100).boxed()
			.flatMap(a ->
				IntStream.rangeClosed(a, 100)
					.mapToObj(b -> new int[] {a, b, (int)Math.sqrt(a * a + b * b)})
			)
			.filter(t -> t[2] % 1 == 0)
			.limit(5)
			.forEach(t -> System.out.println(t[0] + " " + t[1] + " " + t[2]));

	}
}
