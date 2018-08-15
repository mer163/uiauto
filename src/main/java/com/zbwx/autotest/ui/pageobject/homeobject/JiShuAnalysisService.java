package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;


import com.zbwx.autotest.ui.base.BasePage;



public class JiShuAnalysisService  extends BasePage{


	// 技术分析
	@FindElementBy(id= "id/helpguide_rel_jishu_1")
	public AndroidElement mHelpGuideJiShu_1;
	@FindElementBy(id= "id/helpguide_rel_jishu_2")	
	public AndroidElement mHelpGuideJiShu_2;
	@FindElementBy(id= "id/helpguide_rel_jishu_3")	
	public AndroidElement mHelpGuideJiShu_3;
	
	protected JiShuAnalysisService(){
		super();

	}

	public static JiShuAnalysisService verify(){
		return  new JiShuAnalysisService();
	}
	
	public void mClick() throws Exception{

		this.mHelpGuideJiShu_1.click();
		HomePageService.verify().mBtnBackService.click();
		Thread.sleep(2000);
	

		this.mHelpGuideJiShu_2.click();
		HomePageService.verify().mBtnBackService.click();
		Thread.sleep(2000);
	
		this.mHelpGuideJiShu_3.click();
		HomePageService.verify().mBtnBackService.click();
	}
}
