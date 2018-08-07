#### 项目简介：
此项目为智宝无限内部开发的ui界面自动化框架，旨在解决andorid、ios、web ui层的频繁测试问题，底层使用uiautomator框架。 
#### 主要功能：
#### 1、通过配置testng.xml执行testng测试
#### 2、TesBaseCase为测试基类，负责测试内容初始化及完成后的收尾工作
#### 3、测试完成后 html自动生成
#### 4、配置邮件发送相关内容
#### 5、PageObject模型，完善测试用例执行
#### 6、ios测试后期增加
#### 7、web测试后期增加
#### 8、基于appium的自动化测试后期增加 动态配置driver
#### 9、测试完成后html报告实时查看后期增加，上传管理平台后期增加
#### 10、持续集成后续增加


#### 优势：
#### 1、无需手机设备连接电脑，所有操作通过网络连接实现，解决pc连接手机的不稳定性
#### 2、服务器管理手机设备，手机注册到服务器中，通过socket长连接进行通过。
#### 3、ui自动化从服务器中挑选当前在线可用的设备，进行自动化测试。 （后续增加）
#### 4、testng参数化配置测试用例

#### 元素查找
#### 1、新增使用@FindElementBy注解方式查找
#### 2、根据id查找时可省略package 包名，如@FindElementBy(id="com.ylmall.app.ui:id/tv_allproduct") 可使用@FindElementBy(id="id/tv_allproduct")替换
#### 3、目前支持id、className、text、contentDesc查找方式
#### 4、如匹配到多个元素，则默认返回第一个元素

