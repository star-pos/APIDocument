# 商户主扫

## 请求参数

| 参数名 | 约束 | 含义 | 字段类型 | 最大长度 | 备注 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| amount | 1 | 实付金额 | string | Max\(13\) | 1元表示100（分为单位） |
| total\_amount | 1 | 订单总金额 | string | Max\(13\) | 1元表示100（分为单位） |
| authCode | 1 | 二维码信息 | string | Max\(256\) | 扫码支付授权码，设备读取用户微信或支付宝中的条码或者二维码信息 |
| payChannel | 1 | 支付渠道 | enum | Max\(20\) | 附录5.1 |
| subject | 0 | 订单标题 | string | Max\(256\) | 订单title |
| selOrderNo | 0 | 订单号 | string | Max\(50\) | 订货订单号 |
| goods\_tag | 0 | 订单优惠说明 | string | Max\(256\) |  |
| attach | 0 | 附加数据 | string | Max\(256\) |  |

## 返回参数

