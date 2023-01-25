package com.lec.ex02_datastream;

// 데이터: 제품명 가격 재고
public class Product {
	private String name;
	private int price;
	private int stock;
	
	public Product() {
		super();
	}

	public Product(String name, int price, int stock) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return name + "\t" + price + "원 \t" + stock + "개";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
}
