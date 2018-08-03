package com.zbwx.autotest.ui.pageobject;

import java.util.ArrayList;

import atx.client.adb.ElementAdb;
import atx.client.common.ElementObj;
import atx.client.model.AndroidElement;

import com.zbwx.autotest.ui.base.TestBaseCase;

public class FindPage extends TestBaseCase{
	public AndroidElement mDaoHangFaXian;
	
	public ElementAdb mChiCangQuanZi;
	public ElementAdb mChiCangZiXun;
	
	public ElementAdb mHuaTiList;
	public ElementAdb mHuaTiImg;
	public ElementAdb mHuaTitx_back;
	
	public ElementAdb mFindReMen;
	public ElementAdb mFindGuanZhu;
	public ElementAdb mFindKongBai;
	public ElementAdb mFindAll;
	
	public ElementAdb mFindTaoLunTime;
	public ElementAdb mFindDianZan;
	public ElementAdb mFindPingLun;
	
	public ElementAdb mFindFaYan;
	public FindPage(){
		initElements();
	}

	public void initElements() {
		
		try {
			this.mDaoHangFaXian =driver.findElementById(TestBaseCase.mAppMainPackage+":id/daohang_zixun");//导航发现
			
			this.mChiCangQuanZi =position.findElementById(TestBaseCase.mAppMainPackage+":id/chicang_quanzi");//圈子
			this.mChiCangZiXun =position.findElementById(TestBaseCase.mAppMainPackage+":id/chicang_zixun");//资讯
			
			this.mHuaTiList =position.findElementById(TestBaseCase.mAppMainPackage+":id/newcfd_huatilist");//话题
			this.mHuaTiImg =position.findElementById(TestBaseCase.mAppMainPackage+":id/huatigoods_img");//话题
			this.mHuaTitx_back =position.findElementById(TestBaseCase.mAppMainPackage+":id/tx_back");//话题返回
			
			this.mFindReMen =position.findElementById(TestBaseCase.mAppMainPackage+":id/newcfd_tzjl_butten1");//热门
			this.mFindGuanZhu =position.findElementById(TestBaseCase.mAppMainPackage+":id/newcfd_tzjl_butten2");//关注
			this.mFindKongBai =position.findElementById(TestBaseCase.mAppMainPackage+":id/empty_image");//关注空白
			
			this.mFindAll =position.findElementById(TestBaseCase.mAppMainPackage+":id/newcfd_tzjl_butten3");//全部
			
			this.mFindTaoLunTime =position.findElementById(TestBaseCase.mAppMainPackage+":id/sentertime");//热门讨论时间
			this.mFindDianZan =position.findElementById(TestBaseCase.mAppMainPackage+":id/dianzhan");//热门点赞
			this.mFindPingLun =position.findElementById(TestBaseCase.mAppMainPackage+":id/pinglun");//热门评论
			
			this.mFindFaYan =position.findElementById(TestBaseCase.mAppMainPackage+":id/frag_tzq_jiaoliu_send_topic");//发言
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void mClickFindDaoHang() throws Exception{
		mWaitOpenApp();
		mDaoHangFaXian.click();
		
	}
}
