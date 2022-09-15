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

package com.github.thierrysquirrel.alipay.pay.close.param;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.github.thierrysquirrel.alipay.pay.close.PayCloseChain;
import lombok.Data;

/**
 * ClassName: PayCloseParamChain
 * Description: Document Address <a href="https://opendocs.alipay.com/open/ce0b4954_alipay.trade.close?scene=common&pathHash=7b0fdae1">Document Address</a>
 * 文档地址 <a href="https://opendocs.alipay.com/open/ce0b4954_alipay.trade.close?scene=common&pathHash=7b0fdae1">文档地址</a>
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayCloseParamChain {
    private AlipayClient alipayClient;
    private AlipayTradeCloseModel alipayTradeCloseModel;

    public PayCloseParamChain(AlipayClient alipayClient, AlipayTradeCloseModel alipayTradeCloseModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeCloseModel = alipayTradeCloseModel;
    }

    /**
     * Builder PayCloseChain
     * <p>
     * 构建 PayCloseChain
     *
     * @return PayCloseChain
     */
    public PayCloseChain builder() {
        return new PayCloseChain(alipayClient, alipayTradeCloseModel);
    }

    /**
     * Mandatory
     * Transaction serial number of the transaction in Alipay system
     * <p>
     * 必选
     * 该交易在支付宝系统中的交易流水号
     *
     * @param tradeNo tradeNo
     * @return PayCloseParamChain
     */
    public PayCloseParamChain builderTradeNo(String tradeNo) {
        alipayTradeCloseModel.setTradeNo(tradeNo);
        return this;
    }

    /**
     * Mandatory
     * The order number of the merchant passed in during order payment and the Alipay transaction number cannot be blank at the same time
     * <p>
     * 必选
     * 订单支付时传入的商户订单号,和支付宝交易号不能同时为空
     *
     * @param outTradeNo outTradeNo
     * @return PayCloseParamChain
     */
    public PayCloseParamChain builderOutTradeNo(String outTradeNo) {
        alipayTradeCloseModel.setOutTradeNo(outTradeNo);
        return this;
    }

    /**
     * Merchant operator ID, customized by the merchant
     * <p>
     * 商家操作员编号 id，由商家自定义
     *
     * @param operatorId operatorId
     * @return PayCloseParamChain
     */
    public PayCloseParamChain builderOperatorId(String operatorId) {
        alipayTradeCloseModel.setOperatorId(operatorId);
        return this;
    }


}
