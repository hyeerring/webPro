package com.lec.ex01_store;

//1호점: 김치찌개: 4,500 부대찌개: 5,000 비빔밥: 6,000 순대국: 안팔아 공기밥: 1,000원
public class Store1 extends HeadQuarterStore {
	public Store1(String storeName) {
		super(storeName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bude() {
		System.out.println("부대찌개 : 5,000원");
	}

	@Override
	public void sunde() {
		System.out.println("순대국 안 팔아");
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 4,500원");
	}

	@Override
	public void bibim() {
		System.out.println("비빔밥 : 6,000원");
	}

	@Override
	public void gongibab() {
		System.out.println("공기밥 1,000원");
	}
}