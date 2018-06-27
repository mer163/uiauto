package com.zbwx.autotest.ui.pageObject;

import com.zbwx.autotest.ui.utils.TestBaseCase;

import atx.client.common.ElementObj;

public class HomePage extends TestBaseCase{
	
	
	private ElementObj home_bottom;

	public ElementObj getHome_bottom() {
		return home_bottom;
	}

	public void setHome_bottom() throws Exception {
		this.home_bottom = driver.elementByName("首页");
	}
	
	
	
	
}
