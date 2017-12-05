# 轮询接口

| 方法 | void requestRollQueryPay\(NldQueryPay nldQueryPay, OnResultListeneronResultListener\) |
| :--- | :--- |
| 说明 | 订单轮询 |
| 输入参数 | 1. NldQueryPay输入参数\(参考订单查询\) 2. OnResultListeneronResultListener接口回调 |
| 输出参数 | void |
| 附加说明 | NldQueryResult:返回对象参数 |

## 请求参数NldQueryPay

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| qryNo | 1 | Max\(64\) | 查询流水 | 可根据logNo、orderNo、tradeNo的值做查询\(最大位数是64位\) |

## 返回参数NldQueryResult

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| logNo | 1 | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | Max\(1\) | 交易结查 | S-交易成功 F-交易失败 Z-交易未知 A-等待授权 |
| payChannel | 1 | / | 支付渠道 | 详情见附录5.1 |
| orderNo | 0 | Max\(64\) | 支付渠道订单号 | 与用户支付订单中条码一致，可用于退货； |
| amount | 0 | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 1 | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| subject | 0 | Max\(512\) | 订单标题 | / |
| selOrderNo | 0 | Max\(50\) | 订单号 | 订货订单号 |
| goodsTag | 0 | Max\(512\) | 订单优惠说明 | / |
| attach | 1 | Max\(512\) | 附加数据 | / |



