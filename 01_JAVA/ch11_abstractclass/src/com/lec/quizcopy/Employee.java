package com.lec.quizcopy;

// name
// computePay():월급, computeIncentive(월급이 300이상인 사람만 월급의 5%를 incentive)
public abstract class Employee {
	private String name;
	
	public Employee(String name) {
		super();
		this.name = name;
	}

	public abstract int computePay(); // 월급
	
	public final int computeIncentive() { // 인센티브
		int temp = computePay();
		if (temp >= 3000000) {
			return (int) (temp * 0.05);
		} // if
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
}