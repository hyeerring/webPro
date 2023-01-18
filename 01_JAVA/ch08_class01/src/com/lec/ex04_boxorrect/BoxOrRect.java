package com.lec.ex04_boxorrect;

// 데이터: width(가로), height(세로), depth(깊이), volume(부피)
// 메소드: calVolume(), inforPrint(), infoString()
public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume;

	public BoxOrRect() { // 디폴트 생성자
//		super();
	}

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		calVolume(); // volume 셋팅
	}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		calVolume();
	}

	private void calVolume() {
		if (depth == 0) {
			volume = width * height;
		} else {
			volume = width * height * depth;
		}
	}

	public void inforPrint() {
		if (depth == 0) {
			System.out.printf("사각형 - 가로:%d\t 세로:%d\t 넓이:%d", width, height, volume);
		} else
			System.out.printf("직육면체 - 가로:%d\t 세로:%d\t 깊이:%d\t 부피:%d", width, height, depth, volume);
	}

	public String infoString() {
		if (depth == 0) {
			return String.format("사각형 - 가로:%d\t 세로:%d\t 넓이:%d", width, height, volume);
		} else {
			return String.format("직육면체 - 가로:%d\t 세로:%d\t 깊이:%d\t 부피:%d", width, height, depth, volume);
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		calVolume();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		calVolume();
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
		calVolume();
	}

	public int getVolume() {
		return volume;
	}

}
