package com.example.zhanghaihua.myapplication.diyView;

import java.util.List;

public class CityModel {
	public String categoryName;
	public String categoryID;
	public List<DistrictModel> subCategory;

	public CityModel() {
		super();
	}

	public CityModel(String categoryName, List<DistrictModel> subCategory) {
		super();
		this.categoryName = categoryName;
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "CityModel [name=" + categoryName + ", districtList="
				+ subCategory + "]";
	}

}
