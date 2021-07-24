# alipay

[支付宝开放平台](https://open.alipay.com/platform/home.htm)  

支付宝 Java SDK  

[English](./README.md)  

支持功能：
- [x] App支付
- [x] 手机网站支付
- [x] 电脑网站支付
- [x] 交易查询
- [x] 交易关闭
- [x] 交易退款
- [x] 交易退款查询
- [x] 查询账单下载地址
- [x] 交易验签  

# App支付：
* [App支付产品介绍](https://docs.open.alipay.com/204/105051/)    
  APP支付适用于商家在 App 应用中集成支付宝支付功能.  
  商家APP调用支付宝提供的 SDK,SDK 再调用支付宝APP内的支付模块.  
  如果用户已安装支付宝 APP,商家 APP 会跳转到支付宝中完成支付,  
  支付完后跳回到商家APP内,最后展示支付结果.  
  如果用户没有安装支付宝 APP,商家 APP 内会调起支付宝网页支付收银台,  
  用户登录支付宝账户,支付完后展示支付结果.  
  目前支持手机系统有：iOS(苹果)、Android(安卓).  

# 手机网站支付：
* [手机网站支付产品介绍](https://docs.open.alipay.com/203)     
  适用于商家在移动端网页应用中集成支付宝支付功能. 
  商家在网页应用中调用支付宝提供的网页支付接口,接口会调起支付宝客户端内的支付模块,  
  此时会从商家网页应用跳转到支付宝客户端中并开始支付:支付完成后会跳转回商家网页应用内,  
  最后商家展示支付结果.  

# 电脑网站支付： 
* [电脑网站支付产品介绍](https://docs.open.alipay.com/270)    
  通过电脑网站支付功能,用户在商家 PC 网站消费后界面会自动跳转到支付宝 PC 网站收银台完成付款.   
  交易资金直接打入商家支付宝账户,实时到账.  
  用户交易款项即时到账,交易订单三个月内可退款,  
  提供退款、清结算、对账等配套服务.   

# 交易查询：
* [统一收单线下交易查询](https://docs.open.alipay.com/api_1/alipay.trade.query)    
 该接口提供所有支付宝支付订单的查询,商户可以通过该接口主动查询订单状态,完成下一步的业务逻辑.  
 需要调用查询接口的情况： 当商户后台、网络、服务器等出现异常,商户系统最终未接收到支付通知:   
 调用支付接口后,返回系统错误或未知交易状态情况:   
 调用alipay.trade.pay,返回INPROCESS的状态:   
 调用alipay.trade.cancel之前,需确认支付状态:   

# 交易关闭：
* [统一收单交易关闭接口](https://docs.open.alipay.com/api_1/alipay.trade.close)  
  用于交易创建后,用户在一定时间内未进行支付,  
  可调用该接口直接将未付款的交易进行关闭.  

# 交易退款：
* [统一收单交易退款接口](https://docs.open.alipay.com/api_1/alipay.trade.refund)  
  当交易发生之后一段时间内,由于买家或者卖家的原因需要退款时,  
  卖家可以通过退款接口将支付款退还给买家,  
  支付宝将在收到退款请求并且验证成功之后,  
  按照退款规则将支付款按原路退到买家帐号上.   
  交易超过约定时间(签约时设置的可退款时间)的订单无法进行退款   
  支付宝退款支持单笔交易分多次退款,  
  多次退款需要提交原支付订单的商户订单号和设置不同的退款单号.  
  一笔退款失败后重新提交,要采用原来的退款单号.  
  总退款金额不能超过用户实际支付金额  
  
# 交易退款查询：
* [统一收单交易退款查询](https://docs.open.alipay.com/api_1/alipay.trade.fastpay.refund.query)  
  商户可使用该接口查询自已通过alipay.trade.refund或alipay.trade.refund.apply提交的退款请求是否执行成功.   
  该接口的返回码10000,仅代表本次查询操作成功,不代表退款成功.  
  如果该接口返回了查询数据,  
  且refund_status为空或为REFUND_SUCCESS,则代表退款成功,  
  如果没有查询到则代表未退款成功,可以调用退款接口进行重试.  
  重试时请务必保证退款请求号一致.     
  
# 查询账单下载地址：
* [查询对账单下载地址](https://docs.open.alipay.com/api_15/alipay.data.dataservice.bill.downloadurl.query)  
  为方便商户快速查账,支持商户通过本接口获取商户离线账单下载地址  
  
# 交易验签：
* [RSA 和 RSA2 签名算法区别](https://docs.open.alipay.com/291/106115/)  
  新建应用只支持 RSA2 签名方式,目前已使用RSA签名方式的应用仍然可以正常调用接口,
  详情请见[开放平台接口签名方式升级公告.](https://docs.open.alipay.com/10505)   

## Quick Start  

```xml
<!--在pom.xml中添加依赖-->
        <dependency>
            <groupId>com.github.thierrysquirrel</groupId>
            <artifactId>alipay</artifactId>
            <version>1.3.0.5-RELEASE</version>
        </dependency>
```       

# App支付：  

```java
public class AppPay {
  	public String appPay() throws AlipayApiException {
  		return PayRootChainFactory
  				.createdPayChain("appId", "privateKey", "publicKey")
  				.appPay("subject", "outTradeNo", "totalAmount")
  				.builder()
  				.pay("notifyUrl");
  	}
  }
```  

# 手机网站支付：  

```java
public class WapPay {
	public String wapPay() throws AlipayApiException {
		return PayRootChainFactory
				.createdPayChain("appId","privateKey","publicKey")
				.wapPay("subject","outTradeNo","totalAmount")
				.builder()
				.pay("returnUrl","notifyUrl");
	}
}
```  

# 电脑网站支付：  

```java
public class PagePay {
	public String pagePay() throws AlipayApiException {
		return PayRootChainFactory
				.createdPayChain("appId","privateKey","publicKey")
				.pagePay("subject","outTradeNo","totalAmount")
				.builder()
				.pay("returnUrl","notifyUrl");
	}
}
```

# 交易查询：  

```java
public class PayQuery {
	public String payQuery() throws AlipayApiException {
		return PayRootChainFactory
				.createdPayChain("appId","privateKey","publicKey")
				.queryPay("outTradeNo","tradeNo")
				.builder()
				.query();
	}
}
```

# 交易关闭：

```java
public class PayClose {
	public String payClose() throws AlipayApiException {
		return PayRootChainFactory
				.createdPayChain("appId","privateKey","publicKey")
				.closePay("outTradeNo","tradeNo")
				.builder()
				.close();
	}
}
```

# 交易退款：  

```java
public class PayRefund {
	public String payRefund() throws AlipayApiException {
		return PayRootChainFactory
				.createdPayChain("appId","privateKey","publicKey")
				.refundPay("outTradeNo","tradeNo","refundAmount")
				.builder()
				.refund();
	}
}
```

# 交易退款查询：  

```java
public class PayRefundQuery {
	public String payRefundQuery() throws AlipayApiException {
		return PayRootChainFactory
				.createdPayChain("appId","privateKey","publicKey")
				.refundQueryPay("outTradeNo","tradeNo","outRequestNo")
				.builder()
				.refundQuery();
	}
}
```

# 查询账单下载地址：  

```java
public class PayDownloadQuery {
	public String payDownloadQuery() throws AlipayApiException {
		return PayRootChainFactory
				.createdPayChain("appId","privateKey","publicKey")
				.downloadQueryPay("billType","billDate")
				.builder()
				.downloadQuery();
	}
}
```

# 交易验签：  

```java
public class PayCheck {
	public boolean payCheck(HttpServletRequest request){
		Map<String, String[]> parameterMap=request.getParameterMap();
		Map<String, String> reload = PayCheckFactory.reload(parameterMap);
		return PayCheckFactory.check(reload);
	}
}
```

