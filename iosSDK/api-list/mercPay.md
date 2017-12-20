# 商户主扫

## 请求参数

| 参数名 | 约束 | 含义 | 字段类型 | 最大长度 | 备注 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| amount | 1 | 实付金额 | string | Max\(13\) | 1元表示100（分为单位） |
| total\_amount | 1 | 订单总金额 | string | Max\(13\) | 1元表示100（分为单位） |
| authCode | 1 | 二维码信息 | string | Max\(256\) | 扫码支付授权码，设备读取用户微信或支付宝中的条码或者二维码信息 |
| payChannel | 1 | 支付渠道 | enum | Max\(20\) | 详见[附录](/iosSDK/appendix.md) |
| subject | 0 | 订单标题 | string | Max\(256\) | 订单title |
| selOrderNo | 0 | 订单号 | string | Max\(50\) | 订货订单号 |
| goods\_tag | 0 | 订单优惠说明 | string | Max\(256\) |  |
| attach | 0 | 附加数据 | string | Max\(256\) |  |

## 返回参数

| 参数名 | 约束 | 含义 | 字段类型 | 最大长度 | 备注 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| logNo | 1 | 系统流水号 | string | Max\(20\) | 平台系统流水号 |
| result | 1 | 交易结查 | string | Max\(1\) | S-交易成功F-交易失败Z-交易未知 |
| orderNo | 0 | 支付渠道订单号 | string | Max\(64\) | 与用户支付订单中条码一致，可用于退货； |
| amount | 0 | 实付金额 | string | Max\(13\) | 以分为单位，如1元表示为100 |
| total\_amount | 0 | 订单总金额 | string | Max\(13\) | 以分为单位，如1元表示为100 |
| subject | 0 | 订单标题 | string | Max\(256\) |  |
| selOrderNo | 0 | 订单号 | string | Max\(50\) | 订货订单号,传@“”为不传,传@“ ”为传，会校严格式 |
| goodsTag | 0 | 订单优惠说明 | string | Max\(256\) |  |
| attach | 0 | 附加数据 | string | Max\(256\) |  |



