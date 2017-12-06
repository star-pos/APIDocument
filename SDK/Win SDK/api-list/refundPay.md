# 退款

```
wchar_t* __stdcall NL_refund(wchar_t* param);
char*	__stdcall  NL_refundA(char* param);
char*	__stdcall  NL_refundSyncA(char* param);

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

## 输出参数

```

```



