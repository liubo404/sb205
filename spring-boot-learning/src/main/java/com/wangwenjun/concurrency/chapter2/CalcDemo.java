package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalcDemo {

	public static void main(String[] args) {
		TaxCalculator tc = new TaxCalculator(2000, 200) {
			@Override
			public double calcTax() {
				return getSalary() * 0.1 + getBonus() * 0.15;
			}
		};
		double tax = tc.calculate();
		log.info("tax={}", tax);
	}
}
