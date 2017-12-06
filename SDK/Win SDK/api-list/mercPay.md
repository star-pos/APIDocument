# 商户主扫

```
wchar_t* __stdcall NL_merchantScanBarcodePay(wchar_t* param);
char* __stdcall NL_merchantScanBarcodePaySyncA(char* param);
char* __stdcall NL_merchantScanBarcodePayA(char* param);
NL_merchantScanBarcodePay 这是一个异步接口，宽字符版本，只完成一次支付操作，返回结果，没有对支付未知等情况做查询操作。需要客户端自己结合自己的业务逻辑来使用。
NL_merchantScanBarcodePayA 这是一个窄字符版本，功能同上
NL_merchantScanBarcodePaySyncA这是一个同步的窄字符版本，针对支付未知等情况作了轮询操作，轮询时间间隔，次数可以在配置文件里面配置。完成后才会返回结果。
```

## 输入参数

```
{
    "organizationNo":"xxxx",
    "merchantId":"xxxx",
    "terminalId":"xxxx",
    "operId":"xxxx",
    "devKey":"xxxx",
    "merchantTradeSN":"xxxx",
    "paymentAmount":"1",
    "orderAmount":"1",
    "paymentCode":"xxxx",
    "payType":"xxxx",
    "merchantName":"xxx",
    "batchNo":"xxx",
    "voucherNo":"xxx",
    "orderTitle":"xxx",
    "userOrderNo":"xxx",
    "discountComment":"xxx",
    "attachment":"xxx",

}
```

## 输出参数



