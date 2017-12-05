接口列表

| **方法** | **说明** |
| :--- | :--- |
| void init\(String secretKey\); | 初始化key |
| void requestPhonePay\(NldPhonePay nldPhonePay,OnResultListeneronResultListener\) | 商户主扫 |
| void requestPosPay\(NldPosPay nldPosPay, OnResultListeneronResultListener\) | 客户主扫 |
| void requestRefundPay\(NldRefundPay nldRefundPay, OnResultListeneronResultListener\) | 退款 |
| void requestQueryPay\(NldQueryPay nldQueryPay,OnResultListeneronResultListener\) | 订单查询 |
| void setDebugModule\(final boolean isDebug\) | 是否显示log信息 |
| void requestRollQueryPay\(NldQueryPay nldQueryPay,OnResultListeneronResultListener\) | 轮询接口 |
| void requestRevoke\(NldRevoke nldRevoke, OnResultListeneronResultListener\) | 撤销接口 |



