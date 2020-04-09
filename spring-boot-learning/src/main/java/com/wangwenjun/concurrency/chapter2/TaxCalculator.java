package com.wangwenjun.concurrency.chapter2;

public class TaxCalculator {
	private final double salary;

	private final double bonus;

	private TaxCalculatorStrategy taxCalculatorStrategy;

	public void setTaxCalculatorStrategy(TaxCalculatorStrategy taxCalculatorStrategy) {
		this.taxCalculatorStrategy = taxCalculatorStrategy;
	}

	public double getSalary() {
		return salary;
	}

	public double getBonus() {
		return bonus;
	}

	public TaxCalculator(double salary, double bonus) {
		this.salary = salary;
		this.bonus = bonus;
	}

	protected double calcTax() {
		return taxCalculatorStrategy.calculate(salary, bonus);
	}

	public double calculate() {
		return this.calcTax();
	}

}
