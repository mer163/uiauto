package com.zbwx.autotest.ui.utils;

import com.google.common.io.Files;

import atx.client.AtxClient;

import com.zbwx.autotest.ui.base.BaseAction;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShot {
//	public WebDriver driver;
	public AtxClient driver;
	public AtxClient atx_driver;
	private String screenName;
	Log log =new Log(this.getClass());
	public void setscreenName(String screenName)
	{
		this.screenName=screenName;
	}
//	public ScreenShot(WebDriver driver)
//	{
//		this.driver=driver;
//	}
	
	public ScreenShot(AtxClient driver) {
		this.driver = driver;
	}
	
	
	private void takeScreenshot(String screenPath) throws Exception {
		BaseAction.driver.takeScreenshot(screenPath);
//		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		
//		try {
//			Files.copy(scrFile, new File(screenPath));
//			log.error("错误截图："+screenPath);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
	}

	public  void takeScreenshot() throws Exception {
		String screenName =this.screenName+ ".jpg";
		File dir = new File("test-output" + File.separator +driver.getUdid() + File.separator +"snapshot" );
		if (!dir.exists())
		{dir.mkdirs();}
		String screenPath = dir.getAbsolutePath() + File.separator  + screenName;
		this.takeScreenshot(screenPath);
	}

}
