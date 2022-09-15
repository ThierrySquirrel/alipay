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

package com.github.thierrysquirrel.alipay.pay.refund.query.param;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.github.thierrysquirrel.alipay.pay.refund.query.PayRefundQueryChain;
import lombok.Data;

import java.util.List;

/**
 * ClassName: PayRefundQueryParamChain
 * Description: Document Address <a href="https://opendocs.alipay.com/open/8c776df6_alipay.trade.fastpay.refund.query?scene=common&pathHash=fb6e1894">Document Address</a>
 * 文档地址 <a href="https://opendocs.alipay.com/open/8c776df6_alipay.trade.fastpay.refund.query?scene=common&pathHash=fb6e1894">文档地址</a>
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayRefundQueryParamChain {
    private AlipayClient alipayClient;
    private AlipayTradeFastpayRefundQueryModel alipayTradeFastpayRefundQueryModel;

    public PayRefundQueryParamChain(AlipayClient alipayClient, AlipayTradeFastpayRefundQueryModel alipayTradeFastpayRefundQueryModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeFastpayRefundQueryModel = alipayTradeFastpayRefundQueryModel;
    }

    /**
     * Builder PayRefundChain
     * <p>
     * 构建 PayRefundChain
     *
     * @return PayRefundQueryChain
     */
    public PayRefundQueryChain builder() {
        return new PayRefundQueryChain(alipayClient, alipayTradeFastpayRefundQueryModel);
    }

    /**
     * Mandatory
     * Refund Request Number
     * <p>
     * 必选
     * 退款请求号
     *
     * @param outRequestNo outRequestNo
     * @return PayRefundQueryParamChain
     */
    public PayRefundQueryParamChain builderOutRequestNo(String outRequestNo) {
        alipayTradeFastpayRefundQueryModel.setOutRequestNo(outRequestNo);
        return this;
    }

    /**
     * Mandatory
     * Alipay transaction number
     * <p>
     * 必选
     * 支付宝交易号
     *
     * @param tradeNo tradeNo
     * @return PayRefundQueryParamChain
     */
    public PayRefundQueryParamChain builderTradeNo(String tradeNo) {
        alipayTradeFastpayRefundQueryModel.setTradeNo(tradeNo);
        return this;
    }

    /**
     * Mandatory
     * Merchant order number
     * <p>
     * !!这是不可缺参数
     * 商户订单号
     * OutTradeNo,OutRequestNo如果同时存在优先取OutTradeNo
     *
     * @param outTradeNo outTradeNo
     * @return PayRefundQueryParamChain
     */
    public PayRefundQueryParamChain builderOutTradeNo(String outTradeNo) {
        alipayTradeFastpayRefundQueryModel.setOutTradeNo(outTradeNo);
        return this;
    }

    /**
     * Query options, merchants can customize the additional information fields that need to be returned for synchronization by uploading this parameter, in array format
     * <p>
     * 查询选项，商户通过上送该参数来定制同步需要额外返回的信息字段，数组格式
     *
     * @param queryOptions queryOptions
     * @return PayRefundQueryParamChain
     */
    public PayRefundQueryParamChain builder(List<String> queryOptions) {
        alipayTradeFastpayRefundQueryModel.setQueryOptions(queryOptions);
        return this;
    }
}
