package com.zbwx.autotest.ui.findpage;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.pageobject.FindPage;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.pageobject.ZiXunPage;

import com.zbwx.autotest.ui.utils.Assertion;

public class FindQuanZiTest extends BaseTest {
	
	@BeforeClass    
	public void beforeclass() throws Exception{	//所有方法开始前执行
		Thread.sleep(3000);
		//启动后点击主页面的发现按钮进入发现页面
		HomePage.verify().clickFind();
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws Exception{//每个方法执行前执行
		//当前是否处于发现页面，如果不是返回首页重新点击发现
		/*if (!FindPage.verify().mFindGuanZhu.getText().equals("关注")) {
			
			HomePage.verify().clickFind();
		
		}*/
			
	}

	@AfterMethod //每个方法执行完后执行
	public void aftermthod() throws Exception{
		
		Assertion.VerityTextPresentPrecision("圈子", "当前为发现页面......");		
	
	}

	@AfterClass
	public void afterClass() throws Exception{
		//所有测试方法执行完后执行			
	}

	@Test(description = "发现圈子资讯点击相互切换")
	public void testFindQuanZiAndZiXun() throws Exception {
		
		//首先点击咨询再点击圈子确认可以相互切换
		FindPage.verify().mChiCangZiXun.click();
		FindPage.verify().mChiCangQuanZi.click();
		Thread.sleep(2000);
		//点击话题里面的任意一张图片进入对应的话题页面点击返回按钮返回圈子页面
		FindPage.verify().mHuaTiImg.click();
		BaseAction.mReturn();

		
	}
	@Test(description = "点击切换发现资讯")
	public void  testFindZiXun() throws Exception{
		//点击发现页面的资讯进入资讯页面
		FindPage.verify().mChiCangZiXun.click();
		Thread.sleep(2000);
		//点击咨讯页面的购买指南，商城情报，公告进行页面内容切换
		ZiXunPage.verify().ll_homeStoreInfo.click();
		ZiXunPage.verify().ll_homeGongGao.click();
		ZiXunPage.verify().ll_homeBuyZhiNan.click();
		
	}
	@Test(description = "点击发现热门关注全部进行切换页面")
	public void testFindReMenGuanZhuAll() throws Exception {
		//默认在热门页面点击关注，全部热门进行操作
		FindPage.verify().mClickFind();
		
	}
	@AfterClass
	public void afterClassResult() {

	}
}
