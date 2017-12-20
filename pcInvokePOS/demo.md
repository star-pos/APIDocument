## 示例

### 请求示例

调起消费（procCd = “000000”），即刷卡支付:

```
{
    "msgTp": "0200",
    "payTp": "0",
    "procTp": "00",
    "procCd": "000000",
    "amt": "0.01",
    "orderNo": "201712011721520"
}
```

### 返回示例

调起消费后，交易失败：

```
{
    "msgTp": "0210",
    "code": "-1",
    "message": "该功能尚未开通"
}
```

调起消费后，交易成功：

```
{
    "msgTp": "0210",
    "code": "0",
    "message": "交易成功",
    "payTp": "0",
    "timeStamp": "20171201180213",
    "merName": "上海市隆力奇蛇油世博店",
    "merId": "888888888888888",
    "termId": "88888888",
    "batchNo": "000119",
    "traceNo": "000044",
    "transDate": "20171201",
    "transTime": "180213",
    "transAmount": "0.01",
    "operator": "001",
    "referNo": "120100141223",
    "acqNo": "48570000",
    "iisNo": "建设银行",
    "expDate": "0000",
    "cardNo": "621700*********6354",
    "cardType": "00"
}
```



