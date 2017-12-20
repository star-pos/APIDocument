# 商户提交

商户提交时的状态（注册未完成、修改未完成）

## 请求参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| serviceId | 1 | String | 7 | 交易码 | 6060603 |
| version | 1 | String | 10 | 版本号 | V1.0.1 |
| mercId | 1 | string | 15 | 商户识别号（15位数字） |  |
| log\_no | 1 | String | 18 | 流水号 |  |
| orgNo | 1 | string | 6 | 机构号 |  |
| signValue | 1 | String | 64 | 签名域 | 详见[安全规范](/mercRegist/safety-standard.md) |

## 返回参数

| **元素名称** | **约束** | **类型** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- |
| check\_flag | 1 | String | 审核结果 | 1-通过2-驳回3-转人工 |
| msg\_cd | 1 | String | 返回码 | 000000（成功） |
| msg\_dat | 1 | String | 返回信息 |  |
| mercId | 1 | String | 商户识别号 |  |
| signValue | 1 | String | 签名域 | 详见[安全规范](/mercRegist/safety-standard.md) |
| chek\_msg | 0 | String | 审核备注 | check\_flag=2或3时返回 |
| key | 0 | String | 商户密钥（有扫码产品） | check\_flag=1时审核通过返回 |
| 以下为循环节点REC |  |  |  |  |
| trmNo | 0 | String | 设备号 | check\_flag=1时审核通过返回 |
| 结束循环 |  |  |  |  |



