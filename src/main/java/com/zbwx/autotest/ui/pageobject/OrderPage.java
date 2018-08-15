package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;
import com.zbwx.autotest.ui.utils.Assertion;

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

	protected OrderPage(){
		super();
	}

	public static OrderPage verify(){
		return  new OrderPage();
	}
	
	
	/**
	 * 点击客服按钮
	 */
	public void mClickCustomerService(){
		this.mCustomerService.click();
	}
	
	/**
	 * 点击消息按钮
	 */
	public void mClickMessage(){
		this.mMessageButton.click();
	}
	
	/**
	 * 点击充值按钮
	 */
	public void mClickRecharge(){
		this.mRechargeButton.click();
	}
	
	/**
	 * 点击我的订单
	 */
	public void mClickMyOrder(){
		this.mMyOrder.click();
	}
	
	/**
	 * 根据输入10、80、400来选择果礼镍商品规格：10KG、80KG、400KG
	 * @param str
	 * @throws Exception
	 */
	public void mClickSelectType(String str) throws Exception{
		switch (str) {
		case "10":
			this.mType_10.click();
			break;
		case "80":
			this.mType_80.click();
			break;
		case "400":
			this.mType_400.click();
			break;
		default:
			Assertion.VerityBoolean(false, true, "输入错误...");
			break;
		}
	}
}
