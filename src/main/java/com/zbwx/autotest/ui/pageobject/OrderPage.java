package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BasePage;
import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//定购页面
public class OrderPage extends BasePage {

	@FindElementBy(id="id/rightBtn")//消息按钮(图标)
	public AndroidElement mMessageButton;
	
	@FindElementBy(text="果礼镍")//果礼镍
	public AndroidElement mCommodity_Ni;
	
	@FindElementBy(text="果礼铜")//果礼铜
	public AndroidElement mCommodity_Cu;
	
	@FindElementBy(id="id/leftBtn")//客服图标
	public AndroidElement mCustomerService;
	
	@FindElementBy(id="id/newcfd_line_fen")//分时线
	public AndroidElement mK_Timeshare;
	
	@FindElementBy(id="id/newcfd_line_5")//M5
	public AndroidElement mK_M5;
	
	@FindElementBy(id="id/newcfd_line_15")//M15
	public AndroidElement mK_M15;
	
	@FindElementBy(id="id/newcfd_line_60")//H1
	public AndroidElement mK_H1;
	
	@FindElementBy(id="id/newcfd_line_day")//D1
	public AndroidElement mK_D1;
	
	@FindElementBy(id="id/newcfd_fragdeal_xiadan")//定购按钮
	public AndroidElement mOrderButton;
	
	@FindElementBy(id="id/order_chongzhi")//充值按钮
	public AndroidElement mRechargeButton;
	
	@FindElementBy(id="id/order_dingzhi")//我的订单按钮
	public AndroidElement mMyOrder;
	
	@FindElementBy(id="id/tv_typegroup1")//10KG
	public AndroidElement mType_10;
	
	@FindElementBy(id="id/tv_typegroup2")//80KG
	public AndroidElement mType_80;
	
	@FindElementBy(id="id/tv_typegroup3")//400KG
	public AndroidElement mType_400;
	
	@FindElementBy(id="id/below_order_buyup")//现价定购
	public AndroidElement mPresentPriceOrder;
	
	@FindElementBy(id="id/below_order_tobuy")//结算价定购
	public AndroidElement mSettlementPriceOrder;

	public OrderPage(){
		super();
	}

	public static OrderPage verify(){
		return  new OrderPage();
	}
	
}
