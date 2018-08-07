package com.zbwx.autotest.ui.pageobject;

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
import atx.client.remote.PageFactory;

public class HomePage1 extends BasePage{
	
	@FindElementBy(id="com.ylmall.app.ui:id/first_text")
	public AndroidElement home_bottom;
	
	@FindElementBy(text="我的")
	public AndroidElement my;

	public HomePage1(){
		super();
	}

//	public HomePage1() {
//		PageFactory.initElements(this, driver);
//	}
	

	
}
