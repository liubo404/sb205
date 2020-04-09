package com.wangwenjun.concurrency.chapter2;

public class SimpleTaxCalculator implements TaxCalculatorStrategy {

	private final static double SALARY_RATE = 0.09d;
	private final static double BONUS_RATE = 0.12d;

	@Override
	public double calculate(double salary, double bonus) {
		return salary * SALARY_RATE + bonus * BONUS_RATE;
	}
}
