package com.example.zhanghaihua.myapplication.diyView;

public class DistrictModel {
	public String categoryName;
	public String zipcode;
	public String categoryID;

	public DistrictModel() {
		super();
	}

	public DistrictModel(String categoryName, String zipcode, String categoryID) {
		super();
		this.categoryName = categoryName;
		this.zipcode = zipcode;
		this.categoryID = categoryID;
	}

	@Override
	public String toString() {
		return "DistrictModel [name=" + categoryName + ", zipcode=" + zipcode
				+ "]";
	}

}
