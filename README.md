# alipay

[AliPay Open Platform](https://open.alipay.com/platform/home.htm)  

AliPay Java SDK  

[中文](./README_zh_CN.md)  

Support Function：
- [x] App Payment
- [x] Mobile Website Payment
- [x] Payment By Computer Website
- [x] Transaction Query
- [x] Transaction Closed
- [x] Transaction Refund
- [x] Transaction Refund Query
- [x] Query Bill Download Address
- [x] Transaction Verification  

# App Payment：
* [App payment product introduction](https://docs.open.alipay.com/204/105051/)    
  APP Payment Is Suitable For Businesses To Integrate AliPay Payment Function In App Applications.    
  Merchant APP Calls AliPay's SDK, SDK, And Then Calls The Payment Module in AliPay APP.    
  If The User Has Installed AliPay APP,   
  The Merchant APP Will Jump To AliPay To Complete The Payment,     
  After Payment, Jump Back To The Merchant App, And Finally Display The Payment Result.    
  If The User Does Not Install AliPay APP,   
  The Merchant APP Will Adjust The AliPay Web Payment Cashier,    
  Users Log On To AliPay Account And Show The Payment Results After Payment.    
  Currently supported mobile systems are IOS (Apple) and Android (Android).      

# Mobile Website Payment：  
* [Mobile Website Payment Product Introduction](https://docs.open.alipay.com/203)       
  It Is Suitable For Businesses To Integrate AliPay Payment Function In Mobile Web Page Application.     
  In The Web Application,     
  Merchants Call The Web Page Payment Interface Provided By AliPay, And The Interface Will Adjust The Payment Module In AliPay Client,      
  At This Point, It Will Jump From The Merchant Web Application To The AliPay Client And Start Payment: After Payment Is Completed,     
  It Will Jump Back To The Application Of The Merchant Web Page,      
  Finally, The Merchant Shows The Payment Result.      

# Payment By Computer Website： 
* [Introduction To Payment Products Of Computer Website](https://docs.open.alipay.com/270)    
  Through The Payment Function Of The Computer Website,     
  Users Will Automatically Jump To The AliPay PC Website Cashier To Complete Payment After Consuming The PC Website.     
  Trading Funds Directly Into The Merchant AliPay Account, Real-Time Arrival.      
  The User's Transaction Payment Is Received Immediately,     
  And The Transaction Order Can Be Refunded Within Three Months,      
  Provide Refund, Settlement, Reconciliation And Other Supporting Services.       

# Transaction Query：
* [Unified Single Line Transaction Inquiry](https://docs.open.alipay.com/api_1/alipay.trade.query)    
 The Interface Provides All AliPay Payment Orders Inquiries, Merchants Can Actively Query The Order Status Through This Interface,      
 And Complete The Next Business Logic.     
 Need To Call Query Interface: When The Merchant Background, Network,     
 Server And So On Are Abnormal,     
 The Merchant System Does Not Receive The Payment Notice Finally:       
 System Error Or Unknown Transaction Status Returned After Calling The Payment Interface:       
 Call alipay.trade.pay To Return The Status Of INPROCESS:        
 Before Calling alipay.trade.cancel, You Need To Confirm The Payment Status:       

# Transaction Closed：
* [Unified Receipt Transaction Closing Interface](https://docs.open.alipay.com/api_1/alipay.trade.close)  
  After The Transaction Is Created,   
  The User Fails To Pay Within A Certain Period Of Time,    
  This Interface Can Be Called To Close The Unpaid Transactions Directly.    

# Transaction Refund：
* [Unified Receipt Transaction Refund Interface](https://docs.open.alipay.com/api_1/alipay.trade.refund)  
  When A Refund Is Required Due To The Buyer Or The Seller For A Period Of Time After The Transaction,    
  The Seller Can Return The Payment To The Buyer Through The Refund Interface,    
  AliPay Will Receive A Refund Request And Verify The Success,    
  Refund The Payment To The Buyer's Account According To The Refund Rules.     
  No Refund Can Be Made For The Order Whose Transaction Exceeds The Agreed Time (The Refundable Time Set At The Time Of Signing)     
  AliPay Refund Support For Single Transaction With Multiple Refunds,    
  For Multiple Refunds, You Need To Submit The Merchant Order Number Of The Original Payment Order And Set A Different Refund Number.    
  If A Refund Fails To Be Submitted Again,     
  The original Refund Number Shall Be Used.      
  The Total Refund Amount Cannot Exceed The User's Actual Payment Amount     
  
# Transaction Refund Query：
* [Unified Receipt Transaction Refund Query](https://docs.open.alipay.com/api_1/alipay.trade.fastpay.refund.query)  
  The Merchant Can Use This Interface To Query Whether The Refund Request Submitted By Itself Through alipay.trade.refund     
  or alipay.trade.refund.apply Is Executed Successfully.     
  The Return Code 10000 Of This Interface Only Represents The Success Of This Query Operation, Not The Success Of Refund.      
  If The Interface Returns Query Data,    
  If The refund_status Is Empty Or REFUND_SUCCESS, The Refund Is successful,    
  If It Is Not Found, It Means That The Refund Is Successful.     
  You Can Call The Refund Interface To Try Again.      
  Please Make Sure That The Refund Request Number Is The Same When You Try Again.       
  
# Query Bill Download Address：
* [Query The Download Address Of Statement](https://docs.open.alipay.com/api_15/alipay.data.dataservice.bill.downloadurl.query)  
  In Order To Facilitate The Merchant's Quick Account Checking,       
  The Merchant Is Supported To Obtain The Offline Bill Download Address Of The Merchant Through This Interface         
  
# Transaction Verification：
* [Difference Between RSA and RSA2 Signature Algorithms](https://docs.open.alipay.com/291/106115/)  
  The New Application Only Supports The RSA2 Signature Method. Currently,   
  The Application That Has Used The RSA Signature Method Can Still Call The Interface Normally,   
  See For Details.[Open Platform Interface Signature Upgrade Announcement.](https://docs.open.alipay.com/10505)   

## Quick Start  

```xml
<!--Adding dependencies to pom. XML-->
        <dependency>
            <groupId>com.github.thierrysquirrel</groupId>
            <artifactId>alipay</artifactId>
            <version>1.3.1.0-RELEASE</version>
        </dependency>
```       

# App Payment：  

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

# Mobile Website Payment：  

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

# Payment By Computer Website：  

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

# Transaction Query：  

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

# Transaction Closed：

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

# Transaction Refund：  

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

# Transaction Refund Query：  

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

# Query Bill Download Address：  

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

# Transaction Verification：  

```java
public class PayCheck {
	public boolean payCheck(HttpServletRequest request){
		Map<String, String[]> parameterMap=request.getParameterMap();
		Map<String, String> reload = PayCheckFactory.reload(parameterMap);
		return PayCheckFactory.check(reload);
	}
}
```

