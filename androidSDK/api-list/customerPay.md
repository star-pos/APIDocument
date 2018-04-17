# 客户主扫

> 必须进行轮询，判断支付状态

| 方法 | void requestPosPay\(NldPosPay nldPosPay, OnResultListeneronResultListener\) |
| :--- | :--- |
| 说明 | 客户主扫 |
| 输入参数 | 1.NldPosPay<br> 2.OnResultListener&lt;NldPosResult&gt;onResultListener接口回调 |
| 输出参数 | void |
| 附加说明 | NldPosResult:返回对象参数 |

## 请求参数NldPosPay

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| amount | 1 | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100\(最大位数13位\) |
| total\_amount | 1 | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100\(最大位数13位\) |
| payChannel | 1 | / | 支付渠道 | 详情见[附录](/androidSDK/appendix.md) |
| subject | 0 | Max\(512\) | 订单标题 | String内容值不能是null |
| selOrderNo | 0 | Max\(50\) | 订单号 | 数字or字母，组合 |
| goods\_tag | 0 | Max\(512\) | 订单优惠说明 | String内容值不能是null |
| attach | 0 | Max\(512\) | 附加数据 | String内容值不能是null |

## 返回参数NldPosResult

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| logNo | 1 | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | Max\(1\) | 交易结查 | S-交易成功<br> F-交易失败<br> Z-交易未知<br> |
| payCode | 0 | Max\(256\) | 二维码地址 | 二维码生成地址字符串 |
| orderNo | 0 | Max\(64\) | 支付渠道订单号 | / |
| amount | 0 | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 0 | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| subject | 0 | Max\(512\) | 订单标题 | / |
| selOrderNo | 0 | Max\(50\) | 订单号 | 订货订单号 |
| goodsTag | 0 | Max\(512\) | 订单优惠说明 | / |
| attach | 1 | Max\(512\) | 附加数据 | / |



