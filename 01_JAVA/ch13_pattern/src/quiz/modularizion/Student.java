package quiz.modularizion;

import quiz.interfaces.GetStudentPay;
import quiz.interfaces.JobStudy;

public class Student extends Person {

	private String ban;

	public Student(String id, String name, String ban) {
		super(id, name);
		setJob(new JobStudy());
		setGet(new GetStudentPay());
		this.ban = ban;
	}

	@Override
	public void print() {
		// ID,이름,반을 출력함
		super.print();
		System.out.println("[반] " + ban);
	}

}
