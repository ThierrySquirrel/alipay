/**
 * Copyright 2019 the original author or authors.
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
 */

package com.github.thierrysquirrel.alipay.pay.query.param;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.github.thierrysquirrel.alipay.pay.query.PayQueryChain;
import lombok.Data;

import java.util.List;

/**
 * ClassName: PayQueryParamChain
 * Description: Document Address <a href="https://opendocs.alipay.com/open/4e2d51d1_alipay.trade.query?scene=common&pathHash=8abc6ffe">Document Address</a>
 * 文档地址 <a href="https://opendocs.alipay.com/open/4e2d51d1_alipay.trade.query?scene=common&pathHash=8abc6ffe">文档地址</a>
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayQueryParamChain {
    private AlipayClient alipayClient;
    private AlipayTradeQueryModel alipayTradeQueryModel;

    public PayQueryParamChain(AlipayClient alipayClient, AlipayTradeQueryModel alipayTradeQueryModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeQueryModel = alipayTradeQueryModel;
    }

    /**
     * Builder PayQueryChain
     * <p>
     * 构建 PayQueryChain
     *
     * @return PayQueryChain
     */
    public PayQueryChain builder() {
        return new PayQueryChain(alipayClient, alipayTradeQueryModel);
    }

    /**
     * Mandatory
     * The order number of the merchant passed in during order payment and the Alipay transaction number cannot be blank at the same time
     * <p>
     * 必选
     * 订单支付时传入的商户订单号,和支付宝交易号不能同时为空
     * TradeNo,OutTradeNo如果同时存在优先取TradeNo
     *
     * @param outTradeNo outTradeNo
     * @return PayQueryParamChain
     */
    public PayQueryParamChain builderOutTradeNo(String outTradeNo) {
        alipayTradeQueryModel.setOutTradeNo(outTradeNo);
        return this;
    }

    /**
     * Mandatory
     * Alipay transaction number and merchant order number cannot be empty at the same time
     * <p>
     * 必选
     * 支付宝交易号，和商户订单号不能同时为空
     *
     * @param tradeNo tradeNo
     * @return PayQueryParamChain
     */
    public PayQueryParamChain builderTradeNo(String tradeNo) {
        alipayTradeQueryModel.setTradeNo(tradeNo);
        return this;
    }

    /**
     * Useful in interbank mode, please do not use in other scenarios; Shuanglian specifies the PID of the acquiring institution of the exchange to be queried through this parameter
     * <p>
     * 银行间联模式下有用，其它场景请不要使用； 双联通过该参数指定需要查询的交易所属收单机构的pid
     *
     * @param orgPid orgPid
     * @return PayQueryParamChain
     */
    public PayQueryParamChain builderOrgPid(String orgPid) {
        alipayTradeQueryModel.setOrgPid(orgPid);
        return this;
    }

    /**
     * Query options, merchants can customize this interface by passing in this parameter to synchronize the response with additional information fields returned in array format
     * <p>
     * 查询选项，商户传入该参数可定制本接口同步响应额外返回的信息字段，数组格式
     *
     * @param queryOptions queryOptions
     * @return PayQueryParamChain
     */
    public PayQueryParamChain builderQueryOptions(List<String> queryOptions) {
        alipayTradeQueryModel.setQueryOptions(queryOptions);
        return this;
    }

}
