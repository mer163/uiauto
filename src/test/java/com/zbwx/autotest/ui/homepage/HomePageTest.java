package com.zbwx.autotest.ui.homepage;



import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageNotifications;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageSearch;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageService;
import com.zbwx.autotest.ui.utils.Assertion;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * 
 * @author zbwx
 * @date 2018年8月1日
 * 首页测试
 */
public class HomePageTest extends BaseTest {
    

	@BeforeClass
	public void beforeClass() throws Exception {
		
		Thread.sleep(3000);
	}

	@BeforeMethod
	public void beforeMethod() throws Exception{
		//每个方法执行前执行
	
	}

	@AfterMethod
	public void aftermthod() throws Exception{
		//每个方法执行完后执行		
		Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() throws Exception{
		//所有测试方法执行完后执行		
		Assertion.VerityTextPresentPrecision("热门商品", "当前为首页......");
	}
		
	@Test(description = "点击客服")
	public void testHomePageService() throws Exception{
		//点击首页客服按钮进入客服中心
		HomePage.verify().img_homeService.click();
		//点击客服中心返回按钮 返回首页
		HomePageService.verify().mBtnBackService.click();
		
	}
	
	@Test(description = "点击搜索")
	public void testHomePageSearch()  throws Exception{
		//点击首页的搜索框 
		HomePage.verify().clickSearch();
		//点击搜索按钮
		HomePageSearch.verify().clickImgRight();
		//点击返回按钮返回首页
		HomePageService.verify().mBtnBackService.click();
		
	}
	
	@Test(description = "点击消息")
	public void testHomePageMessage()  throws Exception{
		//点击首页消息按钮跳转消息中心页面
		HomePage.verify().img_homeMessage.click();
		//点击返回按钮返回首页
		HomePageNotifications.verify().mMessageBackBtn.click();
	}
	
	@Test(description = "首页轮播")
	public void testHomePageViewPager()  throws Exception{
		//点击轮播图跳转详情
		HomePage.verify().vp_homeCbLoopViewPager.click();
		//点击返回首页
		HomePageService.verify().mBtnBackService.click();
	}
	
	@Test(description = "首页盈利播报")
	public void testHomePageMoreylName()  throws Exception{
		//获取盈利播报的内容
		String str1 = HomePage.verify().getTextById(BaseTest.mAppMainPackage+":id/textswitch");
		Thread.sleep(2000);
		String str2 = HomePage.verify().getTextById(BaseTest.mAppMainPackage+":id/textswitch");
		Assertion.VerityBoolean(str1.equals(str2), false, "播报是否变动...");
		Thread.sleep(2000);
		//点击盈利播报的更多按钮跳转盈利榜
		HomePage.verify().tv_homeMoreylName.click();
		//点击返回首页
		HomePageService.verify().mBtnBackService.click();
	}
	
		
	@Test(description = "热门商品")
	public void testHomeHotCommodity()  throws Exception{
		//点击首页全部商品
		HomePage.verify().tv_homeAllProduct.click();
		//点击返回
		HomePageService.verify().mBtnBackService.click();
		//点击热门商品
		Thread.sleep(2000);
		HomePage.verify().clickHotProduct();
		
	}
	
	@Test(description = "商城精选")
	public void testHomeMallSelected()  throws Exception{
		//点击商城精选的各个商品跳转商品详情页
		HomePage.verify().mallSeclect();
		/*Ylmall.mSwipe(1);//向上滑半屏
		Thread.sleep(3000);*/
		
	}
   
	@Test(description = "为您推荐")
	public void testHomeForTuiJian()  throws Exception{
		
		//点击商城情报
		HomePage.verify().ll_homeStoreInfo.click();
		//点击公告
		HomePage.verify().ll_homeGongGao.click();
		//点击购买指南
		HomePage.verify().ll_homeBuyZhiNan.click();

	
	}
	
	@AfterClass
	public void afterClassResult() {
		
	}
}
