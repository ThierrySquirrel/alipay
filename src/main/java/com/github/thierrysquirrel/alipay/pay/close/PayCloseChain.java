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

package com.github.thierrysquirrel.alipay.pay.close;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeCloseModel;
import com.alipay.api.request.AlipayTradeCloseRequest;
import lombok.Data;

/**
 * ClassName: PayCloseChain
 * Description:
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayCloseChain {
    private AlipayClient alipayClient;
    private AlipayTradeCloseModel alipayTradeCloseModel;

    public PayCloseChain(AlipayClient alipayClient, AlipayTradeCloseModel alipayTradeCloseModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeCloseModel = alipayTradeCloseModel;
    }

    /**
     * Build Closing Transaction
     * <p>
     * 构建关闭交易
     *
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String close() throws AlipayApiException {
        AlipayTradeCloseRequest closeRequest = new AlipayTradeCloseRequest();
        closeRequest.setBizModel(alipayTradeCloseModel);
        return alipayClient.execute(closeRequest).getBody();
    }

    /**
     * Custom Build CloseRequest
     * <p>
     * 自定义构建CloseRequest
     *
     * @param closeRequest closeRequest
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String close(AlipayTradeCloseRequest closeRequest) throws AlipayApiException {
        return alipayClient.execute(closeRequest).getBody();
    }
}
