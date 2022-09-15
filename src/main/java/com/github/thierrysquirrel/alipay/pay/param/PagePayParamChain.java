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
import com.alipay.api.domain.*;
import com.github.thierrysquirrel.alipay.pay.PagePayChain;
import lombok.Data;

import java.util.List;

/**
 * ClassName: PagePayParamChain
 * Description: <a href="https://opendocs.alipay.com/open/59da99d0_alipay.trade.page.pay?scene=22&pathHash=e26b497f">Document Address </a>
 * 文档地址 <a href="https://opendocs.alipay.com/open/59da99d0_alipay.trade.page.pay?scene=22&pathHash=e26b497f">文档地址</a>
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PagePayParamChain {
    private AlipayClient alipayClient;
    private AlipayTradePagePayModel alipayTradePagePayModel;

    public PagePayParamChain(AlipayClient alipayClient, AlipayTradePagePayModel alipayTradePagePayModel) {
        this.alipayClient = alipayClient;
        this.alipayTradePagePayModel = alipayTradePagePayModel;
    }

    /**
     * Builder PagePayChain
     * <p>
     * 构建 PagePayChain
     *
     * @return PagePayChain
     */
    public PagePayChain builder() {
        return new PagePayChain(alipayClient, alipayTradePagePayModel);
    }

    /**
     * Mandatory
     * Customized by merchants, within 64 characters, only supports letters, numbers, underscores, and must ensure that they are not duplicated on the merchant side
     * <p>
     * 必选
     * 由商家自定义，64个字符以内，仅支持字母、数字、下划线且需保证在商户端不重复
     *
     * @param outTradeNo outTradeNo
     * @return PagePayParam
     */
    public PagePayParamChain builderOutTradeNo(String outTradeNo) {
        alipayTradePagePayModel.setOutTradeNo(outTradeNo);
        return this;
    }

    /**
     * Mandatory
     * The total amount of the order is in yuan, accurate to two decimal places, with a value range of [0.01100000000]. The amount cannot be 0
     * <p>
     * 必选
     * 订单总金额，单位为元，精确到小数点后两位，取值范围为 [0.01,100000000]。金额不能为0
     *
     * @param totalAmount totalAmount
     * @return PagePayParamChain
     */
    public PagePayParamChain builderTotalAmount(String totalAmount) {
        alipayTradePagePayModel.setTotalAmount(totalAmount);
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
     * @return PagePayParamChain
     */
    public PagePayParamChain builderSubject(String subject) {
        alipayTradePagePayModel.setSubject(subject);
        return this;
    }

    /**
     * Mandatory
     * Sales product code, the name of the product code signed with Alipay. FAST_INSTANT_TRADE_PAY
     * <p>
     * 必选
     * 销售产品码，与支付宝签约的产品码名称 FAST_INSTANT_TRADE_PAY
     *
     * @param productCode productCode
     * @return PagePayParamChain
     */
    public PagePayParamChain builderProductCode(String productCode) {
        alipayTradePagePayModel.setProductCode(productCode);
        return this;
    }

    /**
     * PC scanning payment method
     * <p>
     * PC扫码支付的方式
     *
     * @param qrPayMode qrPayMode
     * @return PagePayParamChain
     */
    public PagePayParamChain builderQrPayMode(String qrPayMode) {
        alipayTradePagePayModel.setQrPayMode(qrPayMode);
        return this;
    }

    /**
     * Merchant customized QR code width
     * <p>
     * 商户自定义二维码宽度
     *
     * @param qrCodeWidth qrCodeWidth
     * @return PagePayParamChain
     */
    public PagePayParamChain builderQrCodeWidth(Long qrCodeWidth) {
        alipayTradePagePayModel.setQrcodeWidth(qrCodeWidth);
        return this;
    }

    /**
     * List of products included in the order, in JSON format
     * <p>
     * 订单包含的商品列表信息，json格式
     *
     * @param goodsDetail goodsDetail
     * @return PagePayParamChain
     */
    public PagePayParamChain builderGoodsDetail(List<GoodsDetail> goodsDetail) {
        alipayTradePagePayModel.setGoodsDetail(goodsDetail);
        return this;
    }

    /**
     * The absolute timeout period for the order.
     * The format is yyyy MM dd HH: mm: ss
     * <p>
     * 订单绝对超时时间。
     * 格式为yyyy-MM-dd HH:mm:ss
     *
     * @param timeExpire timeExpire
     * @return PagePayParamChain
     */
    public PagePayParamChain builderTimeExpire(String timeExpire) {
        alipayTradePagePayModel.setTimeExpire(timeExpire);
        return this;
    }

    /**
     * Secondary Merchant Information
     * <p>
     * 二级商户信息
     *
     * @param subMerchant subMerchant
     * @return PagePayParamChain
     */
    public PagePayParamChain builderSubMerchant(SubMerchant subMerchant) {
        alipayTradePagePayModel.setSubMerchant(subMerchant);
        return this;
    }

    /**
     * Business Expansion Parameters
     * <p>
     * 业务扩展参数
     *
     * @param extendParams extendParams
     * @return PagePayParamChain
     */
    public PagePayParamChain builderExtendParams(ExtendParams extendParams) {
        alipayTradePagePayModel.setExtendParams(extendParams);
        return this;
    }

    /**
     * The specific value of the business information transferred by the merchant should be agreed with Alipay. It should be used in the scenario of direct transmission of parameters such as security and marketing, and the format should be json
     * <p>
     * 商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式
     *
     * @param businessParams businessParams
     * @return PagePayParamChain
     */
    public PagePayParamChain builderBusinessParams(String businessParams) {
        alipayTradePagePayModel.setBusinessParams(businessParams);
        return this;
    }

    /**
     * Discount parameters
     * <p>
     * 优惠参数
     *
     * @param promoParams promoParams
     * @return AppPayParamChain
     */
    public PagePayParamChain builderPromoParams(String promoParams) {
        alipayTradePagePayModel.setPromoParams(promoParams);
        return this;
    }

    /**
     * Integration method of page after request
     * <p>
     * 请求后页面的集成方式
     *
     * @param integrationType integrationType
     * @return PagePayParamChain
     */
    public PagePayParamChain builderIntegrationType(String integrationType) {
        alipayTradePagePayModel.setIntegrationType(integrationType);
        return this;
    }

    /**
     * Request source address. If the integration method of ALIAPP is used, if the user cancels the payment midway, the address will be returned
     * <p>
     * 请求来源地址。如果使用ALIAPP的集成方式，用户中途取消支付会返回该地址
     *
     * @param requestFromUrl requestFromUrl
     * @return PagePayParamChain
     */
    public PagePayParamChain builderRequestFromUrl(String requestFromUrl) {
        alipayTradePagePayModel.setRequestFromUrl(requestFromUrl);
        return this;
    }

    /**
     * Merchant Store Number
     * <p>
     * 商户门店编号
     *
     * @param storeId storeId
     * @return PagePayParamChain
     */
    public PagePayParamChain builderStoredId(String storeId) {
        alipayTradePagePayModel.setStoreId(storeId);
        return this;
    }

    /**
     * Merchant's original order number, maximum length limit of 32 digits
     * <p>
     * 商户原始订单号，最大长度限制 32 位
     *
     * @param merchantOrderNo merchantOrderNo
     * @return PagePayParamChain
     */
    public PagePayParamChain builderMerchantOrderNo(String merchantOrderNo) {
        alipayTradePagePayModel.setMerchantOrderNo(merchantOrderNo);
        return this;
    }

    /**
     * External designated buyer
     * <p>
     * 外部指定买家
     *
     * @param extUserInfo extUserInfo
     * @return PagePayParamChain
     */
    public PagePayParamChain builderExtUserInfo(ExtUserInfo extUserInfo) {
        alipayTradePagePayModel.setExtUserInfo(extUserInfo);
        return this;
    }

    /**
     * Invoice information
     * <p>
     * 开票信息
     *
     * @param invoiceInfo invoiceInfo
     * @return PagePayParamChain
     */
    public PagePayParamChain builderInvoiceInfo(InvoiceInfo invoiceInfo) {
        alipayTradePagePayModel.setInvoiceInfo(invoiceInfo);
        return this;
    }

}
