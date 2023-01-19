package com.lec.ex02_store;

public class StoreMain {
	public static void main(String[] args) {
		HeadQuarterStore[] stores = {
				// new HeadQuarterStore("= = 본사 = ="), 추상클래스는 객체 생성 불가
				new Store1("= = 주택가 1호점 = ="), new Store2("= = 대학가 2호점 = ="), new Store3("= = 증권가 3호점 = =") };
		// 일반 for
		for (int idx = 0; idx < stores.length; idx++) {
			System.out.println(stores[idx].getStoreName());
			stores[idx].kimchi();
			stores[idx].bude();
			stores[idx].bibim();
			stores[idx].sunde();
			stores[idx].gongibab();
		}
		// 확장 for
		for (HeadQuarterStore store : stores) {
			System.out.println(store.getStoreName());
			store.kimchi();
			store.bude();
			store.bibim();
			store.sunde();
			store.gongibab();
		}
	}
}// main