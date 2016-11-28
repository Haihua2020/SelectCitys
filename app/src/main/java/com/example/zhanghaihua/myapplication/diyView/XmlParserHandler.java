package com.example.zhanghaihua.myapplication.diyView;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlParserHandler extends DefaultHandler {

	/**
	 * �洢���еĽ�������
	 */
	private List<ProvinceModel> provinceList = new ArrayList<ProvinceModel>();

	public XmlParserHandler() {

	}

	public List<ProvinceModel> getDataList() {
		return provinceList;
	}

	@Override
	public void startDocument() throws SAXException {
		// ��������һ����ʼ��ǩ��ʱ�򣬻ᴥ���������
	}

	ProvinceModel provinceModel = new ProvinceModel();
	CityModel cityModel = new CityModel();
	DistrictModel districtModel = new DistrictModel();

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// ��������ʼ��ǵ�ʱ�򣬵����������
		if (qName.equals("province")) {
			provinceModel = new ProvinceModel();
			provinceModel.categoryName = attributes.getValue(0);
			provinceModel.subCategory = new ArrayList<CityModel>();
		} else if (qName.equals("city")) {
			cityModel = new CityModel();
			cityModel.categoryName = attributes.getValue(0);
			cityModel.subCategory = new ArrayList<DistrictModel>();
		} else if (qName.equals("district")) {
			districtModel = new DistrictModel();
			districtModel.categoryName = attributes.getValue(0);
			districtModel.zipcode = attributes.getValue(1);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// ���������ǵ�ʱ�򣬻�����������
		if (qName.equals("district")) {
			cityModel.subCategory.add(districtModel);
		} else if (qName.equals("city")) {
			provinceModel.subCategory.add(cityModel);
		} else if (qName.equals("province")) {
			provinceList.add(provinceModel);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
	}

}

