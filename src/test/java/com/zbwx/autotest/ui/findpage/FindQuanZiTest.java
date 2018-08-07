package com.zbwx.autotest.ui.findpage;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BaseTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.pageobject.FindPage;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.utils.Assertion;

public class FindQuanZiTest extends BaseTest {
	@BeforeClass
	public void beforeclass() throws Exception {
		BaseAction.driver.startUiAutomator();
		Thread.sleep(3000);
	}

	@Test(description = "发现圈子资讯")
	public void testFindQuanZiAndZiXun() throws Exception {
		FindPage findPage = new FindPage();
		findPage.mClickFindDaoHang();
		Assertion.VerityTextPresentPrecision("话题", "当前处于发现页面..默认圈子页面...");
		FindPage findPage1 = new FindPage();
		BaseAction.device.click(findPage1.mChiCangZiXun);
		Assertion.VerityTextPresentPrecision("购买指南", "当前处于资讯页面.....");
		BaseAction.device.click(findPage1.mChiCangQuanZi);
		Assertion.VerityTextPresentPrecision("话题", "当前处于发现页面..默认圈子页面...");
		BaseAction.mReturnHomePage();
	}

	@Test(description = "发现话题")
	public void testFindHuaTi() throws Exception {
		FindPage findPage = new FindPage();
		findPage.mClickFindDaoHang();
		Assertion.VerityTextPresentPrecision("话题", "当前处于发现页面..默认圈子页面...");
		FindPage findPage1 = new FindPage();
		BaseAction.device.click(findPage1.mHuaTiImg);
		Thread.sleep(3000);
		FindPage findPage2 = new FindPage();
		BaseAction.device.click(findPage2.mHuaTitx_back);
		Assertion.VerityTextPresentPrecision("话题", "当前处于发现页面..默认圈子页面...");
		BaseAction.mReturnHomePage();

	}
	@Test(description = "发现热门关注全部")
	public void testFindReMenGuanZhuAll() throws Exception {
		FindPage findPage = new FindPage();
		findPage.mClickFindDaoHang();
		Assertion.VerityTextPresentPrecision("话题", "当前处于发现页面..默认圈子页面...");
		Assertion.VerityTextPresentPrecision("话题", "当前处于发现页面..默认热门页面...");
		FindPage findPage1 = new FindPage();
		BaseAction.device.click(findPage1.mFindGuanZhu);
		Thread.sleep(3000);
		BaseAction.device.click(findPage1.mFindAll);
		Thread.sleep(3000);
		BaseAction.device.click(findPage1.mFindReMen);
		Assertion.VerityTextPresentPrecision("话题", "当前处于发现页面..默认热门页面...");
		BaseAction.mReturnHomePage();
	}
	@AfterClass
	public void afterClassResult() {

	}
}
