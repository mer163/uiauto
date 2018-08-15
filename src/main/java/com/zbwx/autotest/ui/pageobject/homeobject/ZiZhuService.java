package com.zbwx.autotest.ui.pageobject.homeobject;

import atx.client.internal.FindElementBy;
import atx.client.model.AndroidElement;

import com.zbwx.autotest.ui.base.BaseAction;
import com.zbwx.autotest.ui.base.BasePage;


public class ZiZhuService extends BasePage{

	@FindElementBy(id= "id/tx_back")	
	public AndroidElement mTvZiZhuServiceBack;//自助服务返回
	
	
	@FindElementBy(id= "id/kefu_machine_txt")	
	public AndroidElement mChatText;//回复
	
	@FindElementBy(id= "id/chat_client_edittext")	
	public AndroidElement mChatEditText;//自助客服输入框
	
	@FindElementBy(id= "id/chat_client_expression")	
	public AndroidElement mChatExpression;//自助客服表情
	
	@FindElementBy(id= "id/chat_client_camera")	
	public AndroidElement mChatCamera;//自助客服相机
	
	@FindElementBy(id= "id/chat_client_picutre")	
	public AndroidElement mChatPicutre;//自助客服图片
	
	@FindElementBy(id= "id/chat_client_voice")	
	public AndroidElement mChatVoice;//自助客服语音
	
	@FindElementBy(id= "id/chat_client_video")	
	public AndroidElement mChatVidio;//自助客服视频
	
	@FindElementBy(text= "发送")	
	public AndroidElement mChatSend;//自助客服发送
	
	protected ZiZhuService(){
		super();

	}

	public static ZiZhuService verify(){
		return  new ZiZhuService();
	}
	
	//发送内容
	public void mSendContener() throws Exception {
		this.mChatEditText.click();//点击输入框
		BaseAction.device.sendText("bbb");//输入内容
		Thread.sleep(2000);
		this.mChatText.click();//点击客服回复文本收其软键盘
		Thread.sleep(2000);
		this.mChatSend.click();//点击发送
	}
}
