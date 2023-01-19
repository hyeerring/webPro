package com.lec.quizcopy;

// name, annalSalary: 연봉, 
// computePay(): 월급,computeIncentive()
public class SalaryEmployee extends Employee {
	private int annalSalary;

	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}
	@Override
	public int computePay() {
		return annalSalary / 14;
	}
	
}
