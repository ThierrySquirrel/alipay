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

package com.github.thierrysquirrel.alipay.pay.refund;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import lombok.Data;

/**
 * ClassName: PayRefundChain
 * Description:
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayRefundChain {
    private AlipayClient alipayClient;
    private AlipayTradeRefundModel alipayTradeRefundModel;

    public PayRefundChain(AlipayClient alipayClient, AlipayTradeRefundModel alipayTradeRefundModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeRefundModel = alipayTradeRefundModel;
    }

    /**
     * Building Refund
     * <p>
     * 构建退款
     *
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String refund() throws AlipayApiException {
        AlipayTradeRefundRequest refundRequest = new AlipayTradeRefundRequest();
        refundRequest.setBizModel(alipayTradeRefundModel);
        return alipayClient.execute(refundRequest).getBody();
    }

    /**
     * Custom Build RefundRequest
     * <p>
     * 自定义构建 RefundRequest
     *
     * @param refundRequest refundRequest
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String refund(AlipayTradeRefundRequest refundRequest) throws AlipayApiException {
        refundRequest.setBizModel(alipayTradeRefundModel);
        return alipayClient.execute(refundRequest).getBody();
    }

}
