package com.zbwx.autotest.ui.mypage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.zbwx.autotest.ui.base.BaseTest;
import com.zbwx.autotest.ui.myobject.LoginWithPassword;
import com.zbwx.autotest.ui.myobject.LoginWithSmsPage;
import com.zbwx.autotest.ui.myobject.MyPage;
import com.zbwx.autotest.ui.pageobject.HomePage;
import com.zbwx.autotest.ui.utils.Assertion;

/**
 * 
 * @author zbwx 登录交易所
 */
public class MyPageBourseTest extends BaseTest {
	@BeforeClass
	public void beforeclass() throws Exception { // 所有方法开始前执行
		// 页面启动之后点击导航我的进入个人中心页面
		HomePage.verify().clickMy();
		// 判断用户是否已经登录

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {// 每个方法执行前执行
		// 如果粉丝显示不是“粉丝：-- --”，说明已经登陆陆成功
		if (MyPage.verify().mMyPageNoLoginFenSi.getText().equals("粉丝：-- --")) {

			// 如果粉丝为"粉丝：-- --"点击头像进行登录
			// 点击头像，进入登录页面
			MyPage.verify().clickHeadImage();
			// 点击密码登录，跳转至密码登录页面
			LoginWithSmsPage.verify().passwordLogin.click();
			// 进入密码登录页面点击登录
			LoginWithPassword.verify().loginFailed();
			Thread.sleep(2000);
			LoginWithPassword.verify().loginSuccess();
		} else if (!MyPage.verify().mMyPageNoLoginFenSi.getText().equals("粉丝：-- --")) {
			// 点击签到
			 MyPage.verify().mMyPageQianDao.click();
		}

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

}
