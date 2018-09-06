package com.zbwx.autotest.ui.myobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

import com.zbwx.autotest.ui.base.BasePage;

public class LoginSuccessPage extends BasePage{
	
	 @FindElementBy(id = "id/set_headimg")
	 public AndroidElement mMyPageQianDao;

	 
	protected LoginSuccessPage(){
        super();

    }

    public static LoginSuccessPage verify(){
        return  new LoginSuccessPage();
    }
    
}
