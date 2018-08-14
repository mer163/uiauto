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

	@FindElementBy(text="我的")
	public AndroidElement my;

	@FindElementBy(id= "id/first_text")		//verify=true时 id必须为不包含包名的id，减少与服务器交互次数
	public AndroidElement home_bottom;
	


	protected HomePage1(){
		super();

	}

	public static HomePage1 verify(){

		return  new HomePage1();
	}


	//点击我的 按钮
	public void clickMy(){
		this.my.click();
	}
}
