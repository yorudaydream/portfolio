package com.ft.member;

public class MemberDTO {

	private int num;
	private String id;
	private String pw;
	private String name;
	private String address;
	private String addr1;
	private String addr2;
	private String addr3;
	private String phone;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
	private int grade;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
		if(phone1 !=null) {

			phone = phone1+"-"+phone2+"-"+phone3;
		}
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
		String[] call = phone.split("-");//특수문자로 자르기
		for(int i=0; i<call.length; i++) {
			System.out.println(call[i]);
			setPhone1(call[0]);
			setPhone2(call[1]);
			setPhone3(call[2]);
		}
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
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
	}
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

	
	
}
