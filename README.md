# Multithreading_UDP_GUI_Chat

### 技术栈：

+ UDP
+ GUI
+ 多线程



## 配置介绍

仅供本地测试，联网测试需要开放端口，有一定风险，请谨慎测试！！！

每个GUI开启了两个线程：一个TalkSend发送消息的线程，一个TalkReceive线程，都是通过实现Runnable接口完成，由于是UDP协议通信，相当于只管发送，并且输入IP地址端口未加任何验证，之后想加再加上，同时还可以拓展更多花式功能。

![image-20210217185337666](https://codefriday.oss-cn-beijing.aliyuncs.com/Github/udpchat.png)

只需要发送到的端口和对方开放的接收端口保持一致即可单向通信，同时满足则可双向通信，即可实现实时聊天！



**by：CodeFriday**

**作者QQ：853851430**

**博客网站：https://www.codefriday.cn**