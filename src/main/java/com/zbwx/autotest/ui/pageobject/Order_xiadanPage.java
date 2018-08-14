package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BasePage;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//下单页面
public class Order_xiadanPage extends BasePage {

	@FindElementBy(id="id/rightBtn")//消息按钮
	public AndroidElement mMessageButton;
	
	@FindElementBy(id="id/below_order_big_type_image")//下拉选择商品
	public AndroidElement mSelectOrderButton;
	
	@FindElementBy(id="id/below_order_coupon_text")//选择卡券
	public AndroidElement mSelectCoupon;
	
	@FindElementBy(id="id/below_order_small_type_iamge")//选择种类
	public AndroidElement mSelectType;
	
	@FindElementBy(id="id/below_order_add")//增加购买手数
	public AndroidElement mOrderNumber_add;
	
	@FindElementBy(id="id/below_order_move")//减少购买手数
	public AndroidElement mOrderNumber_subtract;
	
	@FindElementBy(id="id/below_order_pay")//充值按钮
	public AndroidElement mRechargeButton;
	
	@FindElementBy(text="现价定购")//现价定购按钮
	public AndroidElement mPresentPriceOrder;
	
	@FindElementBy(text="结算价定购")//结算价定购按钮
	public AndroidElement mSettlementPriceOrder;
	
	@FindElementBy(id="id/below_order_edit")//购买手数
	public AndroidElement mOrderNumber;
	
	@FindElementBy(text="16.0")//止盈16.0
	public AndroidElement mStopProfit_16_0;
	
	@FindElementBy(text="2.4")//止损2.4
	public AndroidElement mStopLoss_2_4;
	
	public Order_xiadanPage(){
		super();
	}

	public static Order_xiadanPage verify(){
		return  new Order_xiadanPage();
	}

	DSa_Method ds = new DSa_Method();
	
	/**
	 * 下单页面，获取当前购买手数
	 * @return
	 * @throws Exception
	 */
	public String mGetOrderNumber() throws Exception{
		return ds.mGetTextById("com.ylmall.app.ui:id/below_order_edit");
	}
	
	/**
	 * 下单页面，恢复下单页面初始(返回上一页面重新进入)
	 * @throws Exception 
	 */
	public void mRecoveryXiaDanPgae() throws Exception{
		ds.mClickReturnButton();
		mOpenOrder_xiadan();
	}
	
	/**
	 * 首页开始,点击‘现价定购’进入下单页面(果礼镍)
	 * @throws Exception
	 */
	public void mOpenOrder_xiadan() throws Exception{
		ds.mOpenOrderPage();
		OrderPage order = new OrderPage();
		order.mPresentPriceOrder.click();
		Assertion.VerityTextPresentPrecision("下单", "是否已进入下单页面...");
		Assertion.VerityTextPresentPrecision("果礼镍", "商品是否为果礼镍...");	
	}
	
	public void mClearAndReinput(String id ){
		
	}
}
