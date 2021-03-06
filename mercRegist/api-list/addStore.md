# 商户新增门店

商户新增门店时商户的状态（注册未完成、修改未完成）

## 请求参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| serviceId | 1 | String | 7 | 交易码 | 6060602 |
| mercId | 1 | string | 15 | 商户号 |  |
| log\_no | 1 | String | 18 | 流水号 |  |
| version | 1 | String | 10 | 版本号 | V1.0.1 |
| scan\_stoe\_cnm | 0 | String | 20 | 扫码小票商户名称 | 1-20个中文、字母或数字 |
| tranTyps | 0 | string |  | 交易类型（必填，至少选一项）多选以英文逗号分割例如：C1,C2,C3（银行卡必选） | C1.消费C2.消费撤销C3.预授权C4.预授权完成C5.预授权完成撤销C6.预授权撤销C7.余额查询 |
| suptDbfreeFlg | 0 | String | 1 | 免密免签（银行卡必选） | 0-不支持1支持 |
| cardTyp | 0 | String | 2 | 卡种（银行卡必选） | 00-全部01-借记卡02-贷记卡 |
| stl\_sign | 1 | String | 1 | 结算标志 | 1-对私 0-对公 |
| orgNo | 1 | String | 6 | 机构号 | 合作商机构号 |
| stl\_oac | 1 | String | 23 | 结算账户 | 1-23位数字 |
| bnk\_acnm | 1 | String | 45 | 户名 | 2-45个字符，汉字，字母，数字 |
| icrp\_id\_no | 0 | String | 18 | 结算人身份证号 | 结算标志为1-对私必输，对私：必输，18位数字对公，后台默认给法人身份证号 |
| crp\_exp\_dt\_tmp | 0 | String | 10 | 结算人身份证有限期（永久9999-12-31） | 结算标志为1-对私必输对私：输入格式1999-12-31对公：默认法人身份证到期日 |
| wc\_lbnk\_no | 1 | String | 12 | 开户行 | 联行行号12位数字校验正确性 |
| stoe\_nm | 1 | String | 20 | 签购单名称 | 8-20个数字、字母、汉字不能全为数字 |
| stoe\_cnt\_nm | 1 | String | 10 | 联系人名称 | 长度2-10，字母、数字、汉字不能全为数字 |
| stoe\_cnt\_tel | 1 | String | 11 | 联系人手机号 | 11位数字 |
| mcc\_cd | 1 | String | 4 | 商户类型 | MCC码，校验合法性 |
| stoe\_area\_cod | 1 | String | 6 | 地区码 | 6位数字，校验合法性 |
| stoe\_adds | 1 | String | 65 | 商户地址 | 格式：详细地址 |
| trm\_rec | 1 | String | 2 | 终端数量 | 范围在1-99 |
| mailbox | 1 | String | 50 | 联系人邮箱 |  |
| alipay\_flg | 1 | String | 1 | 扫码产品 | Y-选择N-不选择最少选一个产品 |
| yhkpay\_flg | 1 | String | 1 | 银行卡产品 |  |
| fee\_rat\_scan | 0 | String | 精确到小数点后2位 | 扫码费率\(%\) | 默认：0.38，（0.25%-3%）范围浮动（扫码支付勾选时必输） |
| fee\_rat1\_scan | 0 | String | 精确到小数点后2位 | 银联二维码费率 | 银行卡和扫码都选择时候必输，最小0.22 |
| fee\_rat2\_scan | 0 | String | 精确到小数点后2位 | 银联标准费率 | 银行卡和扫码都选择时候必输，最小0.6 |
| fee\_rat | 0 | String | 精确到小数点后2位 | 借记卡费率\(%\) | 默认0.5，0.4%-3% 浮动银行卡（银行卡产品选择时必输） |
| max\_fee\_amt | 0 | String | 2 | 借记卡封顶（元） | 默认20，最低18， 0表示不封顶（银行卡产品选择时必输） |
| fee\_rat1 | 0 | String | 精确到小数点后2位 | 贷记卡费率（%） | 默认0.6，贷记卡0.52%-3%范围浮动（银行卡产品选择时必输） |
| signValue | 1 | String | 64 | 签名域 | 详见[安全规范](/mercRegist/safety-standard.md) |

## 返回参数

| **元素名称** | **约束** | **类型** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- |
| log\_no | 1 | String | 流水号 |  |
| msg\_cd | 1 | String | 返回码 | 000000（成功） |
| msg\_dat | 1 | String | 返回信息 |  |
| mercId | 1 | String | 商户识别号 |  |
| stoe\_id | 1 | String | 门店号 |  |
| signValue | 1 | String | 签名域 | 详见[安全规范](/mercRegist/safety-standard.md) |



