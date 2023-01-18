package com.lec.ex11_store;

// 본사: 김치찌개: 5,000원 부대찌개: 6,000원 비빔밥: 6,000원 순대국: 5,000원  공기밥: 1,000원
// 1호점: 김치찌개: 4,500 부대찌개: 5,000 비빔밥: 6,000 순대국: 안팔아 공기밥: 1,000원
// 2호점: 김치찌개: 5,000 부대찌개: 5,000 비빔밥: 5,000 순대국: 5,000  공기밥: 무료
// 3호점: 김치찌개: 6,000 부대찌개: 7,000 비빔밥: 7,000 순대국: 6,000  공기밥:1,000원
public class Store3 extends HeadQuarterStore {

	public Store3(String storeName) {
		super(storeName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개: 6,000");
	}

	@Override
	public void budae() {
		System.out.println("부대찌개: 7,000");
	}

	@Override
	public void bibim() {
		System.out.println("전주비빔밥: 7,000");
	}

	@Override
	public void sundae() {
		System.out.println("얼큰순대국: 6,000");
	}
}
