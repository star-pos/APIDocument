# 示例代码

## 初始化key

```
//初始化sdk
NldPaySDK.getInstance().init(SECRET_KEY);
其中SECRET_KEY为进件审核通过过的商户密钥
```

## 商户主扫

```
String latitude=""; //纬度值
String longitude=""; //经度值
String orgNo=""; //机构号
String mercId=""; //商户号
String trmNo=""; //设备号 进件生成的终端号
String oprId=""; //操作员号
String trmTyp= NldPayConstant.TrmTyp.TYPE_A; //设备类型
String amount=""; // 实付金额
String total_amount=""; //订单总金额
String authCode=""; //设备读取用户二维码信息
String payChannel=NldPayConstant.PayChannel.WEICHAT; //支付渠道
String subject=""; //订单标题
String selOrderNo=""; //订单号
String goods_tag=""; //订单优惠说明
String attach=""; //附加数据
String txnTime=""; //设备端交易时间
NldPhonePay nldPhonePay= new NldPhonePay( latitude, longitude, orgNo, mercId, trmNo, oprId, trmTyp, amount, total_amount, authCode, payChannel, subject, selOrderNo, goods_tag, attach, txnTime);
try {
NldPaySDK.getInstance().requestPhonePay(nldPhonePay, new OnResultListener() {
@Override
public void onSuccess(NldPhoneResult nldPhoneResult) {
//nldPhoneResult为返回的结果，在此处处理业务逻辑
}
@Override
public void onFailure(int errorCode, String errorMessage) {
//返回参数为错误码和错误信息,在此处处理业务逻辑
}
});
}catch (NewPayRuntimeException e)
{
//异常捕获处理
}
```

## 客户主扫

```
        String latitude=""; //纬度值
        String longitude=""; //经度值
        String orgNo=""; //机构号
        String mercId=""; //商户号
        String trmNo=""; //设备号 进件生成的终端号
        String oprId=""; //操作员号
        String trmTyp= NldPayConstant.TrmTyp.TYPE_A; //设备类型
        String amount=""; // 实付金额
        String total_amount=""; //订单总金额
        String payChannel=NldPayConstant.PayChannel.WEICHAT; //支付渠道
        String subject=""; //订单标题
        String selOrderNo=""; //订单号
        String goods_tag=""; //订单优惠说明
        String attach=""; //附加数据
        String txnTime=""; //设备端交易时间

        NldPosPay nldPosPay=new NldPosPay(latitude, longitude, orgNo, mercId, trmNo, oprId, trmTyp, payChannel, amount, total_amount, subject, selOrderNo, goods_tag, attach, txnTime);

        try {
            NldPaySDK.getInstance().requestPosPay(nldPosPay, new OnResultListener<NldPosResult>() {
                @Override
                public void onSuccess(NldPosResult nldPosResult) {
                    //nldPosResult为返回的结果，在此处处理业务逻辑
//将 nldPosResult.payCode(商户的二维码Code)转换为二维码
                }

                @Override
                public void onFailure(int errorCode, String errorMessage) {
                    //返回参数为错误码和错误信息,在此处处理业务逻辑
                }
            });
        }
        catch (NewPayRuntimeException e)
        {
            //异常捕获处理
        }
```

## 退款

```
String latitude=""; //纬度值
String longitude=""; //经度值
String orgNo=""; //机构号
String mercId=""; //商户号
String trmNo=""; //设备号 进件生成的终端号
String oprId=""; //操作员号
String trmTyp= NldPayConstant.TrmTyp.TYPE_A; //设备类型
String txnTime=""; //设备端交易时间
String orderNo=""; //支付渠道订单号
String txnAmt=""; //退款金额
try {
NldRefundPay nldRefundPay=new NldRefundPay(latitude, longitude, orgNo, mercId, trmNo, oprId, trmTyp, orderNo, txnAmt, txnTime);
NldPaySDK.getInstance().requestRefundPay(nldRefundPay, new OnResultListener() {
@Override
public void onSuccess(NldRefundResult nldRefundResult) {
//nldRefundResult即为返回结果，在此处理业务逻辑
}
@Override
public void onFailure(int errorCode, String errorMessage) {
//返回参数为错误码和错误信息,在此处处理业务逻辑
}
});
}catch (NewPayRuntimeException e)
{
//异常捕获处理
}
```

## 订单查询

```
String latitude=""; //纬度值
String longitude=""; //经度值
String orgNo=""; //机构号
String mercId=""; //商户号
String trmNo=""; //设备号 进件生成的终端号
String oprId=""; //操作员号
String trmTyp= NldPayConstant.TrmTyp.TYPE_A; //设备类型
String txnTime=""; //设备端交易时间
String qryNo=""; //要查询的订单号
try {
NldQueryPay nldQueryPay = new NldQueryPay(latitude, longitude, orgNo, mercId, trmNo, oprId, trmTyp, qryNo, txnTime);
NldPaySDK.getInstance().requestQueryPay(nldQueryPay, new OnResultListener() {
@Override
public void onSuccess(NldQueryResult nldQueryResult) {
//nldQueryResult即为返回结果，在此处理业务逻辑
}
@Override
public void onFailure(int errorCode, String errorMessage) {
//返回参数为错误码和错误信息,在此处处理业务逻辑
}
});
}catch (NewPayRuntimeException e)
{
//异常捕获处理
}
```

## 轮询

```
String latitude=""; //纬度值
String longitude=""; //经度值
String orgNo=""; //机构号
String mercId=""; //商户号
String trmNo=""; //设备号 进件生成的终端号
String oprId=""; //操作员号
String trmTyp= NldPayConstant.TrmTyp.TYPE_A; //设备类型
String txnTime=""; //设备端交易时间
String qryNo=""; //要查询的订单号
try {
NldQueryPay nldQueryPay = new NldQueryPay(latitude, longitude, orgNo, mercId, trmNo, oprId, trmTyp, qryNo, txnTime);
NldPaySDK.getInstance().requestRollQueryPay(nldQueryPay, new OnResultListener() {
@Override
public void onSuccess(NldQueryResult nldQueryResult) {
//nldQueryResult即为返回结果，在此处理业务逻辑
}
@Override
public void onFailure(int errorCode, String errorMessage) {
//返回参数为错误码和错误信息,在此处处理业务逻辑
}
});
}catch (NewPayRuntimeException e)
{
//异常捕获处理
}
```

## 撤单接口

```
public void rollQuery(View view){
        queryPay = new NldQueryPay("31.22", "121.48", "2",
                "800126000000021", "95005833", "000001",
                NldPayConstant.TrmTyp.TYPE_P, "9500583301498723610844", System.currentTimeMillis()+"",
                "800126000000021"+0+System.currentTimeMillis());
        try {
            NldPaySDK.getInstance().requestQueryPay(queryPay, new OnResultListener<NldQueryResult>() {
                @Override
                public void onSuccess(NldQueryResult nldQueryResult) {
                    showResultMessage("网络请求成功：" + new Gson().toJson(nldQueryResult));

                }

                @Override
                public void onFailure(int errorCode, String errorMessage) {
                    showResultMessage("网络请求失败：" + errorCode + " --- " + errorMessage);
                }
            });
        } catch (NewPayRuntimeException e) {
            showResultMessage("异常原因==》" + e.getMessage());

        }
    }
```

## 设置日志输出

```
在应用程序入口处添加以下代码
//设置debug模式 是否打印log
NldPaySDK.getInstance().setDebugModule(true);
```



