# 注意事项



* retCode格式为int，样例如下：

```
"retCode":0
"retCode":-2
```



* 标记为\(可选\)的项目，可能不存在，或者有值为null或者""，样例如下：

```
"orderTitle":null,
"orderNo":“”,
"discountComment":null,

注：这里"attachment"不存在
```

* 所有的金额相关的参数都是以分为单位的正整数形式，如1元表示为100

* 除了orderTitle，discountComment，attachment三项以外输入参数不允许有空格存在





_**业务相关**_

在返回交易未知的情况，建议用户在调用一次同步的查询接口，来确认一下交易结果。

考虑到网络因素，后台同步因素等极端情况下仍然会有交易未知的情况，建议用户保留详细信息备查。

重要更新：从2.0.0版本开始，不兼容之前的SDK接口，增加了输入参数merchantTradeSN。该参数由调用者输入，并且要保证在商户端不重复，可用于查询。



