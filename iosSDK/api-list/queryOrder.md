# 订单查询

## 请求参数

| 参数名 | 约束 | 含义 | 字段类型 | 最大长度 | 备注 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| qryNo | 1 | 查询流水 | string | Max\(64\) | 可根据logNo、orderNo、tradeNo的值做查询 |

## 返回参数

| 参数名 | 约束 | 含义 | 字段类型 | 最大长度 | 备注 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| logNo | 1 | 系统流水号 | string | Max\(20\) | 平台系统流水号 |
| result | 1 | 交易结查 | string | Max\(1\) | S-交易成功F-交易失败Z-交易未知 |
| payChannel | 1 | 支付渠道 | enum | Max\(20\) | 详见[附录](/iosSDK/appendix.md) |
| orderNo | 0 | 支付渠道订单号 | string | Max\(64\) | 与用户支付订单中条码一致，可用于退货； |
| amount | 0 | 实付金额 | string | Max\(13\) | 以分为单位，如1元表示为100 |
| total\_amount | 0 | 订单总金额 | string | Max\(13\) | 以分为单位，如1元表示为100 |
| subject | 0 | 订单标题 | string | Max\(256\) |  |
| selOrderNo | 0 | 订单号 | string | Max\(50\) | 订货订单号 |
| goodsTag | 0 | 订单优惠说明 | string | Max\(256\) |  |
| attach | 0 | 附加数据 | string | Max\(256\) |  |



