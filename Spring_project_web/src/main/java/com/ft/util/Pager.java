package com.ft.util;

public class Pager {

	private int curPage;
	private int perPage;
	private int perBlock;
	private int startRow;
	private int lastRow;
	private String kind;
	private String search;
	private int startNum;
	private int lastNum;
	private int curBlock;
	private int totalBlock;
	
	public Pager() {
		this.perPage = 10;
		this.perBlock = 5;
	}
	
	public int getCurPage() {
		if(curPage == 0) {
			curPage = 1;
		}
		return curPage;
	}
	
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		if(perPage ==0) {
			perPage = 10;
		}
		
		return perPage;
	}
	
	public void setPerPage(int perpage) {
		
		this.perPage = perpage;
		
	}
	
	public int getPerBlock() {
		if(perBlock == 0) {
			perBlock = 5;
		}
		
		return perBlock;
	}
	
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
		
		if(perBlock == 0) {
			perBlock = 5;
		}
	}
	
	public int getStartRow() {
		return startRow;
	}
	
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	
	public int getLastRow() {
		return lastRow;
	}
	
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	
	public String getKind() {
		if(kind==null|| kind.equals("")) {
			kind="title";
		}
		
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind=kind;
		if(this.kind==null|| this.kind.equals("")) {
			kind="title";
		}
	}
	
	public String getSearch() {
		if(search==null|| search.equals("")) {
			search="";
		}
		return search;
		
	}
	
	public void setSearch() {
		this.search = search;
		if(this.search==null) {
			this.search="";
		}
	}
	
	public int getStartNum() {
		if(startNum == 0) {
			startNum = 1;
		}
		return startNum;
	}
	
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	
	public int getLastNum() {
		return lastNum;
	}
	
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	
	public int getCurBlock() {
		return curBlock;
	}
	
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	
	public int getTotalBlock() {
		return totalBlock;
	}
	
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	
	public void makeRow() {
		this.startRow = (getCurPage()-1)*getPerPage()+1;
		this.lastRow =getCurPage()*getPerPage();
	}
	
	public void makePage(int totalCount) {
		//1. totalPage
			int totalPage = totalCount/perPage;
			if(totalCount%perPage != 0) {
				totalPage++;
			}
		
		//2. totalBlock
			this.totalBlock = totalPage/perBlock;
			if(totalPage%perBlock !=0) {
				this.totalBlock++;
			}
		
		//3. curPage로 curBlock
			this.curBlock = curPage/perBlock;
			if(curPage%perBlock !=0) {
				curBlock++;
			}
		
		//4. curBlock startNum, lastNum
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
			
		//5.curBlock 마지막 block 일대
		if(curBlock==totalBlock) {
			this.lastNum = totalBlock;
		}
		
		
	}
	
}
