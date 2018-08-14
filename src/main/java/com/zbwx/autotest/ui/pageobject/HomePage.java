package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.utils.Assertion;

import atx.client.AtxClient;
import atx.client.adb.ElementAdb;
import atx.client.adb.ElementAttribs;
import atx.client.common.ElementObj;
import atx.client.enums.AttributeMask;
import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;
import static com.zbwx.autotest.ui.base.BaseAction.mReturn;

public class HomePage extends BasePage{
	
	@FindElementBy(text = "定购", verify = true)
	public AndroidElement order;

	@FindElementBy(text = "发现", verify = true)
	public AndroidElement find;

	@FindElementBy(text = "我的", verify = true)
	public AndroidElement my;

	@FindElementBy(id = "id/first_text")// verify=true时 id必须为不包含包名的id，减少与服务器交互次数	
	public AndroidElement home_bottom;

	@FindElementBy(id = "id/tv_search")// 搜索	
	public AndroidElement btn_homeSearch;

	@FindElementBy(id = "id/img_kefu")
	public AndroidElement img_homeService; // 客服
	
	@FindElementBy(id = "id/img_tixing")// 消息	
	public AndroidElement img_homeMessage;

	@FindElementBy(id = "id/cbLoopViewPager")// 轮播图	
	public AndroidElement vp_homeCbLoopViewPager;

	@FindElementBy(text = "更多")
	public AndroidElement tv_homeMoreylName;

	// 首页热门商品
	@FindElementBy(id = "id/tv_allproduct")
	// 首页全部商品点这里
	public AndroidElement tv_homeAllProduct;
	@FindElementBy(text = "果礼镍")
	public AndroidElement tv_homeNie;
	@FindElementBy(text = "果礼铜")
	public AndroidElement tv_homeTong;
	@FindElementBy(text = "果礼银")
	public AndroidElement tv_homeYin;
	@FindElementBy(text = "日本清酒")
	public AndroidElement tv_homeJapan;
	@FindElementBy(text = "英国香水")
	public AndroidElement tv_homeEngland;
	@FindElementBy(text = "欧洲红酒")
	public AndroidElement tv_homeEurope;

	// 商城精选 新品上架
	@FindElementBy(id = "id/ll_show1")
	public AndroidElement ll_homeShow1;
	@FindElementBy(id = "id/ll_show2")
	public AndroidElement ll_homeShow2;
	@FindElementBy(id = "id/ll_show3")
	public AndroidElement ll_homeShow3;

	// 商城精选 发现好货
	@FindElementBy(id = "id/img_find1")
	public AndroidElement img_homeFind1;
	@FindElementBy(id = "id/img_find2")
	public AndroidElement img_homeFind2;

	// 为您推荐
	@FindElementBy(id = "id/ll_buyzhinan")
	public AndroidElement ll_homeBuyZhiNan;// 购买指南
	@FindElementBy(id = "id/ll_storeinfo")
	public AndroidElement ll_homeStoreInfo;// 商城情报
	@FindElementBy(id = "id/ll_gonggao")
	// 公告
	public AndroidElement ll_homeGongGao;

	// 商城精选
	public void mallSeclect() throws Exception {
		((AndroidElement)BaseAction.driver.findElementById(BaseTest.mAppMainPackage + ":id/ll_show1")).click();// 新品上架	
		Thread.sleep(3000);
		BaseAction.mReturn();
		Thread.sleep(3000);
		((AndroidElement) BaseAction.driver.findElementById(BaseTest.mAppMainPackage + ":id/ll_show2")).click();//
		Thread.sleep(3000);
		BaseAction.mReturn();
		Thread.sleep(3000);
		((AndroidElement) BaseAction.driver.findElementById(BaseTest.mAppMainPackage + ":id/ll_show3")).click();// 	
		Thread.sleep(3000);
		BaseAction.mReturn();
		Thread.sleep(3000);
		// 发现好货
		((AndroidElement) BaseAction.driver.findElementById(BaseTest.mAppMainPackage + ":id/img_find1")).click();// 发现好货
		Thread.sleep(3000);
		BaseAction.mReturn();
		Thread.sleep(3000);
		((AndroidElement) BaseAction.driver.findElementById(BaseTest.mAppMainPackage + ":id/img_find2")).click();
		Thread.sleep(3000);
		BaseAction.mReturn();
	}

	public HomePage() {
		super();

	}

	public static HomePage verify() {
		return new HomePage();
	}

	
}
