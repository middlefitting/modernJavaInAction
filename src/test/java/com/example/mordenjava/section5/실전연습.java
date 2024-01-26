package com.example.mordenjava.section5;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 실전연습.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/01/26
 */
public class 실전연습 {

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
	@DisplayName("2011 모든 트랜잭션을 오름차순 정렬")
	void test() {
		List<TranSaction> result = transactions.stream()
			.filter((t) -> t.getYear() == 2011)
			.sorted(Comparator.comparing(TranSaction::getValue))
			.collect(Collectors.toList());
	}

	@Test
	@DisplayName("거래자가 근무하는 모든 도시를 중복 없이 나열")
	void test2() {
		List<String> result = transactions.stream()
			.map((transaction) -> transaction.getTrader().getCity())
			.distinct()
			.collect(Collectors.toList());
	}

	@Test
	@DisplayName("케임브릿지 근무자 이름순 정렬")
	void test3() {
		List<Trader> result = transactions
			.stream()
			.map(TranSaction::getTrader)
			.filter(trader -> trader.getCity().equals("Cambridge"))
			.sorted(Comparator.comparing(Trader::getName))
			.collect(Collectors.toList());
	}

	@Test
	@DisplayName("모든 거래자 이름 알파벳순 정렬")
	void test4() {
		List<String> result = transactions
			.stream()
			.map(TranSaction::getTrader)
			.sorted(Comparator.comparing(Trader::getName))
			.map(Trader::getName)
			.collect(Collectors.toList());
	}

	@Test
	@DisplayName("밀라노에 거래자가 있는가")
	void test5() {
		boolean result = transactions
			.stream()
			.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

		assertThat(result).isEqualTo(true);
	}

	@Test
	@DisplayName("케임브리지 거주 거래자 모든 트랜잭션")
	void test6() {
		List<TranSaction> result = transactions
			.stream()
			.filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
			.collect(Collectors.toList());
	}

	@Test
	@DisplayName("전체 트랜잭션 최댓값")
	void test7() {
		OptionalInt max = transactions
			.stream()
			.map(TranSaction::getValue)
			.mapToInt(Integer::intValue)
			.max();
	}

	@Test
	@DisplayName("전체 트랜잭션 최댓값")
	void test8() {
		OptionalInt min = transactions
			.stream()
			.map(TranSaction::getValue)
			.mapToInt(Integer::intValue)
			.min();
	}

}
