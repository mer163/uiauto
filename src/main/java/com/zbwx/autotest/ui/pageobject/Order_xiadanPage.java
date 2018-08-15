package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

//下单页面
public class Order_xiadanPage extends BasePage {
	
	DSa_Method ds = new DSa_Method();


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
	
	
	protected Order_xiadanPage(){
		super();
	}

	public static Order_xiadanPage verify(){
		return  new Order_xiadanPage();
	}

	/**
	 * 点击消息按钮
	 */
	public void mClickMessage(){
		this.mMessageButton.click();
	}
	
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
		ds.mOpenOrder_xiadan();
	}
	
	/**
	 * 下单页面切换商品（果礼铜）
	 */
	public void mSelectOrder(){
		mSelectOrderButton.click();
		BaseAction.driver.findElementByName("果礼铜").click();
	}
	
	/**
	 * 下单页面点击选择卡券
	 */
	public void mClickSelectCoupon(){
		this.mSelectCoupon.click();
	}
	
	/**
	 * 下单页面下，进行选择商品种类（果礼镍0.08吨）
	 */
	public void mSelectType(){
		this.mSelectType.click();
		BaseAction.driver.findElementByName("果礼镍0.08吨").click();
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
	 * 点击减少手数按钮
	 */
	public void mClickOrderNumber_subtract(){
		this.mOrderNumber_subtract.click();
	}
	
	/**
	 * 点击增加手数按钮
	 */
	public void mClickOrderNumber_add(){
		this.mOrderNumber_add.click();
	}
	
	/**
	 * 设置止盈为16.0（最大止盈）
	 */
	public void mSetStopProfit_160(){
		this.mStopProfit_16_0.click();
	}
	
	/**
	 * 设置止损为2.4
	 */
	public void mSetStopLoss_24(){
		this.mStopLoss_2_4.click();
	}
	
	/**
	 * 点击充值按钮
	 */
	public void mClickRecharge(){
		this.mRechargeButton.click();
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
			str2 = ds.mGetYuE();
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
			mClickOrderNumber_subtract();
		}
	}
	
	/**
	 * 设置购买为1手后，下单
	 * @throws Exception 
	 */
	public void mXiaDan() throws Exception{
		//避免直接购买最大手数以导致第二次测试时无法购买，所以设置为只购买一手
		mSetOrderNum_1();
		this.mPresentPriceOrder.click();		
	}
	
	/**
	 * 确认购买
	 */
	public void mOkPurchase(){
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/dialog_ok").click();
	}
	
	/**
	 * 取消购买
	 */
	public void mNOPurchase(){
		BaseAction.driver.findElementById("com.ylmall.app.ui:id/dialog_cancle").click();
	}
	
	/**
	 * 切换到结算价高购买下单页面
	 */
	public void mswitchSettlementPriceOrder(){
		ds.mClickReturnButton();
		this.mSettlementPriceOrder.click();
	}
}
