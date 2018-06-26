package com.zbwx.autotest.ui;

import atx.client.AtxClient;
import atx.client.model.DesiredCapabilities;

public class Test1 {
	
	
	static AtxClient driver = new AtxClient();
	private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	
	public static void main(String[] args) throws Exception {
		
		desiredCapabilities.setPackageName("com.ylmall.app.ui");
        desiredCapabilities.setRemoteHost("192.168.0.72");
        desiredCapabilities.setPlatformName("Android");
        driver.initDriver(desiredCapabilities);
//        Thread.sleep(10000);
        driver.startUiAutomator();
        System.out.println(driver.getCurrentActivity());
        
        
        driver.elementByName("我的").click();
	}
}
