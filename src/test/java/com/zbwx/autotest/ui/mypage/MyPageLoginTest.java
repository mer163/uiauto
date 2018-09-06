package com.zbwx.autotest.ui.mypage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.myobject.LoginWithPassword;
import com.zbwx.autotest.ui.myobject.LoginWithSmsPage;
import com.zbwx.autotest.ui.myobject.MyPage;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.utils.Assertion;
/**
 * 
 * @author zbwx
 *用户登录登录平台
 */
public class MyPageLoginTest extends BaseTest {

	@BeforeClass
	public void beforeclass() throws Exception { // 所有方法开始前执行

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {// 每个方法执行前执行

	}

	@AfterMethod
	// 每个方法执行完后执行
	public void aftermthod() throws Exception {

		Assertion.VerityTextPresentPrecision("果礼商城", "当前为个人中心页面......");

	}

	@AfterClass
	public void afterClass() throws Exception {
		// 所有测试方法执行完后执行
	}

	// 测试用户登录失败
	@Test(description = "testLoginFailed")
	public void testLoginFailed() throws Exception {
		// 页面启动之后点击导航我的进入个人中心页面
		HomePage.verify().clickMy();
		// 当前是否处于客服中心页面，否则返回首页点击客服客服重新进入
		if (MyPage.verify().mMyPageNoLoginFenSi.getText().equals("粉丝：-- --")) {

			// 点击头像，进入登录页面
			MyPage.verify().clickHeadImage();

		}
		// 点击密码登录，跳转至密码登录页面
		LoginWithSmsPage.verify().passwordLogin.click();
		// 进入密码登录页面点击登录
		LoginWithPassword.verify().loginFailed();

	}

	// 测试用户登录成功
	@Test(description = "testLoginSuccess")
	public void testLoginSuccess() throws Exception {
		// 登录失败后直接走这个登录成功的方法
		LoginWithPassword.verify().loginSuccess();

	}

}
