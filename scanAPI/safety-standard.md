# 安全规范

## 数字签名

为保证数据传输过程中的数据真实性，完整性和不可抵赖，我们需要对数据进行数字签名，在接收签名数据之后迚行签名校验。签名算法分为MD5

签名机制如下：

* 签名字段不参与组成签名原文串。
* 待签名原文是请求参数按参数名字母小写后进行升序排列,对应参数值拼装成的字符串
* 如果提交的参数为{apam:value1, cpam:value2, Bpam:value3}
* 密钥key值为AFDFAASDASDAS
* 则待签名原文为：value1value3value2AFDFAASDASDAS

## 请求范例

请求数据:

```
{
"amount":"1",
"authCode":"130219205322723729",
"characterSet":"00",
"mercId":"800290000000441",
"opSys":"3",
"orgNo":"489",
"payChannel":"WXPAY",
"signType":"MD5",
"total_amount":"1",
"tradeNo":"20170804103115431251",
"trmNo":"95006888",
"txnTime":"20170804103115",
"version":"V1.0.0",
"signValue":""
}
```

设备key：Pz5meIuUxRKcF7rlvPglliyfwvC9vhjGcBy61WHM00Qfwz0E6yTTLwgxJsFYE9IQ

排序后数据：

1130219205322723729008002900000004413489WXPAYMD51201708041031154312519500688820170804103115V1.0.0Pz5meIuUxRKcF7rlvPglliyfwvC9vhjGcBy61WHM00Qfwz0E6yTTLwgxJsFYE9IQ

_注意 参数名小写排序，参数值不用小写，设备key不需小写，signvalue值为小写，排完序后去除所有空格_

signValue值--MD5加签后数据：a8fda4082fbdd3e3ff679097cd4fae72

