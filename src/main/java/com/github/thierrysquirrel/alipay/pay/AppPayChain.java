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

package com.github.thierrysquirrel.alipay.pay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import lombok.Data;

/**
 * ClassName: AppPayChain
 * Description:
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class AppPayChain {
    private AlipayClient alipayClient;
    private AlipayTradeAppPayModel alipayTradeAppPayModel;

    public AppPayChain(AlipayClient alipayClient, AlipayTradeAppPayModel alipayTradeAppPayModel) {
        this.alipayClient = alipayClient;
        this.alipayTradeAppPayModel = alipayTradeAppPayModel;
    }

    /**
     * AliPay Server Initiatively Tells The Http/Https Path Specified In The Merchant Server.
     * <p>
     * 支付宝服务器主动通知商户服务器里指定的页面http/https路径
     *
     * @param notifyUrl notifyUrl
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String pay(String notifyUrl) throws AlipayApiException {
        AlipayTradeAppPayRequest payRequest = new AlipayTradeAppPayRequest();
        payRequest.setNotifyUrl(notifyUrl);
        payRequest.setBizModel(alipayTradeAppPayModel);
        return alipayClient.sdkExecute(payRequest).getBody();
    }

    /**
     * Custom Build PayRequest
     * <p>
     * 自定义构建PayRequest
     *
     * @param payRequest payRequest
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String pay(AlipayTradeAppPayRequest payRequest) throws AlipayApiException {
        payRequest.setBizModel(alipayTradeAppPayModel);
        return alipayClient.sdkExecute(payRequest).getBody();
    }
}
