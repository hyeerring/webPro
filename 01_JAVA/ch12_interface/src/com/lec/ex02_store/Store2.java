package com.lec.ex02_store;

//2호점: 김치찌개: 5,000 부대찌개: 5,000 비빔밥: 5,000 순대국: 5,000  공기밥: 무료
public class Store2 implements HeadQuarterStore {
	private String storeName;

	public Store2(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public void bude() {
		System.out.println("부대찌개 : 5,000원");
	}

	@Override
	public void bibim() {
		System.out.println("비빔밥 : 5,000원");
	}

	@Override
	public void gongibab() {
		System.out.println("공기밥 : 무료");
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 5,000원");

	}

	@Override
	public void sunde() {
		System.out.println("순대국 : 5,000원");
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
