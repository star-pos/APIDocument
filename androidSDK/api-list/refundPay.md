# 退款

| 方法 | void requestRefundPay\(NldRefundPay nldRefundPay, OnResultListener&lt;NldRefundResult&gt;onResultListener\) |
| :--- | :--- |
| 说明 | 退款 |
| 输入参数 | 1. Nld RefundPay 2.OnResultListener&lt;NldRefundResult&gt;onResultListener接口回调 |
| 输出参数 | void |
| 附加说明 | NldRefundResult:返回对象参数 |

## 输入参数NldRefundPay

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| orderNo | 1 | Max\(64\) | 支付渠道订单号 | 最大位数64位 |
| txnAmt | 0 | Max\(13\) | 退款金额 | 不送时，表示全额退款 |

## 返回参数NldRefundResult

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| logNo | 1 | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | Max\(1\) | 交易结查 | S-交易成功<br> F-交易失败<br> Z-交易未知  |
| txnAmt | 1 | Max\(13\) | 退款金额 | / |
| amount | 1 | Max\(13\) | 原实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 1 | Max\(13\) | 原订单总金额 | 以分为单位，如1元表示为100 |
| subject | 0 | Max\(512\) | 订单标题 | / |
| selOrderNo | 0 | Max\(50\) | 订单号 | 订货订单号 |
| goodsTag | 0 | Max\(512\) | 订单优惠说明 | / |
| attach | 1 | Max\(512\) | 附加数据 | / |



