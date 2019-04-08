package com.ft.product;

import java.io.File;
import java.util.List;

import com.ft.file.FileDTO;

public class ProductDTO {

	private int num;
	private String title;
	private int price;
	private int amount;
/*	private int total;*/
	/*private File photo;*/
	private String kind;
	private int product_id;
	private String seller;
	private List<FileDTO> photo;
	 
	
	public List<FileDTO> getPhoto() {
		return photo;
	}
	public void setPhoto(List<FileDTO> photo) {
		this.photo = photo;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
/*	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}*/
	/*public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		
		this.photo = photo;
	}*/
	
	

}
