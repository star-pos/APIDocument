# 查询订单

```
wchar_t* __stdcall NL_orderQuery(wchar_t* param);
char*	__stdcall  NL_orderQueryA(char* param);
char*	__stdcall  NL_orderQuerySyncA(char* param);

NL_orderQuery 这是一个异步接口，宽字符版本，只完成一次查询操作，返回结果，没有对支付未知等情况做轮询操作。需要客户端自己结合自己的业务逻辑来使用。
NL_orderQueryA 这是一个窄字符版本，功能同上
NL_orderQuerySyncA 这是一个同步的窄字符版本，针对支付未知等情况作了查询操作，轮询时间间隔，次数可以在配置文件里面配置。完成后才会返回结果。
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
    "queryCond":"xxxx"
}

```

## 输出参数



