package com.lex.ex07_timer;

import java.util.TimerTask;

public class TimerTaskEx01 extends TimerTask {

	@Override
	public void run() {
		// 작업정의
		System.out.println("작업1: 2초 후에 한번 수행될 예정인 TimerTask * * *");
		
	}

}
