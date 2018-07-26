package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.TestBaseCase;

import atx.client.common.ElementObj;

public class QuotationPage extends TestBaseCase {

	public ElementObj AllCommodity;
	public ElementObj CommodityName_AZHJ;
	public ElementObj Order_Botton;
	public ElementObj NowPriceOrder;
	public ElementObj SettlementPriceOrder;
	public ElementObj Pieces_1;
	public ElementObj Pieces_20;
	public ElementObj Pieces_40;
	public ElementObj Pieces_100;
	public ElementObj Recharge_Botton;
	public ElementObj MyOrder;
	public ElementObj home_botton;
	//初始化页面元素
	public void initElements() {
		try {
			this.home_botton = driver.elementByName("首页");
			this.AllCommodity = driver.elementByName("全部商品点这里 >");
			this.CommodityName_AZHJ = driver.elementByName("澳洲红酒");
			this.Order_Botton = driver.elementByName("定购");
			this.NowPriceOrder = driver.elementByName("现价定购");
			this.SettlementPriceOrder = driver.elementByName("结算价定购");
			this.Pieces_1 = driver.elementByName("1件");
			this.Pieces_20 = driver.elementByName("20件");
			this.Pieces_40 = driver.elementByName("40件");
			this.Pieces_100 = driver.elementByName("100件");
			this.Recharge_Botton = driver.elementByName("充值");
			this.MyOrder = driver.elementById("com.ylmall.app.ui:id/order_dingzhi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
