package com.zbwx.autotest.ui.base;

import atx.client.AtxClient;
import atx.client.adb.AdbDevice;
import atx.client.adb.ElementAttribs;
import atx.client.adb.Position;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.zbwx.autotest.ui.utils.Locator;
import com.zbwx.autotest.ui.utils.Log;
import com.zbwx.autotest.ui.utils.XmlReadUtil;
import com.zbwx.autotest.ui.utils.YamlReadUtil;
import com.zbwx.autotest.ui.utils.Locator.ByType;

import atx.client.common.ElementObj;
import atx.client.model.AndroidElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class BaseAction {

	protected HashMap<String,Locator>  locatorMap;
	public String path=null;
	public InputStream path_inputStream_1;
	public InputStream path_inputStream_2;

	public static AtxClient driver;
	public static Position position;
	public static AdbDevice device;

	Log log=new Log(this.getClass());

	public  void setXmlObjectPath(String path)
	{
		this.path=path;
	}
	public  void setXmlObjectPathForLocator(InputStream path_inputStream)
	{
		this.path_inputStream_1=path_inputStream;
	}
	public  void setXmlObjectPathForPageURL(InputStream path_inputStream)
	{
		this.path_inputStream_2=path_inputStream;
	}
	/**
	 * 构造方法，创建创建BasePageOpera对象时，需要初始化的信息.传递相关参数
	 * this.getClass().getCanonicalName() 获取page类路径，也就是xml文档中的pageName
	 * @throws Exception
	 */
	public  BaseAction()
	{


	}



	/**
	 * 等待打开APP
	 */
	public static void mWaitOpenApp(){
		BaseAction.position.waitForElement(ElementAttribs.TEXT, "客服", 10000);
	}

	/**
	 * 任意页面点击物理返回键，回到首页
	 */
	public static void mReturnHomePage(){
		do{
			if(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/first_img", 2000)){
				BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/first_img"));
				break;
			}else{
				BaseAction.driver.press("back");
			}
		}while(!BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/tv_allproduct", 3000));
	}

	/**
	 * 以ID点击页面返回按钮
	 */
	public static void mClickReturnButton(){
		if(BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/baseweb_back", 3000)){
			BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/baseweb_back"));
		}else if (BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/leftBtn", 3000)) {
			BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/leftBtn"));
		}else if (BaseAction.position.waitForElement(ElementAttribs.RESOURCE_ID, "com.ylmall.app.ui:id/leftBtn_mykaquan", 3000)) {
			BaseAction.device.click(BaseAction.position.findElementById("com.ylmall.app.ui:id/leftBtn_mykaquan"));
		}
	}
	/**
	 * 返回上一个页面
	 */
	public static void mReturn(){

		BaseAction.driver.press("back");

	}



	public void getLocatorMap()
	{
		XmlReadUtil xmlReadUtil=new XmlReadUtil();
		YamlReadUtil yamlReadUtil=new YamlReadUtil();
		try {
			if((path==null||path.isEmpty()))
			{locatorMap = xmlReadUtil.readXMLDocument(path_inputStream_1, this.getClass().getCanonicalName());}
			else {
				if (path.contains(".xml"))
				{
					locatorMap = xmlReadUtil.readXMLDocument(path, this.getClass().getCanonicalName());
				}else if (path.contains(".yaml")) {
					locatorMap=yamlReadUtil.getLocatorMap(path,this.getClass().getCanonicalName());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static By getBy (ByType byType,Locator locator)
	{
		switch(byType)
		{
			case id:
				return By.id(locator.getElement());
			case cssSelector:
				return By.cssSelector(locator.getElement());
			case name:
				return By.name(locator.getElement());
			case xpath:
				return By.xpath(locator.getElement());
			case className:
				return By.className(locator.getElement());
			case tagName:
				return By.tagName(locator.getElement());
			case linkText:
				return By.linkText(locator.getElement());
			case partialLinkText:
				return By.partialLinkText(locator.getElement());
			//return null也可以放到switch外面
			default:
				return null;
		}


	}

	/**
	 * 从对象库获取定位信息
	 * @param locatorName 对象库名字
	 * @return
	 * @throws IOException
	 */
	public  Locator getLocator(String locatorName)
	{
		Locator locator;
		/**
		 * 在对象库通过对象名字查找定位信息
		 */
		locator=locatorMap.get(locatorName);
		/**
		 * 加入对象库，找不到该定位信息，就创建一个定位信息
		 */
		if(locator==null)
		{
			log.error("没有找到"+locatorName+"页面元素");
		}
		return locator;

	}

	public String getPageURL()
	{
		String pageURL=null;
		try {
			if(path==null||path.isEmpty())
			{pageURL=XmlReadUtil.getXmlPageURL(path_inputStream_1, this.getClass().getCanonicalName());}
			else {
				pageURL=XmlReadUtil.getXmlPageURL(path, this.getClass().getCanonicalName());
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pageURL;
	}

	/**
	 * 打开浏览器
	 * @param url
	 */
//	public void open(String url)
//	{
//		driver.navigate().to(url);
//		log.info("打开浏览器，访问"+url+"网址!");
//
//	}
	/***
	 * 关闭浏览器窗口
//	 */
//	public void close()
//	{
//		driver.close();
//		log.info("关闭浏览器窗口");
//	}
	/**
	 * 退出浏览器
	 */
//	public void quit()
//	{
//		driver.quit();
//		log.info("退出浏览器");
//	}
	/**
	 * 浏览器前进
	 * @throws Exception 
	 */
//	public void forward()
//	{
//		driver.navigate().forward();
//		log.info("浏览器前进");
//	}
//	/**
//	 * 浏览器后退
//	 */
//	public void back()
//	{
//		driver.navigate().back();
//		log.info("浏览器后退");
//	}
//	/**
//	 * 刷新浏览器
//	 */
//	public void refresh()
//	{
//		driver.navigate().refresh();
//		log.info("浏览器刷新");
//	}
//	public ElementObj findElement( final Locator locator) throws Exception
//	{
//		/**
//		 * 查找某个元素等待几秒
//		 */
//		Waitformax(Integer.valueOf(locator.getWaitSec()));
//		ElementObj webElement;
//		webElement=getElement(locator);
//		return webElement;
//
//
//	}
//	public void Waitformax(int t)
//	{
//		driver.manage().timeouts().implicitlyWait(t,TimeUnit.SECONDS);
//	}
	/**
	 * 通过定位信息获取元素
	 * @param locator
	 * @return
	 * @throws Exception 
	 * @throws NoSuchElementException
	 */
	public AndroidElement getElement(Locator locator) throws Exception
	{
		/**
		 * locator.getElement(),获取对象库对象定位信息
		 */
		//locator=getLocator(locatorMap.get(key));
//		WebElement webElement;
		AndroidElement webElement;
		switch (locator.getType())
		{
			case xpath :
				//log.info("find element By xpath");
				webElement=BaseAction.driver.findElementByXpath(locator.getElement());
//				webElement=BaseAction.driver.findElement(By.xpath(locator.getElement()));
				
				/**
				 * 出现找不到元素的时候，记录日志文件
				 */
				break;
			case id:
				//log.info("find element By xpath");
//				webElement=BaseAction.driver.findElement(By.id(locator.getElement()));
				webElement=BaseAction.driver.findElementById(locator.getElement());
				break;
//			case cssSelector:
//				//log.info("find element By cssSelector");
////				webElement=BaseAction.driver.findElement(By.cssSelector(locator.getElement()));
//				webElement=driver.elementBy(locator.getElement());
//				break;
			case name:
				//log.info("find element By name");
//				webElement=BaseAction.driver.findElement(By.name(locator.getElement()));
				webElement=BaseAction.driver.findElementByName(locator.getElement());
				break;
			case className:
				//log.info("find element By className");
				webElement = BaseAction.driver.findElementByClass(locator.getElement());
//				webElement=BaseAction.driver.findElement(By.className(locator.getElement()));
				break;
//			case linkText:
//				//log.info("find element By linkText");
//				webElement=BaseAction.driver.findElement(By.linkText(locator.getElement()));
//				break;
//			case partialLinkText:
//				//log.info("find element By partialLinkText");
//				webElement=BaseAction.driver.findElement(By.partialLinkText(locator.getElement()));
//				break;
//			case tagName:
//				//log.info("find element By tagName");
//				webElement=BaseAction.driver.findElement(By.partialLinkText(locator.getElement()));
//				break;
			default :
				//log.info("find element By xpath");
//				webElement=BaseAction.driver.findElement(By.xpath(locator.getElement()));
				webElement=BaseAction.driver.findElementByXpath(locator.getElement());
				break;

		}
		return webElement;
	}


}
