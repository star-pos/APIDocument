# 退款

```
wchar_t* __stdcall NL_refund(wchar_t* param);
char*    __stdcall  NL_refundA(char* param);
char*    __stdcall  NL_refundSyncA(char* param);

NL_refund 这是一个异步接口，宽字符版本，只完成一次退款操作，返回结果，没有对支付未知等情况做查询操作。需要客户端自己结合自己的业务逻辑来使用。
NL_refundA 这是一个窄字符版本，功能同上
NL_refundSyncA 这是一个同步的窄字符版本，针对支付未知等情况作了查询操作，轮询时间间隔，次数可以在配置文件里面配置。完成后才会返回结果。
```

## 输入参数

```
{
    "organizationNo":"xxxx",
    "merchantId":"xxxx",
    "terminalId":"xxxx",
    "operId":"xxxx",
    "devKey":"xxxx",
    "merchantTradeSN":"xxx",
    "platformOrderNo":"xxxx",
    "amount":"xxxx",
    "merchantName":"xxx",
    "batchNo":"xxx",
    "voucherNo":"xxx",
}
```

| **参数** | **说明** |
| :--- | :--- |
| organizationNo | 机构号，从平台申请获得 |
| merchantId | 商户ID，从平台申请获得（最大长度15个字符） |
| terminalId | 终端ID，从平台申请获得 |
| operId | 操作员ID，用户指定，数字，字母（可选）（最大长度6个字符） |
| devKey | 设备key值，商户密钥 |
| merchantTradeSN | 商户单号，要求在商户端不重复，必要参数，可用于查询 |
| platformOrderNo | 订单号，支付时SDK返回获得（最大长度64个字符） |
| amount | 退款金额（最大长度13个字符） |
| merchantName | 商户名称（最大长度256个字符）（可选）用于打印 |
| batchNo | 批次号（可选）用于打印 |
| voucherNo | 凭证号（可选）用于打印 |

## 输出参数

```
{
    "retCode":xx,
    "retMsg":"success",
    "merchantTradeSN":"xxx",
    "platformSerialNo":"xxxx",
    "refundAmount":"1",
    "paymentAmount":"1",
    "orderAmount":"1",
    "orderTitle":"xxx",
    "userOrderNo":"xxx",
    "discountComment":"xxx",
    "attachment":"xxx",
}
```

| 参数 | 说明 |
| :--- | :--- |
| retCode | 返回码\(int类型\) |
| retMsg | 返回信息 |
| merchantTradeSN | 输入参数中的商户单号，可用于查询 |
| platformSerialNo | 平台系统流水号 |
| refundAmount | 退款金额 |
| paymentAmount | 实付金额 |
| orderAmount | 订单总金额 |
| orderTitle | 订单标题\(可选\) |
| userOrderNo | 用户指定的订单号\(可选\) |
| discountComment | 优惠说明\(可选\) |
| attachment | 附加数据\(可选\) |





