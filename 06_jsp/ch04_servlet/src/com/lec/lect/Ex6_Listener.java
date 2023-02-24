package com.lec.lect;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Ex6_Listener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에 load되는 시점에 실행
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("+++ ch04 웹 프로젝트가 메모리에 구동 시작 +++");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에서 해제되는 시점
		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("+++ ch04 웹 프로젝트가 메모리에서 해제 +++");
	}
}
