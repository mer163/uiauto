package com.zbwx.autotest.ui.pageobject;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;


import com.zbwx.autotest.ui.pageobject.homeobject.HomePageService;
import com.zbwx.autotest.ui.pageobject.orderobject.CommodityListPage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

/**
 * 首页
 * @author zbwx
 *
 */
public class HomePage extends BasePage{

	@FindElementBy(text="首页")
	public AndroidElement homepage;

	@FindElementBy(text="定购")
	public AndroidElement order;

	/*@FindElementBy(text="发现")
	public AndroidElement dfind;*/
	@FindElementBy(id = "id/quanzi_img")
	public AndroidElement dfind;

	@FindElementBy(text="我的")
	public AndroidElement my;

	@FindElementBy(id = "id/first_text")
	public AndroidElement home_bottom;// verify=true时 id必须为不包含包名的id，减少与服务器交互次数

	@FindElementBy(id = "id/tv_search")
	public AndroidElement btn_homeSearch;// 搜索

	@FindElementBy(id = "id/img_kefu")
	public AndroidElement img_homeService; // 客服

	@FindElementBy(id = "id/img_tixing")
	public AndroidElement img_homeMessage;// 消息

	@FindElementBy(id = "id/textswitch")
	public AndroidElement tv_TextSwitch;// 播报

	@FindElementBy(id = "id/cbLoopViewPager")
	public AndroidElement vp_homeCbLoopViewPager;// 轮播图

	@FindElementBy(text = "更多")
	public AndroidElement tv_homeMoreylName;//更多

	// 首页热门商品
	@FindElementBy(id = "id/tv_allproduct")
	public AndroidElement tv_homeAllProduct;// 首页全部商品点这里

	@FindElementBy(id = "id/tv_productname",index=0)
	public AndroidElement tv_homeNie;
	@FindElementBy(id = "id/tv_productname",index=1)
	public AndroidElement tv_homeTong;
	@FindElementBy(id = "id/tv_productname",index=2)
	public AndroidElement tv_homeYin;
	@FindElementBy(id = "id/tv_productname",index=3)
	public AndroidElement tv_homeJapan;
	@FindElementBy(id = "id/tv_productname",index=4)
	public AndroidElement tv_homeEngland;
	@FindElementBy(id = "id/tv_productname",index=5)
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




	protected HomePage() {
		super();

	}

	public static HomePage verify() {
		return new HomePage();
	}

	//点击搜索
	public void clickSearch() throws Exception{
		this.btn_homeSearch.click();
		BaseAction.device.sendText("cccc");

	}


	//点击首页按钮
	public void clickHomePage(){
		this.homepage.click();
	}
	//点击定购按钮
	public void clickOrder(){
		this.order.click();
	}
	//点击发现按钮
	public void clickFind(){
		this.dfind.click();
	}
	//点击发现按钮
	public void clickMy(){
		this.my.click();
	}



	//点击热门商品
	public void clickHotProduct() throws Exception {
		this.tv_homeNie.click();
		Thread.sleep(2000);
		BaseAction.mReturn();
		Thread.sleep(2000);
		this.tv_homeTong.click();
		Thread.sleep(2000);
		BaseAction.mReturn();
		Thread.sleep(2000);
		this.tv_homeYin.click();
		Thread.sleep(2000);
		BaseAction.mReturn();
		Thread.sleep(2000);
		this.tv_homeJapan.click();
		Thread.sleep(2000);
		BaseAction.mReturn();
		Thread.sleep(2000);
		this.tv_homeEngland.click();
		Thread.sleep(2000);
		BaseAction.mReturn();
		Thread.sleep(2000);
		this.tv_homeEurope.click();
		Thread.sleep(2000);
		BaseAction.mReturn();

	}


	// 商城精选
	public void mallSeclect() throws Exception {
		//新品上架
		this.ll_homeShow1.click();
		Thread.sleep(3000);
		BaseAction.mReturn();

		this.ll_homeShow2.click();
		Thread.sleep(3000);
		BaseAction.mReturn();

		this.ll_homeShow3.click();
		Thread.sleep(3000);
		BaseAction.mReturn();

		// 发现好货
		this.img_homeFind1.click();
		Thread.sleep(3000);
		BaseAction.mReturn();

		this.img_homeFind2.click();
		Thread.sleep(3000);
		BaseAction.mReturn();
	}



	/**
	 * 获取ID元素文本信息
	 * @param str
	 * @return
	 */
	public String getTextById(String str){
		AndroidElement text = BaseAction.driver.findElementById(str);
		return text.getText();
	}

}
