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

package com.github.thierrysquirrel.alipay.pay.download;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayDataDataserviceBillDownloadurlQueryModel;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import lombok.Data;

/**
 * ClassName: PayDownloadQueryChain
 * Description:
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayDownloadQueryChain {
    private AlipayClient alipayClient;
    private AlipayDataDataserviceBillDownloadurlQueryModel alipayDataDataserviceBillDownloadurlQueryModel;

    public PayDownloadQueryChain(AlipayClient alipayClient, AlipayDataDataserviceBillDownloadurlQueryModel alipayDataDataserviceBillDownloadurlQueryModel) {
        this.alipayClient = alipayClient;
        this.alipayDataDataserviceBillDownloadurlQueryModel = alipayDataDataserviceBillDownloadurlQueryModel;
    }

    /**
     * Build Query Bill Download
     * <p>
     * 构建查询账单下载
     *
     * @return String
     * @throws AlipayApiException AlipayApiException
     */
    public String downloadQuery() throws AlipayApiException {
        AlipayDataDataserviceBillDownloadurlQueryRequest queryRequest = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        queryRequest.setBizModel(alipayDataDataserviceBillDownloadurlQueryModel);
        return alipayClient.execute(queryRequest).getBillDownloadUrl();
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
    public String downloadQuery(AlipayDataDataserviceBillDownloadurlQueryRequest queryRequest) throws AlipayApiException {
        queryRequest.setBizModel(alipayDataDataserviceBillDownloadurlQueryModel);
        return alipayClient.execute(queryRequest).getBillDownloadUrl();
    }

}
