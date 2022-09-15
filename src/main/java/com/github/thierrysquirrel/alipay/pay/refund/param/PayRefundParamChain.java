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

package com.github.thierrysquirrel.alipay.pay.refund.param;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.domain.OpenApiRoyaltyDetailInfoPojo;
import com.alipay.api.domain.RefundGoodsDetail;
import com.github.thierrysquirrel.alipay.pay.refund.PayRefundChain;
import lombok.Data;

import java.util.List;

/**
 * ClassName: PayRefundParamChain
 * Description: Document Address <a href="https://opendocs.alipay.com/open/6c0cdd7d_alipay.trade.refund?scene=common&pathHash=4081e89c">Document Address</a>
 * 文档地址: <a href="https://opendocs.alipay.com/open/6c0cdd7d_alipay.trade.refund?scene=common&pathHash=4081e89c">文档地址</a>
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayRefundParamChain {
    private AlipayClient alipayClient;
    private AlipayTradeRefundModel alipayTradeRefundModel;

    public PayRefundParamChain(AlipayClient alipayClient, AlipayTradeRefundModel alipayTradeRefundModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeRefundModel = alipayTradeRefundModel;
    }

    /**
     * Builder PayRefundChain
     * <p>
     * 构建 PayRefundChain
     *
     * @return PayRefundChain
     */
    public PayRefundChain builder() {
        return new PayRefundChain(alipayClient, alipayTradeRefundModel);
    }

    /**
     * Mandatory
     * refund amount
     * <p>
     * 必选
     * 退款金额
     *
     * @param refundAmount refundAmount
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builderRefundAmount(String refundAmount) {
        alipayTradeRefundModel.setRefundAmount(refundAmount);
        return this;
    }

    /**
     * Mandatory
     * Merchant order number
     * <p>
     * 必选
     * 商户订单号
     *
     * @param outTradeNo outTradeNo
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builderOutTradeNo(String outTradeNo) {
        alipayTradeRefundModel.setOutTradeNo(outTradeNo);
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
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builderTradeNo(String tradeNo) {
        alipayTradeRefundModel.setTradeNo(tradeNo);
        return this;
    }

    /**
     * Reason for refund explanation
     * <p>
     * 退款原因说明
     *
     * @param refundReason refundReason
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builderRefundReason(String refundReason) {
        alipayTradeRefundModel.setRefundReason(refundReason);
        return this;
    }

    /**
     * Refund Request Number
     * <p>
     * 退款请求号
     *
     * @param outRequestNo outRequestNo
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builderOutRequestNo(String outRequestNo) {
        alipayTradeRefundModel.setOutRequestNo(outRequestNo);
        return this;
    }

    /**
     * List of products included in the refund
     * <p>
     * 退款包含的商品列表信息
     *
     * @param refundGoodsDetail refundGoodsDetail
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builderRefundGoodsDetail(List<RefundGoodsDetail> refundGoodsDetail) {
        alipayTradeRefundModel.setRefundGoodsDetail(refundGoodsDetail);
        return this;
    }

    /**
     * Details of Refund Accounts
     * <p>
     * 退分账明细信息
     *
     * @param refundRoyaltyParameters refundRoyaltyParameters
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builderRefundRoyaltyParameters(List<OpenApiRoyaltyDetailInfoPojo> refundRoyaltyParameters) {
        alipayTradeRefundModel.setRefundRoyaltyParameters(refundRoyaltyParameters);
        return this;
    }

    /**
     * query option
     * <p>
     * 查询选项
     *
     * @param queryOptions queryOptions
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builderQueryOptions(List<String> queryOptions) {
        alipayTradeRefundModel.setQueryOptions(queryOptions);
        return this;
    }

    /**
     * For payment term transactions, if a refund is to be made after confirming settlement, it is necessary to specify the settlement number at the time of confirmation settlement
     * <p>
     * 针对账期交易，在确认结算后退款的话，需要指定确认结算时的结算单号
     *
     * @param relatedSettleConfirmNo relatedSettleConfirmNo
     * @return PayRefundParamChain
     */
    public PayRefundParamChain builder(String relatedSettleConfirmNo) {
        alipayTradeRefundModel.setRelatedSettleConfirmNo(relatedSettleConfirmNo);
        return this;
    }

}
