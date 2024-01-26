package com.example.mordenjava.section5;

import lombok.Getter;
import lombok.ToString;

/**
 * TranSaction.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/01/26
 */
@Getter
@ToString
public class TranSaction {
	private final Trader trader;
	private final int year;
	private final int value;

	public TranSaction(Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
}
