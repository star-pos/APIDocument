# 客户主扫

该接口只是返回二维码链接等信息，无法得知用户支付结果，所以需要客户端在适当的时候调用查询接口获取支付结果。

```
注意：使用该接口一定要在成功调用后，通过调用同步的查询接口来获取支付结果。
NL_orderQuerySyncA
NL_customerScanBarcodePay这是一个宽字符版本，返回二维码链接信息等返回结果，
NL_customerScanBarcodePayA这是一个窄字符版本，功能同上

/**
扫码支付-客户主扫
*/
wchar_t* __stdcall NL_customerScanBarcodePay(wchar_t* param);
char* __stdcall NL_customerScanBarcodePayA(char* param);
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
    "paymentAmount":"1",
    "orderAmount":"1",
    "payType":"xxxx",
    "orderTitle":"xxx",
    "userOrderNo":"xxx",
    "discountComment":"xxx",
    "attachment":"xxx",

}
```

| **参数** | **说明** |
| :--- | :--- |
| organizationNo | 机构号，从平台申请获得 |
| merchantId | 商户ID，从平台申请获得（最大长度15个字符） |
| terminalId | 终端ID，从平台申请获得 |
| operId | 操作员ID，用户指定，数字，字母（可选）（最大长度6个字符） |
| devKey | 设备key值，商户密钥|
| merchantTradeSN | 商户单号，要求在商户端不重复，必要参数，可用于查询 |
| paymentAmount | 实付金额（最大长度13个字符） |
| orderAmount | 订单总金额（最大长度13个字符） |
| payType | 支付类型（最大长度20个字符） |
| orderTitle | 订单标题\(可选\)（最大长度512个字符） |
| userOrderNo | 用户指定的订单号\(可选\)（最大长度50个字符） |
| discountComment | 优惠说明\(可选\)（最大长度512个字符） |
| attachment | 附加数据\(可选\)（最大长度512个字符） |

## 输出参数

```
{
    "retCode":xx,
    "retMsg":"success",
    "merchantTradeSN":"xxx",
    "platformSerialNo":"xxxx",
    "platformOrderNo":"xxx",
    "paymentAmount":"1",
    "orderAmount":"1",
    "QRCodeAddress":"xxxx",
    "orderTitle":"xxx",
    "userOrderNo":"xxx",
    "discountComment":"xxx",
    "attachment":"xxx",
}
```

| **参数** | **说明** |
| :--- | :--- |
| retCode | 返回码\(int类型\) |
| retMsg | 返回信息 |
| merchantTradeSN | 输入参数中的商户单号，可用于查询 |
| platformSerialNo | 平台系统流水号 |
| platformOrderNo | 平台订单号，可用于退货\(操作成功时返回\) |
| paymentAmount | 实付金额\(操作成功时返回\) |
| orderAmount | 订单总金额\(操作成功时返回\) |
| QRCodeAddress | 生成二维码的信息，用于用户扫码\(可选\) |
| orderTitle | 订单标题\(可选\) |
| userOrderNo | 用户指定的订单号\(可选\) |
| discountComment | 优惠说明\(可选\) |
| attachment | 附加数据\(可选\) |



