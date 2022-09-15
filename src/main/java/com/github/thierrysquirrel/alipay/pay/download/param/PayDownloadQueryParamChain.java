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

package com.github.thierrysquirrel.alipay.pay.download.param;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayDataDataserviceBillDownloadurlQueryModel;
import com.github.thierrysquirrel.alipay.pay.download.PayDownloadQueryChain;
import lombok.Data;

/**
 * ClassName: PayDownloadQueryParamChain
 * Description: Document Address <a href="https://opendocs.alipay.com/open/b5c20219_alipay.data.dataservice.bill.downloadurl.query?scene=common&pathHash=5a085da8">Document Address</a>
 * 文档地址 <a href="https://opendocs.alipay.com/open/b5c20219_alipay.data.dataservice.bill.downloadurl.query?scene=common&pathHash=5a085da8">文档地址</a>
 * Date:2024/8/6
 *
 * @author ThierrySquirrel
 * @since JDK21
 */
@Data
public class PayDownloadQueryParamChain {
    private AlipayClient alipayClient;
    private AlipayDataDataserviceBillDownloadurlQueryModel alipayDataDataserviceBillDownloadurlQueryModel;

    public PayDownloadQueryParamChain(AlipayClient alipayClient, AlipayDataDataserviceBillDownloadurlQueryModel alipayDataDataserviceBillDownloadurlQueryModel) {
        this.alipayClient = alipayClient;
        this.alipayDataDataserviceBillDownloadurlQueryModel = alipayDataDataserviceBillDownloadurlQueryModel;
    }

    /**
     * Builder PayDownloadQueryChain
     * <p>
     * 构建 PayDownloadQueryChain
     *
     * @return PayDownloadQueryChain
     */
    public PayDownloadQueryChain builder() {
        return new PayDownloadQueryChain(alipayClient, alipayDataDataserviceBillDownloadurlQueryModel);
    }

    /**
     * Mandatory
     * Bill types, merchants can obtain the following bill types through interfaces or through interfaces authorized by the open platform for their affiliated service providers
     * <p>
     * 必选
     * 账单类型，商户通过接口或商户经开放平台授权后其所属服务商通过接口可以获取以下账单类型
     *
     * @param billType billType
     * @return PayDownloadQueryParamChain
     */
    public PayDownloadQueryParamChain builderBillType(String billType) {
        alipayDataDataserviceBillDownloadurlQueryModel.setBillType(billType);
        return this;
    }

    /**
     * Mandatory
     * Billing time: * Daily billing format is yyyy MM dd, and the earliest daily billing format available for download is January 1, 2016
     * <p>
     * 必选
     * 账单时间： * 日账单格式为yyyy-MM-dd，最早可下载2016年1月1日开始的日账单
     *
     * @param billDate billDate
     * @return PayDownloadQueryParamChain
     */
    public PayDownloadQueryParamChain builderBillDate(String billDate) {
        alipayDataDataserviceBillDownloadurlQueryModel.setBillDate(billDate);
        return this;
    }

    /**
     * Second level merchant smid, this parameter can only be used when bill-type is trade_zft_merchant
     * <p>
     * 二级商户smid，这个参数只在bill_type是trade_zft_merchant时才能使用
     *
     * @param smId smId
     * @return PayDownloadQueryParamChain
     */
    public PayDownloadQueryParamChain builderSmId(String smId) {
        alipayDataDataserviceBillDownloadurlQueryModel.setSmid(smId);
        return this;
    }
}
