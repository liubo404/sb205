package com.wangwenjun.concurrency.chapter2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalcDemo2 {

	public static void main(String[] args) {
		TaxCalculator tc = new TaxCalculator(2000, 200) ;
		TaxCalculatorStrategy strategy = new SimpleTaxCalculator();
		tc.setTaxCalculatorStrategy(strategy);

		double tax = tc.calculate();
		log.info("tax={}", tax);
	}
}
