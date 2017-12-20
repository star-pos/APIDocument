# MCC查询

## 请求参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| serviceId | 1 | String | 7 | 交易码 | 6060203 |
| version | 1 | String | 10 | 版本号 | V1.0.1 |
| orgNo | 1 | String | 6 | 合作商机构号 |  |
| signValue | 1 | String | 64 | 签名域 | 详见[安全规范](/mercRegist/safety-standard.md) |

## 返回参数

| **元素名称** | **约束** | **类型** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- |
| msg\_cd | 1 | String | 返回码 | 000000（成功） |
| msg\_dat | 1 | String | 返回信息 |  |
| signValue | 1 | String | 签名域 | 详见[安全规范](/mercRegist/safety-standard.md) |
| 以下为循环节点REC |  |  |  |  |
| mcc\_cd | 1 | String | MCC码 |  |
| mcc\_nm | 1 | String | MCC名称 |  |
| sup\_mcc\_cd | 1 | String | MCC大类 |  |
| sup\_mcc\_nm | 1 | String | MCC大类名称 |  |
| mcc\_typ | 1 | String | MCC小类 |  |
| 结束循环 |  |  |  |  |



