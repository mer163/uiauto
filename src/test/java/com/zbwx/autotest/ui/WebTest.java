package com.zbwx.autotest.ui;

import com.zbwx.autotest.ui.base.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WebTest extends BaseTest {

    @Test(description = "test")
    public void testBaidu() throws Exception{

//        driver.open("https://hzagent.gl-mall.net/Admin/#login");
//        Thread.sleep(5000);
//        Set<Cookie>cookies = driver.getAllCookies();
//        for(Cookie cook:cookies){
//            System.out.println(cook.getName() + "---" + cook.getValue());
//        }

//        String cookie = driver.getCookieValueByName("ASP.NET_SessionId");
//
//        driver.addCookie("ASP.NET_SessionId",cookie);
//
//        for(Cookie cook:cookies){
//            System.out.println(cook.getName() + "---" + cook.getValue());
//        }
//        Thread.sleep(5000);
//        driver.open("http://www.sina.com");




        driver.open("https://www.baidu.com");
        Thread.sleep(5000);
        // 开启开发者模式，方便观察请求
        Actions builder = new Actions(driver.getWebDriver());
        builder.sendKeys(Keys.F12).perform();

        JavascriptExecutor jse = (JavascriptExecutor) driver.getWebDriver() ;

        try {
            String script = "var xmlhttp=new XMLHttpRequest();\n" +
                    "xmlhttp.open(\"GET\",\"https://www.baidu.com\",false);\n" +
                    "xmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n" +  // 表单提交的头部信息
                    "xmlhttp.setRequestHeader(\"testHeader\",\"123456\");\n" +  // 自定义请求头
                    "xmlhttp.send(\"name=test&sex=1&age=18\");\n" +   // 表单数据
                    "return xmlhttp.responseText;";
            String t= "document.URL";
            String resp = (String) jse.executeScript("var xmlhttp=new XMLHttpRequest();\n");
            jse.executeScript("xmlhttp.open(\"GET\",\"https://www.baidu.com\",false);\n");
            String re = (String)jse.executeScript("return xmlhttp.responseText;");
            System.out.println(re);
            System.out.println("-----" + resp);

        } catch (Exception e) {
            System.out.println("error\n");
            e.printStackTrace();
            //.......... Exception
        }

        Thread.sleep(50000);
    }
}
