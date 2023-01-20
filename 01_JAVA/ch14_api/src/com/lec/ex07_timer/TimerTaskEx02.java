package com.lex.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx02 extends TimerTask {

	@Override
	public void run() {
		System.out.println("작업2: 1초 후에 0.5초마다 실행될 예정인 TimerTask");
		
	}

}
