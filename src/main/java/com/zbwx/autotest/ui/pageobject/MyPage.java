package com.zbwx.autotest.ui.pageobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;
import com.zbwx.autotest.ui.base.BasePage;

public class MyPage extends BasePage {

    @FindElementBy(id = "id/fourth_head_img")
    public AndroidElement headImage;



    protected MyPage(){
        super();

    }

    public static MyPage verify(){
        return  new MyPage();
    }

    public void clickHeadImage(){
        this.headImage.click();
    }


}
