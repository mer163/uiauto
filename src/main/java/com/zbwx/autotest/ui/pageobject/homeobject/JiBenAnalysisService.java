package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;


import com.zbwx.autotest.ui.base.BasePage;

public class JiBenAnalysisService  extends BasePage{
	

	// 基本面分析
	@FindElementBy(id= "id/helpguide_rel_jiben_1")
	public AndroidElement mHelpGuideJiBen_1;
	@FindElementBy(id= "id/helpguide_rel_jiben_2")	
	public AndroidElement mHelpGuideJiBen_2;
	@FindElementBy(id= "id/helpguide_rel_jiben_3")	
	public AndroidElement mHelpGuideJiBen_3;
	@FindElementBy(id= "id/helpguide_rel_jiben_4")	
	public AndroidElement mHelpGuideJiBen_4;
	
	protected JiBenAnalysisService(){
		super();

	}

	public static JiBenAnalysisService verify(){
		return  new JiBenAnalysisService();
	}
	public void mClick() throws Exception{
		this.mHelpGuideJiBen_1.click();
		HomePageService.verify().mBtnBackService.click();
		Thread.sleep(2000);
		
		this.mHelpGuideJiBen_2.click();
		HomePageService.verify().mBtnBackService.click();
		Thread.sleep(2000);
		
		this.mHelpGuideJiBen_3.click();
		HomePageService.verify().mBtnBackService.click();
		Thread.sleep(2000);

		this.mHelpGuideJiBen_4.click();
		HomePageService.verify().mBtnBackService.click();
	}
}
