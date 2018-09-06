package com.zbwx.autotest.ui.homepage;



import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.homeobject.HomePageService;
import com.zbwx.autotest.ui.pageobject.homeobject.JiBenAnalysisService;
import com.zbwx.autotest.ui.pageobject.homeobject.JiShuAnalysisService;
import com.zbwx.autotest.ui.pageobject.homeobject.ShopGongLueService;
import com.zbwx.autotest.ui.pageobject.homeobject.ZiZhuService;
import com.zbwx.autotest.ui.utils.Assertion;
/**
 * 
 * @author zbwx
 * @date 2018年7月31日
 * 首页客服测试
 */
public class ServiceTest extends BaseTest {

	
	@BeforeClass    
	public void beforeclass() throws Exception{	//所有方法开始前执行
		//从首页进入客服中心页面
		HomePage.verify().img_homeService.click();
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception{//每个方法执行前执行
		//当前是否处于客服中心页面，否则返回首页点击客服客服重新进入
		if (!HomePageService.verify().mKeFuGuiZe.getText().equals("交易规则")) {
			
			BaseAction.mReturnHomePage();
			HomePage.verify().img_homeService.click();
		
		}
			
	}

	@AfterMethod //每个方法执行完后执行
	public void aftermthod() throws Exception{
		
		Assertion.VerityTextPresentPrecision("客服中心", "当前为客服中心页面......");
		BaseAction.mReturnHomePage();
		HomePage.verify().img_homeService.click();
	}

	@AfterClass
	public void afterClass() throws Exception{
		//所有测试方法执行完后执行			
	}
	
	@Test(description = "客服中心贴心小助手")
	public void testServiceCentreZhuShou() throws Exception{
		
		//点击贴心小助手
		HomePageService.verify().mServicesBanner.click();
		//((AndroidElement) BaseAction.driver.findElementById("com.ylmall.app.ui:id/newcfd_activity_kf_banner")).click();		
		Thread.sleep(3000);
		//发送内容给客服
		ZiZhuService.verify().mSendContener();
		Thread.sleep(3000);
		ZiZhuService.verify().mTvZiZhuServiceBack.click();		
		
		
	}
	
	@Test(description = "客服中心交易规则")
	public void testServiceCentreGuiZe() throws Exception{
		//点击客服中心交易规则
		HomePageService.verify().mClickKeFuGuiZe();
		HomePageService.verify().mBtnBackService.click();
		
		

	}
	@Test(description = "客服中心找回密码")
	public void testServiceCentreFindMiMa() throws Exception{
		//点击找回密码
		HomePageService.verify().mPassWordFind.click();
		HomePageService.verify().mBtnBackService.click();
	}
	@Test(description = "客服中心购物攻略")
	public void testServiceCentreGongLue() throws Exception{
		//点击购物攻略		
		HomePageService.verify().mClickHelpGuide1();
		Thread.sleep(2000);		
		ShopGongLueService.verify().mClick();
		Thread.sleep(2000);
		HomePageService.verify().mHelpGuide1.click();
		
	}
	
	@Test(description = "客服中心基本面分析")
	public void testServiceCentreJiBenFenXi() throws Exception{
		//点击基本面分析	
		HomePageService.verify().mClickHelpGuide6();
		Thread.sleep(3000);
		JiBenAnalysisService.verify().mClick();
		Thread.sleep(2000);
		HomePageService.verify().mHelpGuide6.click();

	}
	@Test(description = "客服中心技术分析")
	public void testServiceCentreJiShuFenXi() throws Exception{
		//点击技术分析
		HomePageService.verify().mClickHelpGuide7();
		Thread.sleep(2000);
		JiShuAnalysisService.verify().mClick();
		Thread.sleep(2000);		
		HomePageService.verify().mHelpGuide7.click();
		
	}
	@AfterClass
	public void afterClassResult() {
		
	}
}
