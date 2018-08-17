package com.zbwx.autotest.ui.pageobject;


import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

public class FindPage extends BasePage{

	
	//发现页面圈子
	@FindElementBy(text="圈子")
	public AndroidElement mChiCangQuanZi; 
	//发现页面资讯
	@FindElementBy(text="资讯")
	public AndroidElement mChiCangZiXun; 
	//发现页面话题
	@FindElementBy(id = "id/newcfd_huatilist")
	public AndroidElement mHuaTiList; 
	//发现页面话题图片
	@FindElementBy(id = "id/huatigoods_img")
	public AndroidElement mHuaTiImg; 
	//发现页面热门
	@FindElementBy(id = "id/newcfd_tzjl_butten1")
	public AndroidElement mFindReMen; 
	//发现页面关注
	@FindElementBy(id = "id/newcfd_tzjl_butten2")
	public AndroidElement mFindGuanZhu; 
	//发现页面全部
	@FindElementBy(id = "id/newcfd_tzjl_butten3")
	public AndroidElement mFindAll;
	//发现页面点赞
	@FindElementBy(id = "id/dianzhan")
	public AndroidElement mFindDianZan; 
	//发现页面评论
	@FindElementBy(id = "id/pinglun")
	public AndroidElement mFindPingLun; 
	
	//点击发现页面发言图标
	@FindElementBy(id = "id/frag_tzq_jiaoliu_send_topic")
	public AndroidElement mFindSendTopic; 
	
	protected FindPage() {
		super();

	}

	public static FindPage verify() {
		return new FindPage();
	}
	
	//切换购买指南，商城情报，公告页面
	public void mClick() throws Exception{
		ZiXunPage.verify().ll_homeStoreInfo.click();
		Thread.sleep(2000);
		ZiXunPage.verify().ll_homeGongGao.click();
		Thread.sleep(2000);
		ZiXunPage.verify().ll_homeBuyZhiNan.click();
		Thread.sleep(2000);
	}
	
	public void mClickFind() throws Exception{	
		//点击关注和全部进行切换页面
		this.mFindGuanZhu.click();
		
		this.mFindAll.click();
		
		this.mFindReMen.click();
		//循环点击点赞按钮是否可以点赞和取消点赞
		for (int i = 0; i < 3; i++) {
			this.mFindDianZan.click();
		}
		//点击评论按钮跳转到发言详情页面
		this.mFindPingLun.click();
		Thread.sleep(2000);
		//点击发言详情页面的返回按钮返回圈子页面
		BaseAction.mReturn();
		Thread.sleep(2000);
		//点击发现页面发言图标进入发言页面进行发布话题
		this.mFindSendTopic.click();
		//点击发言页面的返回按钮返回圈子页面
		BaseAction.mReturn();
}
}
