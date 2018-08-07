package com.zbwx.autotest.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;

import atx.client.adb.ElementAttribs;

public class Ylmall extends BaseTest{
	
	protected static String HOME_PAGE = "首页";
	protected static String MARKET_PAGE = "商城";
	protected static String ORDER_PAGE = "定购";
	protected static String FIND_PAGE = "发现";
	protected static String MY_PAGE = "我的";
	protected static String Test_MobileNumber = "18811732369";
	protected static String	Test_PassWord = "123369";
	/**
	 * 设置等待时间
	 * @param time:毫秒
	 * @throws Exception 
	 */
	public void mSleep(int time) throws Exception{
		Thread.sleep(time);
	}
	
	/**
	 * 以屏幕为中心进行滑动半屏：1：向上滑半屏；2：向下滑半屏；3：向左滑半屏；4：向右滑半屏；
	 * @param x
	 */
	public void mSwipe(int x){
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screensize.getWidth();
		int height = (int)screensize.getHeight();
		switch (x) {
		case 1:
			BaseAction.device.swipe(width/2, height/2, width/2, height-10, 30);
			break;
		case 2:
			BaseAction.device.swipe(width/2, height/2, width/2, 10, 30);
			break;
		case 3:
			BaseAction.device.swipe(width/2, height/2, 10, height/2, 30);
			break;
		case 4:
			BaseAction.device.swipe(width/2, height/2, width-10, height/2, 30);
			break;
		default:
			System.out.println("输入内容错误，请输入：1/2/3/4");
			assert false;
			break;
		}
	}
	/**
	 * 判断是否为首次启动APP
	 * @param time:毫秒
	 * @throws Exception
	 */
	public void mFirstStartApp(int time) throws Exception{
		//首次启动时权限确定	
		while (BaseAction.position.waitForElement(ElementAttribs.TEXT, "允许", time)) {
			BaseAction.driver.findElementByName("允许").click();
		}
		//跳过引导图
		while (BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylaijiaoyi.app.ui:id/viewPager", 2000)) {
			mSwipe(1);	
		}
	}
	
	/**
	 * 断言：text：LOG输入文本
	 * @param text
	 * @param bol
	 */
	public void mAssert(String text ,boolean bol){
		if (!bol) {
			System.out.println(text);
		}
		assert bol;
	}
	
	/**
	 * 根据输入打开相应的页面(首页/商城/定购/发现/我的)
	 * @param PageName
	 * @throws Exception
	 */
	public void mOpenPage(String PageName) throws Exception{
		mAssert("3秒内未找到页面切换栏...", BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylaijiaoyi.app.ui:id/linearLayout", 3000));
		switch (PageName) {
		case "首页":
			BaseAction.driver.findElementById("com.ylaijiaoyi.app.ui:id/first_img").click();
			break;
		case "商城":
			BaseAction.driver.findElementById("com.ylaijiaoyi.app.ui:id/mall_img").click();
			break;
		case "定购":
			BaseAction.driver.findElementById("com.ylaijiaoyi.app.ui:id/deal_img").click();
			break;
		case "发现":
			BaseAction.driver.findElementById("com.ylaijiaoyi.app.ui:id/quanzi_img").click();
			break;
		case "我的":
			BaseAction.driver.findElementById("com.ylaijiaoyi.app.ui:id/my_img").click();
			break;
		default:
			mAssert("输入错误,只可输入：首页/商城/定购/发现/我的", false);
			break;
		}
	}
	
	/**
	 * 以文本检查元素是否存在(查找时间为time毫秒内)
	 * @param text
	 * @param time
	 * @return
	 */
	public boolean mCheckText(String text,int time){
		return BaseAction.position.waitForElement(ElementAttribs.TEXT, text, time);
	}
	
	/**
	 * 以id检查元素是否存在(查找时间为time毫秒内)
	 * @param id
	 * @param time
	 * @return
	 */
	public boolean mCheckId(String id,int time){
		return BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, id, time);
	}
	
	/**
	 * 以class检查元素是否存在(查找时间为time毫秒内)
	 * @return
	 */
	public boolean mCheckClass(String class_name,int time){
		return BaseAction.position.waitForElement(ElementAttribs.CLASS, class_name, time);
	}
	
	/**
	 * 以desc检查元素是否存在(查找时间为time毫秒内)
	 * @param desc_name
	 * @param time
	 * @return
	 */
	public boolean mCheckDesc(String desc_name,int time){
		return BaseAction.position.waitForElement(ElementAttribs.CONTENTDESC, desc_name, time);
	}
	
	public void mLogPrint(String PrintText){
		System.out.println(PrintText);
	}
	
	/**
	 * 以id进行点击(查找时间为time毫秒)
	 * @param id
	 * @throws Exception
	 */
	public void mClickId(String id,int time) throws Exception{
		mAssert(time+"毫秒未找到:"+id, mCheckId(id, time));
		BaseAction.driver.findElementById(id).click();
		mLogPrint("已点击:"+id);
	}
	
	/**
	 * 以文本进行点击(查找时间为time毫秒)
	 * @param text
	 * @param time
	 * @throws Exception
	 */
	public void mClickText(String text,int time) throws Exception{
		mAssert(time+"毫秒内未找到:"+text, mCheckText(text, time));
		BaseAction.driver.findElementByName(text).click();
		mLogPrint("已点击:"+text);
	}
	
	public void mClickDesc(String desc,int time) throws Exception{
		mAssert(time+"毫秒未找到:"+desc, mCheckDesc(desc, time));
		BaseAction.driver.findElementByDesc(desc).click();
		mLogPrint("已点击:"+desc);
	}
	
	
}
