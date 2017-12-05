# 商户主扫

| 方法 | void requestPhonePay\(NldPhonePay nldPhonePay,OnResultListeneronResultListener\) |
| :--- | :--- |
| 说明 | 商户主扫 |
| 输入参数 | 1.NldPhonePay 2.OnResultListener&lt;PhoneResult&gt;onResultListener接口回调 |
| 输出参数 | void |
| 附加说明 | NldPhoneResult:返回对象参数 |

## 输入参数NldPhonePay

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| amount | 1 | Max\(13\) | 实付金额 | 1元表示100\(分为单位\) |
| total\_amount | 1 | Max\(13\) | 订单总金额 | 1元表示100\(分为单位\) |
| authCode | 1 | Max\(256\) | 二维码信息 | 扫码支付授权码，设备读取用户微信或支付宝中的条码或者二维码信息\(最大位数256\) |
| payChannel | 1 | / | 支付渠道 | [附录](/SDK/Android SDK/appendix.md) |
| subject | 0 | Max\(512\) | 订单标题 | String内容值不能是null |
| selOrderNo | 0 | Max\(50\) | 订单号 | 数字or字母，组合 |
| goods\_tag | 0 | Max\(512\) | 订单优惠说明 | String内容值不能是null |
| attach | 0 | Max\(512\) | 附加数据 | String内容值不能是null |

## 返回参数NldPhonePay

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| logNo | 1 | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | Max\(1\) | 交易结查 | S-交易成功 F-交易失败 Z-交易未知 |
| orderNo | 0 | Max\(64\) | 支付渠道订单号 | 与用户支付订单中条码一致，可用于退货； |
| amount | 0 | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 0 | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| subject | 0 | Max\(512\) | 订单标题 | / |
| selOrderNo | 0 | Max\(50\) | 订单号 | 订货订单号 |
| goodsTag | 0 | Max\(512\) | 订单优惠说明 | / |
| attach | 1 | Max\(512\) | 附加数据 | / |



