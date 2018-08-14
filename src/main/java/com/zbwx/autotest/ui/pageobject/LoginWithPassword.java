package com.zbwx.autotest.ui.pageobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;
import com.sun.xml.internal.rngom.parse.host.Base;
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



    public void login(){
        this.username.click();
        BaseAction.device.sendText("15010279363");
        this.password.click();
        BaseAction.device.sendText("111111");
        this.loginBtn.click();
    }
}
