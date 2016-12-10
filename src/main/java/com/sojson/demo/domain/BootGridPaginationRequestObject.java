package com.sojson.demo.domain;

import net.sf.json.JSONObject;

public class BootGridPaginationRequestObject<T> {

	private int current;
	
	private int rowCount;
	
	private String searchPhrase;
	
	private String sortColumn = "";
	
	private String sortCondition = "";
	
	private T csutomParams;

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getSearchPhrase() {
		return searchPhrase;
	}

	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}

	public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortCondition() {
		return sortCondition;
	}

	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}

	public T getCsutomParams() {
		return csutomParams;
	}

	public void setCsutomParams(T csutomParams) {
		this.csutomParams = csutomParams;
	}
	
	public String toString(){
    	return JSONObject.fromObject(this).toString();
    }
}
