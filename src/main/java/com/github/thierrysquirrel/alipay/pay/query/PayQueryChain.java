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

package com.github.thierrysquirrel.alipay.pay.query;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import lombok.Data;

/**
 * ClassName: PayQueryChain
 * Description:
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayQueryChain {
    private AlipayClient alipayClient;
    private AlipayTradeQueryModel alipayTradeQueryModel;

    public PayQueryChain(AlipayClient alipayClient, AlipayTradeQueryModel alipayTradeQueryModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeQueryModel = alipayTradeQueryModel;
    }

    /**
     * Building Query
     * <p>
     * 构建查询
     *
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String query() throws AlipayApiException {
        AlipayTradeQueryRequest queryRequest = new AlipayTradeQueryRequest();
        queryRequest.setBizModel(alipayTradeQueryModel);
        return alipayClient.execute(queryRequest).getBody();
    }

    /**
     * Custom Build QueryRequest
     * <p>
     * 自定义构建QueryRequest
     *
     * @param queryRequest queryRequest
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String query(AlipayTradeQueryRequest queryRequest) throws AlipayApiException {
        return alipayClient.execute(queryRequest).getBody();
    }
}
