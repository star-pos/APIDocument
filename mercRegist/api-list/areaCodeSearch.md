# 区域码查询

## 请求参数

| **元素名称** | **约束** | **类型** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- |
| serviceId | 1 | String | 交易码 | 6060206 |
| version | 1 | String | 版本号 | V1.0.1 |
| orgNo | 1 | String | 合作商机构号 |  |
| prov\_nm | 0 | String | 省名称 |  |
| city\_nm | 0 | String | 市名称 |  |
| signValue | 1 | String | 签名域 | 详见[安全规范](/mercRegist/api-list/mercSearch.md) |

## 返回参数



| **元素名称** | **约束** | **类型** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- |
| msg\_cd | 1 | String | 返回码 | 000000（成功） |
| msg\_dat | 1 | String | 返回信息 |  |
| signValue | 1 | String | 签名域 | 详见[安全规范](/mercRegist/api-list/mercSearch.md) |
| 以下为循环节点REC |  |  |  |  |
| merc\_area | 1 | String | 区域码 |  |
| area\_nm | 1 | String | 区域名称 |  |
| merc\_prov | 1 | String | 省份 |  |
| prov\_nm | 1 | String | 省份名称 |  |
| merc\_city | 1 | String | 城市 |  |
| city\_nm | 1 | String | 城市名称 |  |
| 结束循环 |  |  |  |  |



