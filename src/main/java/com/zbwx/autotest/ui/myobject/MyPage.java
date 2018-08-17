package com.zbwx.autotest.ui.myobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;
import com.zbwx.autotest.ui.base.BasePage;

public class MyPage extends BasePage {

    @FindElementBy(id = "id/fourth_head_img")
    public AndroidElement headImage;//点击用户头像
    
    @FindElementBy(id = "id/my_fensi_text")
    public AndroidElement mMyPageNoLoginFenSi;//我的页面没有登录粉丝的显示
        
    @FindElementBy(id = "id/set_headimg")
    public AndroidElement mMyPageQianDao;

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
