# 商户修改申请

商户审核通过，修改商户为修改未完成状态

## 请求参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| serviceId | 1 | String | 7 | 交易码 | 6060605 |
| version | 1 | String | 10 | 版本号 | V1.0.1 |
| mercId | 1 | string | 15 | 商户识别号（15位数字） |  |
| orgNo | 1 | string | 6 | 机构号 |  |
| signValue | 1 | String | 64 | 签名域 | 详见[安全规范](/mercRegist/api-list/mercSearch.md) |

## 返回参数

| **元素名称** | **约束** | **类型** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- |
| msg\_cd | 1 | String | 返回码 | 000000（成功） |
| msg\_dat | 1 | String | 返回信息 |  |
| mercId | 1 | String | 商户识别号 |  |
| stoe\_id | 1 | String | 门店号 |  |
| log\_no | 1 | String | 流水号 |  |
| signValue | 1 | String | 签名域 | 详见[安全规范](/mercRegist/api-list/mercSearch.md) |



