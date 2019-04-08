package com.ft.order;

import java.sql.Date;

public class OrderDTO {
	private String orderNum;//주문번호
	private int product_id;
	/*private int name;*/
	private String title;//상품이름
	private Date reg_date;//주문날짜
	private int total;//총결제금
	private int shippingNum;//송장번호 - 나중에 입력
	private int step;//0(결제완료) - 발송준비 - 발송완료(송장번호 입력)
	private int amount;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	/*
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}*/
/*	public Date getSysdate() {
		return sysdate;
	}*/
/*	public void setSysdate(Date sysdate) {
		this.sysdate = sysdate;
	}*/
/*	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	
	
	public int getShippingNum() {
		return shippingNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setShippingNum(int shippingNum) {
		this.shippingNum = shippingNum;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
