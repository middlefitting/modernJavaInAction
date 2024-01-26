package com.example.mordenjava.section5;

import lombok.Getter;
import lombok.ToString;

/**
 * Trader.
 *
 * <p>
 *
 * </p>
 * @see             : 
 * @author          : middlefitting
 * @since           : 2024/01/26
 */
@ToString
@Getter
public class Trader {

	private final String name;
	private final String city;

	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
	}
}
