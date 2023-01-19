package com.lec.ex02_store;

// store3: 김치찌개: 6,000  부대찌개: 7,000  비빔밥: 7,000 얼큰순대국: 6,000
public class Store3 implements HeadQuarterStore {
	private String storeName;

	public Store3(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 6,000원");
	}

	@Override
	public void bude() {
		System.out.println("부대찌개 : 7,000원");
	}

	@Override
	public void bibim() {
		System.out.println("비빔밥 : 7,000원");
	}

	@Override
	public void sunde() {
		System.out.println("얼큰순대국 : 6,000원");
	}

	@Override
	public void gongibab() {
		System.out.println("공기밥 : 1,000원");
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}