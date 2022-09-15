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
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.domain.ExtUserInfo;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.domain.GoodsDetail;
import com.github.thierrysquirrel.alipay.pay.AppPayChain;
import lombok.Data;

import java.util.List;

/**
 * ClassName: AppPayParamChain
 * Description: <a href="https://opendocs.alipay.com/open/cd12c885_alipay.trade.app.pay?scene=20&pathHash=ab686e33">Document Address</a>
 * 文档地址:<a href="https://opendocs.alipay.com/open/cd12c885_alipay.trade.app.pay?scene=20&pathHash=ab686e33">文档地址</a>
 * <p>
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class AppPayParamChain {
    private AlipayClient alipayClient;
    private AlipayTradeAppPayModel alipayTradeAppPayModel;

    public AppPayParamChain(AlipayClient alipayClient, AlipayTradeAppPayModel alipayTradeAppPayModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeAppPayModel = alipayTradeAppPayModel;
    }

    /**
     * Builder AppPayChain
     * <p>
     * 构建 AppPayChain
     *
     * @return AppPayChain
     */
    public AppPayChain builder() {
        return new AppPayChain(alipayClient, alipayTradeAppPayModel);
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
    public AppPayParamChain builderOutTradeNo(String outTradeNo) {
        alipayTradeAppPayModel.setOutTradeNo(outTradeNo);
        return this;
    }

    /**
     * Mandatory
     * The total amount of the order is in yuan, accurate to two decimal places, with a value range of [0.01100000000], and the amount cannot be 0
     * <p>
     * 必选
     * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]，金额不能为0
     *
     * @param totalAmount totalAmount
     * @return AppPayParamChain
     */
    public AppPayParamChain builderTotalAmount(String totalAmount) {
        alipayTradeAppPayModel.setTotalAmount(totalAmount);
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
    public AppPayParamChain builderSubject(String subject) {
        alipayTradeAppPayModel.setSubject(subject);
        return this;
    }

    /**
     * Sales product code, the product code signed by the merchant and Alipay QUICK_MSECURITY_PAY
     * <p>
     * 销售产品码，商家和支付宝签约的产品码 QUICK_MSECURITY_PAY
     *
     * @param productCode productCode
     * @return AppPayParamChain
     */
    public AppPayParamChain builderProductCode(String productCode) {
        alipayTradeAppPayModel.setProductCode(productCode);
        return this;
    }

    /**
     * The product list information included in the order is in JSON format. For other details, please refer to the product details GoodsDetail[]
     * <p>
     * 订单包含的商品列表信息，json格式，其它说明详见商品明细说明 GoodsDetail[]
     *
     * @param goodsDetail goodsDetail
     * @return AppPayParamChain
     */
    public AppPayParamChain builderGoodsDetail(List<GoodsDetail> goodsDetail) {
        alipayTradeAppPayModel.setGoodsDetail(goodsDetail);
        return this;
    }

    /**
     * Absolute timeout, format yyyy MM dd HH: mm: ss
     * <p>
     * 绝对超时时间，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param timeoutExpress timeoutExpress
     * @return AppPayParamChain
     */
    public AppPayParamChain builderTimeoutExpress(String timeoutExpress) {
        alipayTradeAppPayModel.setTimeExpire(timeoutExpress);
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
    public AppPayParamChain builderExtendParams(ExtendParams extendParams) {
        alipayTradeAppPayModel.setExtendParams(extendParams);
        return this;
    }

    /**
     * Common return parameters, if passed during the request, will be returned to the merchant. Alipay will only return this parameter as is when returning synchronously (including jumping back to the merchant website) and asynchronously notifying. This parameter can be sent to Alipay only after UrlEncoding.
     * <p>
     * 公用回传参数，如果请求时传递了该参数，则返回给商户时会回传该参数。支付宝只会在同步返回（包括跳转回商户网站）和异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝。
     *
     * @param passBackParams passBackParams
     * @return AppPayParamChain
     */
    public AppPayParamChain builderPassBackParams(String passBackParams) {
        alipayTradeAppPayModel.setPassbackParams(passBackParams);
        return this;
    }

    /**
     * Merchant's original order number, maximum length limit of 32 digits
     * <p>
     * 商户原始订单号，最大长度限制32位
     *
     * @param merchantOrderNo merchantOrderNo
     * @return AppPayParamChain
     */
    public AppPayParamChain builderMerchantOrderNo(String merchantOrderNo) {
        alipayTradeAppPayModel.setMerchantOrderNo(merchantOrderNo);
        return this;
    }

    /**
     * External designated buyer
     * <p>
     * 外部指定买家
     *
     * @param extUserInfo extUserInfo
     * @return AppPayParamChain
     */
    public AppPayParamChain builderExtUserInfo(ExtUserInfo extUserInfo) {
        alipayTradeAppPayModel.setExtUserInfo(extUserInfo);
        return this;
    }

    /**
     * Return parameter options. Merchants customize the information fields and array format that need to be returned for synchronization by passing this parameter.
     * <p>
     * 返回参数选项。 商户通过传递该参数来定制同步需要额外返回的信息字段，数组格式。
     *
     * @param queryOptions queryOptions
     * @return AppPayParamChain
     */
    public AppPayParamChain builderQueryOptions(List<String> queryOptions) {
        alipayTradeAppPayModel.setQueryOptions(queryOptions);
        return this;
    }


}
