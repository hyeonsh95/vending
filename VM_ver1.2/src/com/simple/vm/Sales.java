package com.simple.vm;

import java.util.Date;

public class Sales {
	private String pCode;
	private Date date;
	private int price;
	
	public Sales() {
		
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Sales [pCode=" + pCode + ", date=" + date + ", price=" + price + "]";
	}
	
	
}
