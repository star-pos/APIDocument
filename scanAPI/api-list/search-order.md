# 订单查询

## 流程图

![](/assets/doc-pic4-8.png)

## 请求地址

```
测试环境请求地址：http://139.196.77.69:8280/adpweb/ehpspos3/sdkQryBarcodePay.json
生产环境请求地址：http://gateway.starpos.com.cn/adpweb/ehpspos3/sdkQryBarcodePay.json
```

## 请求参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| [公共请求参数](/scanAPI/public-parameter.md) |  |  |  |  |  |
| qryNo | 1 | String | Max\(64\) | 查询流水 | 可根据logNo、orderNo、tradeNo的值做查询 |

## 返回参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :---: |
| [公共返回参数](/scanAPI/public-parameter.md) |  |  |  |  |  |
| logNo | 1 | String | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | String | Max\(1\) | 交易结查 | S-交易成功          F-交易失败        A-等待授权        Z-交易未知        D-订单已撤销 |
| payChannel | 1 | String | Max\(20\) | 支付渠道 | 详见[附录](/scanAPI/appendix.md) |
| orderNo | 0 | String | Max\(64\) | 支付渠道订单号 | 与用户支付订单中条码一致，可用于退货； |
| amount | 0 | String | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 0 | String | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| subject | 0 | String | Max\(512\) | 订单标题 |  |
| selOrderNo | 0 | String | Max\(50\) | 订单号 | 订货订单号 |
| goodsTag | 0 | String | Max\(512\) | 订单优惠说明 |  |
| attach | 0 | String | Max\(512\) | 附加数据 |  |
| refAmt | 1 | String | Max\(13\) | 退款金额 | 以分为单位，如1元表示为100版本号需上送V1.0.1 |



