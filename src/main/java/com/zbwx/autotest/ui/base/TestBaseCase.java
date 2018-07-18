package com.zbwx.autotest.ui.base;
import org.testng.annotations.*;
import com.zbwx.autotest.ui.utils.Log;

import atx.client.AtxClient;
import atx.client.adb.AdbDevice;
import atx.client.adb.AdbDevice;
import atx.client.adb.Position;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseCase {
//	public static AndroidDriver android_driver;
	public static AdbDevice device ;
	public static AtxClient driver = new AtxClient();
	public static Position position;

	//方法描述
	public static String description;
	public Log log=new Log(this.getClass().getSuperclass());
	@BeforeSuite
	@Parameters({"driverName","appName","apkName","deviceIp","sdkVersion","appMainPackage","appActivity","platformName","install"})
	public void  setup( String driverName,String appName,String apkName, String deviceIp,String sdkVersion,String appMainPackage,String appActivity,String platformName,String install) throws MalformedURLException {

		log.info("------------------开始初始化测试---------------");
		
		if(deviceIp.equals("")||deviceIp.isEmpty())
		{
			log.error("设备ip为空");
		}
		else {
			//获取app路径
			File classRootPath = new File(System.getProperty("user.dir"));
			File appDir = new File(classRootPath, "apps");
			File app = new File(appDir,apkName);
			log.info("");
			
			//判断安装方式 1、卸载后安装
			if (Integer.parseInt(install)==1) {
				
				device.removeApp(appMainPackage);
				
			}else if (Integer.parseInt(install)==2) {
				//覆盖安装
				
			}
			if (apkName !=null || apkName!=""){
				//安装app
			}
			
			
			log.info("读取xml配置：Mobile Driver:"+driverName+"；测试设备IP:" + deviceIp);
			
			try {
				
				driver =  setDriver(apkName, deviceIp,platformName,sdkVersion,appMainPackage,appActivity);
				driver.startUiAutomator();
				//获取设备信息
				log.info("设备序列号: " + device.getDeviceId());
				log.info("设备名称: " + device.getDeviceName());
				int[] resolution = device.getScreenResolution();
				log.info("设备屏幕分辨率: " + resolution[0] + "x" + resolution[1]);
				log.info("设备Android版本: " + device.getAndroidVersion());
				log.info("设备SDK版本: " + device.getSdkVersion());
				log.info("设备电池状态： " + device.getBatteryStatus());
				log.info("设备电池温度： " + device.getBatteryTemp());
				log.info("设备电池电量： " + device.getBatteryLevel());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.error("环境配置失败");
			}
			//
		}

	}

	@AfterSuite
	public void tearDown() throws IOException {
		try{
			if(this.device !=null) {
				device.quitCurrentApp();	 //退出app
//				this.driver.stopUiAutomator();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("driver关闭失败");
		}
		
		log.info("-------------结束测试，并关闭退出driver,关闭uiautomator-------------");
	}
	
	@BeforeClass
	public void beforeClass() {
		log.info("beforeClass ");
		
	}
	
	private AtxClient setDriver(String apkName,String deviceIp,String platformName, String sdkVersion, String appPackageName,String appStartActivity) throws MalformedURLException {
		
		
		atx.client.model.DesiredCapabilities des = new atx.client.model.DesiredCapabilities();
		des.setPackageName(appPackageName);
		des.setPlatformName(platformName);
		des.setRemoteHost(deviceIp);
		position = Position.getInstance(des);
		device = new AdbDevice(des);
		driver.initDriver(des);
		return driver;
		
	}
	
	
//	public static void main(String args[])
//	{
////		WebDriver driver2=new FirefoxDriver();
//		WebDriver driver1 = new ChromeDriver();
//		driver1.get("http://www.baidu.com");
////		driver2.get("http://www.baidu.com");
//	}


}
