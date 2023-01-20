package quiz.modularizion;

import quiz.interfaces.GetSalary;
import quiz.interfaces.JobMng;

public class Staff extends Person {
	private String part;

	public Staff(String id, String name, String part) {
		super(id, name);
		setJob(new JobMng());
		setGet(new GetSalary());
		this.part = part;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("[부서] " + part);
	}

}
