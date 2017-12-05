# 银行卡交易查询

## 请求地址

```
http://gateway.starpos.com.cn/adpweb/ehpspos3/sdkQryCardPay.json
```

## 请求参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| [公共请求参数](/scanAPI/public-parameter.md) |  |  |  |  |  |
| qryTyp | 1 | String | Max\(20\) | 查询类型： | 查询类型：1-根据终端凭证号查询2-根据系统参考号查询3-根据平台流水号查询4-根据第三方订单号查询 |
| batNo | 0 | String | Max\(20\) | 批次号 | qryTyp为1，2时 必输 |
| ctxndt | 0 | String | Max\(8\) | 终端交易日期 | qryTyp为1，2,3时 必输 |
| cseqNo | 0 | String | Max\(20\) | 终端凭证号 | qryTyp为1时 必输 |
| srefNo | 0 | String | Max\(50\) | 参考号 | qryTyp为2时 必输 |
| logNo | 0 | String | Max\(20\) | 平台流水号 | qryTyp为3时 必输 |
| selOrderNo | 0 | String | Max\(50\) | 第三方订单号 | qryTyp为4时 必输 |

## 返回参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| [公共返回参数](/scanAPI/public-parameter.md) |  |  |  |  |  |
| LogNo | 1 | String | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | String | Max\(1\) | 交易结查 | S-交易成功  F-交易失败 T-交易未知 D-订单已撤销 C-交易被冲正 |
| amount | 1 | String | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| batNo | 1 | String | Max\(20\) | 批次号 |  |
| ctxndt | 1 | String | Max\(8\) | 终端交易日期 |  |
| cseqNo | 1 | String | Max\(20\) | 终端凭证号 |  |
| srefNo | 1 | String | Max\(50\) | 参考号 |  |
| logNo | 1 | String | Max\(20\) | 平台流水号 |  |
| selOrderNo | 1 | String | Max\(50\) | 第三方订单号 | 第三方订单号 |

使用参考[收单扫码API](/README.md)

