package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//行情页面
public class QuotesPage extends BasePage {
	@FindElementBy(id="id/leftBtn")//返回按钮
	public AndroidElement mReturnButton;
	
	@FindElementBy(id="id/rightBtn")//消息按钮(图标)
	public AndroidElement mMessageButton;

	@FindElementBy(text="果礼镍")//果礼镍
	public AndroidElement mCommodity_Ni;
	
	@FindElementBy(text="果礼铜")//果礼铜
	public AndroidElement mCommodity_Cu;

	@FindElementBy(text="日本清酒")//日本清酒
	public AndroidElement mCommodity_ClearWine;
	
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

	protected QuotesPage(){
		super();
	}

	public static QuotesPage verify(){
		return  new QuotesPage();
	}
	
	/**
	 * 点击消息按钮
	 */
	public void mClickMessage(){
		this.mMessageButton.click();
	}
	
	/**
	 * 点击定购按钮
	 */
	public void mDingGou(){
		this.mOrderButton.click();
	}
}
