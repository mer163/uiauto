package com.zbwx.autotest.ui.pageobject;

import java.util.ArrayList;

import com.zbwx.autotest.ui.base.TestBaseCase;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;

public class Order_xiadanPage extends TestBaseCase {

	public ElementAdb messageButton;//消息按钮
	public ElementAdb selectOrderButton;//下拉选择商品
	public ElementAdb selectCoupon;//选择卡券
	public ElementAdb selectType;//选择种类
	public ElementAdb orderNumber_add;//增加购买手数
	public ElementAdb orderNumber_subtract;//减少购买手数
	public ElementAdb rechargeButton;//充值按钮
	public ElementAdb presentPriceOrder;//现价定购按钮
	public ElementAdb settlementPriceOrder;//结算价定购按钮
	
	public Order_xiadanPage(){
		initElementsXD();
	}
	
	
	public void initElementsXD(){
		try{
			this.messageButton = position.findElementById("com.ylmall.app.ui:id/rightBtn");
			this.selectOrderButton = position.findElementById("com.ylmall.app.ui:id/below_order_big_type_image");
			this.selectCoupon = position.findElementById("com.ylmall.app.ui:id/below_order_coupon_text");
			this.selectType = position.findElementById("com.ylmall.app.ui:id/below_order_small_type_iamge");
			this.orderNumber_add = position.findElementById("com.ylmall.app.ui:id/below_order_add");
			this.orderNumber_subtract = position.findElementById("com.ylmall.app.ui:id/below_order_move");
			this.rechargeButton = position.findElementById("com.ylmall.app.ui:id/below_order_pay");
			this.presentPriceOrder = position.findElementByText("现价定购");
			this.settlementPriceOrder = position.findElementByText("结算价定购");
			
		}catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 点击‘现价定购’进入下单页面(果礼镍)
	 * @throws Exception
	 */
	public void mOpenOrder_xiadan() throws Exception{
		mWaitOpenApp();
		position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/deal_img", 3000);
		device.click(position.findElementById("com.ylmall.app.ui:id/deal_img"));
		device.click(position.findElementByText("果礼镍"));
		device.click(position.findElementByText("现价定购"));
		Assertion.VerityTextPresentPrecision("下单", "是否已进入下单页面...");
		Assertion.VerityTextPresentPrecision("果礼镍", "商品是否为果礼镍...");	
	}
	
	/**
	 * 点击‘结算价定购’进入下单页面(果礼镍)
	 * @throws Exception
	 */
	public void mOpenOrder_xiadan_JS() throws Exception{
		mWaitOpenApp();
		position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/deal_img", 3000);
		device.click(position.findElementById("com.ylmall.app.ui:id/deal_img"));
		device.click(position.findElementByText("果礼镍"));
		device.click(position.findElementByText("结算价定购"));
		Assertion.VerityTextPresentPrecision("下单", "是否已进入下单页面...");
		Assertion.VerityTextPresentPrecision("果礼镍", "商品是否为果礼镍...");	
	}
	
	/**
	 * 从首页开始，进入我的订单页面获取总成本text
	 * @return
	 */
	public ArrayList<String> mGegCost(){
		mWaitOpenApp();
		position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/deal_img", 3000);
		device.click(position.findElementById("com.ylmall.app.ui:id/deal_img"));
		device.click(position.findElementById("com.ylmall.app.ui:id/order_dingzhi"));
		ArrayList<String> costText = position.getTextById("com.ylmall.app.ui:id/mogen_chicang_zongchengben");
		return costText;
		
	}
}
