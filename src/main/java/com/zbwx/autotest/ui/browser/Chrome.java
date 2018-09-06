package com.zbwx.autotest.ui.browser;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.zbwx.autotest.ui.config.Config;
import org.dom4j.DocumentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.zbwx.autotest.ui.utils.WebPath;

import static com.zbwx.autotest.ui.utils.XmlReadUtil.getTestngParametersValue;


public class Chrome extends WebBrowser {
	
	public Chrome(String chrome_version, String remoteip){
		super();
		String testh5=null;//是否为测试h5项目，yes为测试h5 默认添加iphone6 ua
		if (chrome_version == null ||chrome_version == "" || remoteip == null || remoteip == "") {
			System.setProperty("webdriver.chrome.driver", WebPath.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			//options.setExperimentalOption("forceDevToolsScreenshot", true);
			driver = new ChromeDriver(options);
		} else {
            try {
                DesiredCapabilities capability = DesiredCapabilities.phantomjs();
                testh5 = getTestngParametersValue(Config.path1, "testh5");
                DesiredCapabilities desiredCaps = new DesiredCapabilities("chrome", chrome_version, Platform.LINUX);
                if(testh5.equals("yes")){
                    Map<String, String> mobileEmulation = new HashMap<String, String>();
                    //设置设备,例如:Google Nexus 7/Apple iPhone 6
                    //mobileEmulation.put("deviceName", "Google Nexus 7");
                    mobileEmulation.put("deviceName", "Apple iPhone 6 Plus");   //这里是要使用的模拟器名称，就是浏览器中模拟器中的顶部型号
                    Map<String, Object> chromeOptions = new HashMap<String, Object>();
                    chromeOptions.put("mobileEmulation", mobileEmulation);
                    desiredCaps.setCapability(ChromeOptions.CAPABILITY,chromeOptions);

                }
                driver = new RemoteWebDriver(new URL("http://" + remoteip + ":4444/wd/hub/"), desiredCaps);
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

}