/**
 * Copyright 2024/8/6 ThierrySquirrel
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.github.thierrysquirrel.alipay.pay.param;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.github.thierrysquirrel.alipay.pay.WapPayChain;
import lombok.Data;

import java.util.List;

/**
 * ClassName: WapPayParamChain
 * Description: <a href="https://opendocs.alipay.com/open/29ae8cb6_alipay.trade.wap.pay?scene=21&pathHash=1ef587fd">Document Address</a>
 * 文档地址: <a href="https://opendocs.alipay.com/open/29ae8cb6_alipay.trade.wap.pay?scene=21&pathHash=1ef587fd">文档地址</a>
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class WapPayParamChain {
    private AlipayClient alipayClient;
    private AlipayTradeWapPayModel alipayTradeWapPayModel;

    public WapPayParamChain(AlipayClient alipayClient, AlipayTradeWapPayModel alipayTradeWapPayModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeWapPayModel = alipayTradeWapPayModel;
    }

    /**
     * Builder WapPayChain
     * <p>
     * 构建 WapPayChain
     *
     * @return WapPayChain
     */
    public WapPayChain builder() {
        return new WapPayChain(alipayClient, alipayTradeWapPayModel);
    }

    /**
     * Mandatory
     * Unique order number on merchant website
     * <p>
     * 必选
     * 商户网站唯一订单号
     *
     * @param outTradeNo outTradeNo
     * @return AppPayParamChain
     */
    public WapPayParamChain builderOutTradeNo(String outTradeNo) {
        alipayTradeWapPayModel.setOutTradeNo(outTradeNo);
        return this;
    }

    /**
     * Mandatory
     * The total amount of the order.
     * The unit is yuan, accurate to two decimal places, with a value range of [0.01100000000].
     * <p>
     * 必选
     * 订单总金额。
     * 单位为元，精确到小数点后两位，取值范围：[0.01,100000000] 。
     *
     * @param totalAmount totalAmount
     * @return AppPayParamChain
     */
    public WapPayParamChain builderTotalAmount(String totalAmount) {
        alipayTradeWapPayModel.setTotalAmount(totalAmount);
        return this;
    }

    /**
     * Mandatory
     * Order Title
     * <p>
     * 必选
     * 订单标题
     *
     * @param subject subject
     * @return AppPayParamChain
     */
    public WapPayParamChain builderSubject(String subject) {
        alipayTradeWapPayModel.setSubject(subject);
        return this;
    }

    /**
     * Mandatory
     * The sales product code of the order title, and the product code signed by the merchant and Alipay. Mobile website payment is: QUICK-WAP-WAY
     * <p>
     * 必选
     * 销售产品码，商家和支付宝签约的产品码。手机网站支付为：QUICK_WAP_WAY
     *
     * @param productCode productCode
     * @return WapPayParamChain
     */
    public WapPayParamChain builderProductCode(String productCode) {
        alipayTradeWapPayModel.setProductCode(productCode);
        return this;
    }

    /**
     * For the user authorization interface, it is used to identify the user authorization relationship when obtaining user related data
     * <p>
     * 针对用户授权接口，获取用户相关数据时，用于标识用户授权关系
     *
     * @param authToken authToken
     * @return WapPayParamChain
     */
    public WapPayParamChain builderAuthToken(String authToken) {
        alipayTradeWapPayModel.setAuthToken(authToken);
        return this;
    }

    /**
     * User exits midway through payment and returns to the merchant's website address
     * <p>
     * 用户付款中途退出返回商户网站的地址
     *
     * @param quitUrl quitUrl
     * @return WapPayParamChain
     */
    public WapPayParamChain builderQuitUrl(String quitUrl) {
        alipayTradeWapPayModel.setQuitUrl(quitUrl);
        return this;
    }

    /**
     * The product list information included in the order is in JSON format. For other details, please refer to the product details
     * <p>
     * 订单包含的商品列表信息，json格式，其它说明详见商品明细说明
     *
     * @param goodsDetail goodsDetail
     * @return AppPayParamChain
     */
    public WapPayParamChain builderGoodsType(List<GoodsDetail> goodsDetail) {
        alipayTradeWapPayModel.setGoodsDetail(goodsDetail);
        return this;
    }

    /**
     * Absolute timeout, in the format yyyy MM dd HH: mm: ss. Time limit range: 1m~15d
     * <p>
     * 绝对超时时间，格式为yyyy-MM-dd HH:mm:ss。超时时间范围：1m~15d
     *
     * @param timeExpire timeExpire
     * @return WapPayParamChain
     */
    public WapPayParamChain builderTimeExpire(String timeExpire) {
        alipayTradeWapPayModel.setTimeExpire(timeExpire);
        return this;
    }

    /**
     * Business Expansion Parameters
     * <p>
     * 业务扩展参数
     *
     * @param extendParams extendParams
     * @return AppPayParamChain
     */
    public WapPayParamChain builderExtendParams(ExtendParams extendParams) {
        alipayTradeWapPayModel.setExtendParams(extendParams);
        return this;
    }

    /**
     * The specific value of the business information transferred by the merchant should be agreed with Alipay. It should be used in the scenario of direct transmission of parameters such as security and marketing, and the format should be json
     * <p>
     * 商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式
     *
     * @param businessParams businessParams
     * @return WapPayParamChain
     */
    public WapPayParamChain builderBusinessParams(String businessParams) {
        alipayTradeWapPayModel.setBusinessParams(businessParams);
        return this;
    }

    /**
     * Common return parameters, if passed during the request, will be returned to the merchant. Alipay will only return this parameter as is when returning synchronously (including jumping back to the merchant website) and asynchronously notifying. This parameter can be sent to Alipay only after UrlEncoding
     * <p>
     * 公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在同步返回（包括跳转回商户网站）和异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝
     *
     * @param passBackParams passBackParams
     * @return AppPayParamChain
     */
    public WapPayParamChain builderPassBackParams(String passBackParams) {
        alipayTradeWapPayModel.setPassbackParams(passBackParams);
        return this;
    }

    /**
     * Merchant's original order number, maximum length limit of 32 digits
     * <p>
     * 商户原始订单号，最大长度限制32位
     *
     * @param merchantOrderNo merchantOrderNo
     * @return WapPay ParamChain
     */
    public WapPayParamChain builderMerchantOrderNo(String merchantOrderNo) {
        alipayTradeWapPayModel.setMerchantOrderNo(merchantOrderNo);
        return this;
    }

    /**
     * External designated buyer
     * 外部指定买家
     *
     * @param extUserInfo extUserInfo
     * @return AppPayParamChain
     */
    public WapPayParamChain builderExtUserInfo(ExtUserInfo extUserInfo) {
        alipayTradeWapPayModel.setExtUserInfo(extUserInfo);
        return this;
    }
}
