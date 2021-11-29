package com.models.goods;

import java.sql.*;
import com.models.*;
import com.mysql.cj.jdbc.Blob;

public class Goods extends Dto {
	private int goodsNo; // 상품번호
	private Blob goodsImage; // 상품이미지
	private String goodsNm; // 상품명
	private int goodsPrice; //상품가격
	private String goodsCategory; // 카테고리
	private String goodsExplain; // 상품설명

	public Goods() {}
	
	
	
	public Goods(int goodNo, java.sql.Blob goodsImage, String goodNm, int goodsPrice, String goodsCategory, String goodsExplain) {
		this.goodsNo = goodNo;
		this.goodsImage = (Blob)goodsImage;
		this.goodsNm = goodNm;
		this.goodsPrice = goodsPrice;
		this.goodsCategory = goodsCategory;
		this.goodsExplain = goodsExplain;
	}

	public Goods(ResultSet rs) throws SQLException {
		this(
			rs.getInt("goodsNo"),
			rs.getBlob("goodsImage"),
			rs.getString("goodsNm"),
			rs.getInt("goodsPrice"),
			rs.getString("goodsCategory"),
			rs.getString("goodsExplain")
			);
	}

	

	public int getGoodsNo() {
		return goodsNo;
	}



	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}



	public Blob getGoodsImage() {
		return goodsImage;
	}



	public void setGoodsImage(Blob goodsImage) {
		this.goodsImage = goodsImage;
	}



	public String getGoodsNm() {
		return goodsNm;
	}



	public void setGoodsNm(String goodsNm) {
		this.goodsNm = goodsNm;
	}



	public int getGoodsPrice() {
		return goodsPrice;
	}



	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}



	public String getGoodsCategory() {
		return goodsCategory;
	}



	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}



	public String getGoodsExplain() {
		return goodsExplain;
	}



	public void setGoodsExplain(String goodsExplain) {
		this.goodsExplain = goodsExplain;
	}



	@Override
	public Goods setResultSet(ResultSet rs) throws SQLException {
		return new Goods(rs);
	}
}