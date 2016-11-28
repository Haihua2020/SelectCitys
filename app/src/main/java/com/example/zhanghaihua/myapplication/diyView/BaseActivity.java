package com.example.zhanghaihua.myapplication.diyView;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

public class BaseActivity extends Activity {

		 /**
		 * ����ʡ
		 */
		protected String[] mProvinceDatas;
		/**
		 * key - ʡ value - ��
		 */
		protected Map<String, String[]> mCitisDatasMap = new HashMap<String, String[]>();
		/**
		 * key - �� values - ��
		 */
		protected Map<String, String[]> mDistrictDatasMap = new HashMap<String, String[]>();

		/**
		 * key - �� values - �ʱ�
		 */
		protected Map<String, String> mZipcodeDatasMap = new HashMap<String, String>();

		/**
		 * ��ǰʡ�����
		 */
		protected String mCurrentProviceName;
		/**
		 * ��ǰ�е����
		 */
		protected String mCurrentCityName;
		/**
		 * ��ǰ������
		 */
		protected String mCurrentDistrictName = "";

		/**
		 * ��ǰ�����������
		 */
		protected String mCurrentZipCode = "";

		/**
		 * ����ʡ�����XML���
		 */

	protected void initProvinceDatas(Context context) {
		List<ProvinceModel> provinceList = null;
		AssetManager asset = getAssets();
		try {
			//InputStream input = asset.open("province_data.xml");
			InputStream input = BaseActivity.this.getClass().getClassLoader().getResourceAsStream("assets/province_data.xml");
			// ����һ������xml�Ĺ�������
			SAXParserFactory spf = SAXParserFactory.newInstance();
			// ����xml
			SAXParser parser = spf.newSAXParser();
			XmlParserHandler handler = new XmlParserHandler();
			parser.parse(input, handler);
			input.close();
			// ��ȡ�������������
			provinceList = handler.getDataList();
			System.out.println("----1111111-------");

			System.out.println("-----------"+provinceList.toString());
			// */ ��ʼ��Ĭ��ѡ�е�ʡ���С���
			if (provinceList != null && !provinceList.isEmpty()) {
				mCurrentProviceName = provinceList.get(0).categoryName;
				List<CityModel> cityList = provinceList.get(0).subCategory;
				if (cityList != null && !cityList.isEmpty()) {
					mCurrentCityName = cityList.get(0).categoryName;
					List<DistrictModel> districtList = cityList.get(0).subCategory;
					mCurrentDistrictName = districtList.get(0).categoryName;
					mCurrentZipCode = districtList.get(0).zipcode;
				}
			}
			// */
			mProvinceDatas = new String[provinceList.size()];
			for (int i = 0; i < provinceList.size(); i++) {
				// ��������ʡ�����
				mProvinceDatas[i] = provinceList.get(i).categoryName;
				List<CityModel> cityList = provinceList.get(i).subCategory;
				String[] cityNames = new String[cityList.size()];
				for (int j = 0; j < cityList.size(); j++) {
					// ����ʡ����������е����
					cityNames[j] = cityList.get(j).categoryName;
					List<DistrictModel> districtList = cityList.get(j).subCategory;
					String[] distrinctNameArray = new String[districtList
							.size()];
					DistrictModel[] distrinctArray = new DistrictModel[districtList
							.size()];
					for (int k = 0; k < districtList.size(); k++) {
						// ����������������/�ص����
						DistrictModel districtModel = new DistrictModel(
								districtList.get(k).categoryName,
								districtList.get(k).zipcode, "");
						// ��/�ض��ڵ��ʱ࣬���浽mZipcodeDatasMap
						mZipcodeDatasMap.put(districtList.get(k).categoryName,
								districtList.get(k).zipcode);
						distrinctArray[k] = districtModel;
						distrinctNameArray[k] = districtModel.categoryName;
					}
					// ��-��/�ص���ݣ����浽mDistrictDatasMap
					mDistrictDatasMap.put(cityNames[j], distrinctNameArray);
				}
				// ʡ-�е���ݣ����浽mCitisDatasMap
				mCitisDatasMap.put(provinceList.get(i).categoryName, cityNames);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
		System.out.println("我final");
		}
	}

}
