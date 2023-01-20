package quiz.modularizion;

import quiz.interfaces.GetSalary;
import quiz.interfaces.JobLec;

public class Lecturer extends Person {

	private String subject;

	public Lecturer(String id, String name, String subject) {
		super(id, name);
		setJob(new JobLec());
		setGet(new GetSalary());
		this.subject = subject;
	}

	@Override
	public void print() {
		// ID,이름,과목을 출력함
		super.print();
		System.out.println("[과목] " + subject);
	}

}
