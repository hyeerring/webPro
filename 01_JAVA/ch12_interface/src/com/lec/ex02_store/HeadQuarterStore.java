package com.lec.ex02_store;

//추상클래스 : 하나 이상의 추상메소드를 갖고 있으면 추상클래스
public interface HeadQuarterStore {
//	private String storeName;

	// 추상메소드 : 나를 상속한 클래스에서 반드시 override.
	// 메소드의 선언만 있을 뿐, 구현은 없다.
	public void kimchi();

	public void bude();

	public void bibim();

	public void sunde();

	public void gongibab();

	public String getStoreName();

}
