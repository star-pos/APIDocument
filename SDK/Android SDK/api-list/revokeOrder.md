# 撤销订单

> 传需要撤销订单的tradeNo

| 方法 | void requestRevoke\(NldRevoke nldRevoke, OnResultListeneronResultListener\) |
| :--- | :--- |
| 说明 | 订单撤销 |
| 输入参数 | 1.NldRevoke输入参数 2.OnResultListener&lt; NldRevokeResult &gt; onResultListener接口回调 |
| 输出参数 | void |
| 附加说明 | NldRevokeResult:返回对象参数 |

## 请求参数NldRevoke

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| qryNo | 1 | Max\(64\) | 查询流水 | tradeNo（商户单号） |

## 返回参数NldQueryResult

| 参数名 | 约束 | 最大长度 | 含义 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| logNo | 1 | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | Max\(1\) | 交易结查 | S-交易成功 F-交易失败 Z-交易未知 |
| payChannel | 1 | / | 支付渠道 | 详情见附录5.1 |
| amount | 0 | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 1 | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| subject | 0 | Max\(512\) | 订单标题 | / |
| selOrderNo | 0 | Max\(50\) | 订单号 | 订货订单号 |
| goodsTag | 0 | Max\(512\) | 订单优惠说明 | / |
| attach | 1 | Max\(512\) | 附加数据 | / |



