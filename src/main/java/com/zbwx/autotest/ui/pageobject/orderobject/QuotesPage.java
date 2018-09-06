package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//行情页面
public class QuotesPage extends BasePage {
	
	@FindElementBy(id="id/leftBtn")//返回按钮
	public AndroidElement mReturnButton;
	
	@FindElementBy(id="id/rightBtn")//消息按钮(图标)
	public AndroidElement mMessageButton;

	@FindElementBy(id="id/listitem_diagram_title")//第一个商品
	public AndroidElement mCommodity_1;
	
	@FindElementBy(id="id/listitem_diagram_title",index=1)//第二个商品
	public AndroidElement mCommodity_2;

	@FindElementBy(id="id/listitem_diagram_title",index=2)//第三个商品
	public AndroidElement mCommodity_3;
	
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

	@FindElementBy(id="id/mogen_price")//当前选择商品价格
	public AndroidElement mMogenPrice;
	
	protected QuotesPage(){
		super();
	}

	public static QuotesPage verify(){
		return  new QuotesPage();
	}
	
}
