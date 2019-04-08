package com.ft.order;

public class OrderManDTO {
	
	private String orderNum;
	private String name;
	private String address;
	private String phone;
	private String email;
	private int use;

	private String addr1;
	private String addr2;
	private String addr3;
	private String orderphone1;
	private String orderphone2;
	private String orderphone3;
	
	
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		if(addr1 != null) {

			address = addr1+"-"+addr2+"-"+addr3;
		}
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		String [] juso = address.split("-");
		System.out.println(juso.length);
		for(int i=0; i<juso.length; i++) {
			System.out.println(juso[i]);
			setAddr1(juso[0]);
			setAddr2(juso[1]);
			setAddr3(juso[2]);
		}
	}
	public String getPhone() {
		if(orderphone1 !=null) {

			phone = orderphone1+"-"+orderphone2+"-"+orderphone3;
		}
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
		String[] call = phone.split("-");//특수문자로 자르기
		for(int i=0; i<call.length; i++) {
			System.out.println(call[i]);
			setOrderphone1(call[0]);
			setOrderphone2(call[1]);
			setOrderphone3(call[2]);
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getAddr3() {
		return addr3;
	}
	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}/*
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	*/
	public String getOrderphone1() {
		return orderphone1;
	}
	public void setOrderphone1(String orderphone1) {
		this.orderphone1 = orderphone1;
	}
	public String getOrderphone2() {
		return orderphone2;
	}
	public void setOrderphone2(String orderphone2) {
		this.orderphone2 = orderphone2;
	}
	public String getOrderphone3() {
		return orderphone3;
	}
	public void setOrderphone3(String orderphone3) {
		this.orderphone3 = orderphone3;
	}
	
	
	

}
