package com.zbwx.autotest.ui.pageobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;
import com.zbwx.autotest.ui.base.BasePage;

public class LoginWithSmsPage extends BasePage {

    @FindElementBy(id = "id/rightText")
    public AndroidElement passwordLogin;



    protected LoginWithSmsPage(){
        super();

    }

    public static LoginWithSmsPage verify(){
        return  new LoginWithSmsPage();
    }

    public void clickPasswordLogin(){
        this.passwordLogin.click();
    }
}
