package com.lex.ex04_object;

// new Rectangle(10, 5, "빨강")
// new Rectangle(10, 5)
// new Rectangle()
public class Rectangle implements Cloneable {
	private int width;
	private int height;
	private String color;

	public Rectangle() {
		color = "검정";
	}

	public Rectangle(String color) {
		this.color = color;
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		color = "검정";
	}

	public Rectangle(int width, int height, String color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;
	}

	@Override
	public String toString() {
		// 객체의 정보를 스트링으로 return
//		return "가로 " + width + "cm, 세로 " + height + "cm의 " + color + "색 사각형"
		return String.format("가로 %d 세로%d의 %s색 사각형", width, height, color);
	}

	@Override
	public boolean equals(Object obj) {
		// r1.equals(r2) -> r1(this) r2(obj)
		if (obj != null && getClass() == obj.getClass()) {
			Rectangle other = (Rectangle) obj;
//			return width == other.width && height == other.height && color.equals(other.color);
			boolean widthChk = width == other.width;
			boolean heightChk = height == other.height;
			boolean colorChk = color == other.color;
			return widthChk && heightChk && colorChk;
		} else {
			return false;
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
