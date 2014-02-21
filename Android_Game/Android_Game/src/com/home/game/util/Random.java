package com.home.game.util;

public class Random {

	static int Min, Max;

	public static int between(int userMin, int userMax) {
		Min = userMin;
		Max = userMax;
		int random = Min + ((int) (Math.random() * ((Max - Min) + 1)));
		return random;
	}
}
