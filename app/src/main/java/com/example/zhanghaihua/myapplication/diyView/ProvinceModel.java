package com.example.zhanghaihua.myapplication.diyView;

import java.util.List;

public class ProvinceModel {
	public String categoryName;
	public String categoryID;
	public List<CityModel> subCategory;

	public ProvinceModel() {
		super();
	}

	public ProvinceModel(String categoryName, List<CityModel> subCategory,
			String categoryID) {
		super();
		this.categoryName = categoryName;
		this.subCategory = subCategory;
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "ProvinceModel [name=" + categoryName + ", cityList="
				+ subCategory + "]";
	}

}
