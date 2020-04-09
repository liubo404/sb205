package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalcDemo3 {

	public static void main(String[] args) {
		TaxCalculator tc = new TaxCalculator(2000, 200);
		tc.setTaxCalculatorStrategy((s, b) -> s * 0.2 + b * 0.3);

		double tax = tc.calculate();
		log.info("tax={}", tax);
	}
}
