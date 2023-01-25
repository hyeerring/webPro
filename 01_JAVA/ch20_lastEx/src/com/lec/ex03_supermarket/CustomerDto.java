package com.lec.ex03_supermarket;

public class CustomerDto {
	
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private String levelname;
	private int forLevelUp;
	
	public CustomerDto() {
	}

	// 회원가입
//	public CustomerDto(String ctel, String cname) {
//		this.ctel = ctel;
//		this.cname = cname;
//	}

	// 출력용
	public CustomerDto(int cid, String ctel, String cname, int cpoint, int camount, String levelname, int forLevelUp) {
		super();
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelname = levelname;
		this.forLevelUp = forLevelUp;
	}

	@Override
	public String toString() {
		return cid + "\t\t" + ctel + "\t" + cname + "\t" + cpoint + "\t" + camount + "\t" + levelname + "\t" + forLevelUp;
	}
	
	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}

	public int getCamount() {
		return camount;
	}

	public void setCamount(int camount) {
		this.camount = camount;
	}

	public int getForLevelUp() {
		return forLevelUp;
	}

	public void setForLevelUp(int forLevelUp) {
		this.forLevelUp = forLevelUp;
	}
	
	
}
