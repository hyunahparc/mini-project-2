package com.exam.dto;

import org.apache.ibatis.type.Alias;

@Alias("GoodsDTO")
public class GoodsDTO {
	
	// DTO 만들고 Configuration에서 별칭 주기
	// -> DTO에서 alias 적기

	String gCode;
	String gCategory;
	String gName;
	int gPrice;
	String gImage;
	int gStock;
	
	public GoodsDTO() {	}

	public GoodsDTO(String gCode, String gCategory, String gName, int gPrice, String gImage, int gStock) {
		this.gCode = gCode;
		this.gCategory = gCategory;
		this.gName = gName;
		this.gPrice = gPrice;
		this.gImage = gImage;
		this.gStock = gStock;
	}

	public String getgCode() {
		return gCode;
	}

	public void setgCode(String gCode) {
		this.gCode = gCode;
	}

	public String getgCategory() {
		return gCategory;
	}

	public void setgCategory(String gCategory) {
		this.gCategory = gCategory;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgPrice() {
		return gPrice;
	}

	public void setgPrice(int gPrice) {
		this.gPrice = gPrice;
	}

	public String getgImage() {
		return gImage;
	}

	public void setgImage(String gImage) {
		this.gImage = gImage;
	}

	public int getgStock() {
		return gStock;
	}

	public void setgStock(int gStock) {
		this.gStock = gStock;
	}

	@Override
	public String toString() {
		return "GoodsDTO [gCode=" + gCode + ", gCategory=" + gCategory + ", gName=" + gName + ", gPrice=" + gPrice
				+ ", gImage=" + gImage + ", gStock=" + gStock + "]";
	}



}