package com.zbwx.autotest.ui.pageobject.orderobject;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//下单页面
public class Order_xiadanPage extends BasePage {
	
	DSa_Method ds = new DSa_Method();
	
	@FindElementBy(id="id/below_order_center_price")//价格
	public AndroidElement mPrice;
	
	@FindElementBy(id="id/below_order_small_type_text")//当前种类
	public AndroidElement mType;
	
	@FindElementBy(id="id/leftBtn")//返回按钮
	public AndroidElement mReturnButton;

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
	
	@FindElementBy(id="id/below_order_buyup")//现价定购按钮(结算价定购)
	public AndroidElement mPriceOrder;
	
	@FindElementBy(id="id/below_order_edit")//购买手数
	public AndroidElement mOrderNumber;
	
	@FindElementBy(id="id/item_below_order_linear",index = 1)//止盈第二档
	public AndroidElement mStopProfit_2;
	
	@FindElementBy(id="id/item_below_order_linear",index = 6)//止损第三档
	public AndroidElement mStopLoss_3;
	
	@FindElementBy(id="id/item_below_order_code")//止盈百分比
	public AndroidElement mStopProfit_Ratio;
	
	@FindElementBy(id="id/item_below_order_code",index=1)//止损百分比
	public AndroidElement mStopLoss_Ratio;
	
	@FindElementBy(id="id/below_order_price")//余额
	public AndroidElement mAsset;
	
	
	protected Order_xiadanPage(){
		super();
	}

	public static Order_xiadanPage verify(){
		return  new Order_xiadanPage();
	}

//	/**
//	 * 下单页面，恢复下单页面初始(返回上一页面重新进入)
//	 * @throws Exception 
//	 */
//	public void mRecoveryXiaDanPgae() throws Exception{
//		Order_xiadanPage.verify().mReturnButton.click();
//		OrderPage.verify().mPresentPriceOrder.click();
//	}
	
	/**
	 * 下单页面切换到第二个商品
	 * @throws Exception 
	 */
	public void mSelectOrder() throws Exception{
		this.mSelectOrderButton.click();
		BaseAction.driver.sleep(1000);
		XiadanPage_CommodityMenu.verify().mCommodit_2.click();
	}
	
	/**
	 * 下单页面下，进行选择第二个商品种类
	 * @throws Exception 
	 */
	public void mSelectType() throws Exception{
		this.mSelectType.click();
		
		
	}
	
	/**
	 * 清除默认购买手数后，手动输入购买手数
	 * @param num：要输入的手数
	 */
	public void mSendOrderNumber(String num){
		this.mOrderNumber.click();
		BaseAction.device.clearText("111");
		this.mOrderNumber.click();
		BaseAction.device.sendText(num);
	}
	
	/**
	 * 等待可用资产加载显示
	 * @throws Exception 
	 */
	public void mWaitAvailableAssets() throws Exception{
		String str1 = "--.--";
		String str2;
		for (int i = 0; i < 9; i++) {
			BaseAction.driver.sleep(1000);
			str2 = this.mAsset.getText();
			if(str1.equals(str2)){
				break;
			}
		}
	}
	
	/**
	 * 设置购买手数为1
	 */
	public void mSetOrderNum_1(){
		mSendOrderNumber("1");
		for(int i=0 ;i<9 ;i++){
			this.mOrderNumber_subtract.click();
		}
	}
	
	/**
	 * 设置购买为1手后，下单
	 * @throws Exception 
	 */
	public void mXiaDan() throws Exception{
		//避免直接购买最大手数以导致第二次测试时无法购买，所以设置为只购买一手
		mSetOrderNum_1();
		this.mPriceOrder.click();		
	}
	
	/**
	 * 切换到结算价购买下单页面
	 */
	public void mswitchSettlementPriceOrder(){
		this.mReturnButton.click();
		OrderPage.verify().mSettlementPriceOrder.click();
	}
	
	public void clickMsgBtn(){
		this.mMessageButton.click();
	}
}
