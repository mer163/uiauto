package com.zbwx.autotest.ui.base;
import atx.client.adb.AdbDevice;
import atx.client.adb.Position;
import atx.client.model.DesiredCapabilities;
import com.zbwx.autotest.ui.browser.Browsers;
import com.zbwx.autotest.ui.browser.Element;
import com.zbwx.autotest.ui.browser.WebBrowser;
import com.zbwx.autotest.ui.utils.WebCommonFunction;
import org.testng.annotations.*;

import com.beust.testng.TestNG;
import com.zbwx.autotest.ui.utils.Log;

import atx.client.AtxClient;
import atx.client.adb.AdbDevice;
import atx.client.adb.ElementAttribs;



import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
//	public static AndroidDriver android_driver;
//	public static AdbBaseAction.device BaseAction.device ;
//	public static AtxClient driver ;
//	public static BaseAction.position BaseAction.position;

	public static String mAppMainPackage;
	public Browsers browser;
	public WebBrowser driver;
	public WebCommonFunction cf;
	public Element el;
	
	//方法描述
	public static String description;
	public Log log=new Log(this.getClass().getSuperclass());
	@BeforeSuite
	@Parameters({"udid","driverName","appName","apkName","remoteIP","browsertype","browserversion","sdkVersion","appMainPackage","appActivity","platformName","install"})
	public void  setup(String udid, String driverName,String appName,String apkName, String remoteIP,String browsertype,String browserversion,String sdkVersion,String appMainPackage,String appActivity,String platformName,String install) throws  InterruptedException {

		mAppMainPackage=appMainPackage;
		//获取app路径
		File classRootPath = new File(System.getProperty("user.dir"));
		File appDir = new File(classRootPath, "apps");
		File app = new File(appDir,apkName);

		log.info("------------------开始初始化测试---------------");
		
		if(remoteIP.equals("")||remoteIP.isEmpty())
		{
			log.error("设备ip为空");
		}
		else {
			log.info("读取xml配置：Mobile Driver:"+driverName+"；测试设备IP:" + remoteIP);

			try {
				if(driverName.equals("web")){
					log.info("初始化webdriver，测试web");
					initBrowser(browsertype,browserversion,remoteIP);
				}else if (driverName.equals("AtxDriver")){
					log.info("初始化AtxDriver，测试移动端");
					initOperators(udid,apkName, remoteIP,platformName,sdkVersion,appMainPackage,appActivity);
					BaseAction.driver.startUiAutomator();
					BasePage.setDriver(BaseAction.driver);
					//获取设备信息
					log.info("设备序列号: " + BaseAction.device.getDeviceId());
					log.info("设备名称: " + BaseAction.device.getDeviceName());
					int[] resolution = BaseAction.device.getScreenResolution();
					log.info("设备屏幕分辨率: " + resolution[0] + "x" + resolution[1]);
					log.info("设备Android版本: " + BaseAction.device.getAndroidVersion());
					log.info("设备SDK版本:  " + BaseAction.device.getSdkVersion());
					log.info("设备电池状态： " + BaseAction.device.getBatteryStatus());
					log.info("设备电池温度： " + BaseAction.device.getBatteryTemp());
					log.info("设备电池电量： " + BaseAction.device.getBatteryLevel());
					//判断安装方式 1、卸载后安装
					if (Integer.parseInt(install)==1) {

						BaseAction.device.removeApp(appMainPackage);

					}else if (Integer.parseInt(install)==2) {
						//覆盖安装

					}
					if (apkName !=null || apkName!=""){
						//安装app
					}
					//解锁屏幕
					BaseAction.device.unlock_device();
					//启动app
					BaseAction.device.startApp(appMainPackage);
				}else if (driverName.equals("appium")){
					log.info("初始化appium");
				}


			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				log.error("环境配置失败");
			}
		}

	}

	@AfterSuite
	public void tearDown() throws IOException {
		try{
			if(BaseAction.device !=null) {
				BaseAction.device.quitCurrentApp();	 //退出app
//				this.driver.stopUiAutomator();
			}
			if (this.driver !=null){
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("driver关闭失败");
		}
		
		log.info("-------------结束测试，并关闭退出driver,关闭uiautomator-------------");
	}

	
	private void initOperators(String udid,String apkName,String deviceIp,String platformName, String sdkVersion, String appPackageName,String appStartActivity) throws MalformedURLException {
		
		
		DesiredCapabilities des = new DesiredCapabilities();
		des.setUdid(udid);
		des.setPackageName(appPackageName);
		des.setPlatformName(platformName);
		des.setRemoteHost(deviceIp);


		BaseAction.position = Position.getInstance(des);
		BaseAction.device = new AdbDevice(des);
		BaseAction.driver = new AtxClient(des);
//		driver.initDriver(des);
//		return driver;
		
	}

	private void initBrowser(String browsertype,String browserversion,String remoteIP) throws Exception{
		log.info("初始化browser:"+ browsertype + " browserversion:" +browserversion + " remoteIP:" + remoteIP);
		browser = new Browsers();
		driver = browser.initBrowser("chrome"+browserversion, browsertype, browserversion, remoteIP);
		cf = new WebCommonFunction(driver);
		el = new Element(driver);
		Thread.sleep(5000);
	};

	
//	public static void main(String args[])
//	{
////		WebDriver driver2=new FirefoxDriver();
//		WebDriver driver1 = new ChromeDriver();
//		driver1.get("http://www.baidu.com");
////		driver2.get("http://www.baidu.com");
//	}


}
