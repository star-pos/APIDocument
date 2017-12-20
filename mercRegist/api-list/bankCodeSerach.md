# 支行模糊查询

# 请求参数

| **元素名称** | **约束** | **类型** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- |
| serviceId | 1 | String | 交易码 | 6060208 |
| version | 1 | String | 版本号 | V1.0.1 |
| lbnk\_nm | 1 | String | 银行支行名称 | 最少输入字数不低于5个字 |
| orgNo | 1 | string | 机构号 |  |
| signValue | 1 | String | 签名域 | 详见[安全规范](/mercRegist/safety-standard.md) |

## 返回参数

| **元素名称** | **约束** | **类型** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- |
| msg\_cd | 1 | String | 返回码 | 000000（成功） |
| msg\_dat | 1 | String | 返回信息 |  |
| signValue | 1 | String | 签名域 | 详见[安全规范](/mercRegist/safety-standard.md) |
| 以下为循环节点REC |  |  |  |  |
| wc\_lbnk\_no | 1 | String | 联行行号 |  |
| lbnk\_nm | 1 | String | 支行名称 |  |
| 结束循环 |  |  |  |  |



