package com.zbwx.autotest.ui.myobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;

public class LoginWithPassword extends BasePage{


    @FindElementBy(id = "id/login_new_tel")
    public AndroidElement username;

    @FindElementBy(id = "id/login_new_pwd")
    public AndroidElement password;

    @FindElementBy(id = "id/login_new_btn")
    public AndroidElement loginBtn;

    protected LoginWithPassword(){
        super();

    }

    public static LoginWithPassword verify(){
        return  new LoginWithPassword();
    }


    //登录失败
    public void loginFailed(){
        this.username.click();
        BaseAction.device.sendText("15210034889");
        this.password.click();
        BaseAction.device.sendText("123456");
        this.loginBtn.click();        
    }
   //登录成功
    public void loginSuccess() throws Exception{
        this.username.click();
        BaseAction.device.clearText("15210034889");
        Thread.sleep(2000);
        BaseAction.device.sendText("15210034889");
        this.password.click();
        BaseAction.device.clearText("123456");
        Thread.sleep(2000);
        BaseAction.device.sendText("654321");
        Thread.sleep(2000);
        this.loginBtn.click();        
    }
}
