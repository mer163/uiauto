package com.zbwx.autotest.ui.base;

import atx.client.AtxClient;
import atx.client.remote.PageFactory;

import com.zbwx.autotest.ui.utils.Log;

public class BasePage {

    public Log log = new Log(BasePage.class);
    protected static AtxClient driver;

    public BasePage(){
        log.info("Page初始化页面:" + this.getClass().getName());
        PageFactory.initElements(this,driver);
    }



    public static AtxClient getDriver() {
        return driver;
    }

    public static void setDriver(AtxClient atxClient) {
        driver = atxClient;
    }

}
