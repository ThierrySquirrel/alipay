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

package com.github.thierrysquirrel.alipay.pay.refund.query;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import lombok.Data;

/**
 * ClassName: PayRefundQueryChain
 * Description:
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayRefundQueryChain {
    private AlipayClient alipayClient;
    private AlipayTradeFastpayRefundQueryModel alipayTradeFastpayRefundQueryModel;

    public PayRefundQueryChain(AlipayClient alipayClient, AlipayTradeFastpayRefundQueryModel alipayTradeFastpayRefundQueryModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeFastpayRefundQueryModel = alipayTradeFastpayRefundQueryModel;
    }

    /**
     * Build Refund Query
     * <p>
     * 构建退款查询
     *
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String refundQuery() throws AlipayApiException {
        AlipayTradeFastpayRefundQueryRequest queryRequest = new AlipayTradeFastpayRefundQueryRequest();
        queryRequest.setBizModel(alipayTradeFastpayRefundQueryModel);
        return alipayClient.execute(queryRequest).getBody();
    }

    /**
     * Custom Build QueryRequest
     * <p>
     * 自定义构建 QueryRequest
     *
     * @param queryRequest queryRequest
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String refundQuery(AlipayTradeFastpayRefundQueryRequest queryRequest) throws AlipayApiException {
        queryRequest.setBizModel(alipayTradeFastpayRefundQueryModel);
        return alipayClient.execute(queryRequest).getBody();
    }

}
