package com.zbwx.autotest.ui.pageobject.homeobject;


import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;


import com.zbwx.autotest.ui.base.BasePage;

/**
 * 首页搜索
 * @author zbwx
 *
 */
public class HomePageSearch extends BasePage{

	@FindElementBy(id= "id/et_search")		
	public AndroidElement et_search;
		
	@FindElementBy(id= "id/img_right")		
	public AndroidElement img_right;	
	
	@FindElementBy(id= "id/img_left")		
	public AndroidElement img_left;
	
	
	
	protected HomePageSearch(){
		super();

	}

	public static HomePageSearch verify(){
		return  new HomePageSearch();
	}
	//点击返回
	public void clickImgLeftBtn() {
		this.img_left.click();
	}
	//点击搜索按钮
	public void clickImgRight() {
		this.img_right.click();
	}
}
