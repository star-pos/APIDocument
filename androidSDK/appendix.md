# 附录

## 支付渠道列表

| 支付渠道 | 缩写 |
| :--- | :--- |
| 支付宝 | NldPayContant.PayChannel.ALIPAY |
| 微信 | NldPayContant.PayChannel .WXPAY |
| 银联 | NldPayContant.PayChannel .YLPAY |

## 返回码列表

| 返回码 | 错误描述 |
| :--- | :--- |
| NldPayContant.ErrorCode.PARAM\_IS\_NULL | 参数不能为空 |
| NldPayContant.ErrorCode.PARAM\_IS\_ILLEGAL | 传入非法参数 |
| NldPayContant.ErrorCode.SDK\_NOT\_INIT | SDK未初始化 |
| NldPayContant.ErrorCode.PARAM\_MERID\_ERROR | 商户号格式有误 |
| NldPayContant.ErrorCode.PARAM\_TIME\_ERROR | 时间格式有误 |
| NldPayContant.ErrorCode.PARAM\_PAYCHANNEL\_ERROR | 支付渠道有误 |
| NldPayContant.ErrorCode.PARAM\_TRMTYP\_ERROR | 设备类型有误 |
| NldPayContant.ErrorCode.PARAM\_TRMTNO\_ERROR | 设备类型标号格式有误 |
| NldPayContant.ErrorCode.PARAM\_OPRID\_ERROR | 操作员格式有误 |
| NldPayContant.ErrorCode.PARAM\_SUBJECT\_VALUE\_NULL\_ERROR | 标题的值不可以为null |
| NldPayContant.ErrorCode.PARAM\_SELORDERNO\_VALUE\_NULL\_ERROR | 订货订单号的值不能是null |
| NldPayContant.ErrorCode.PARAM\_GOODS\_TAG\_VALUE\_NULL\_ERROR | 优惠信息的值不可以为null |
| NldPayContant.ErrorCode.PARAM\_ATTACH\_VALUE\_NULL\_ERROR | 附加信息的值不可以为null |
| NldPayContant.ErrorCode.PARAM\_LONGITUDE\_VALUE\_NULL\_ERROR | 经度数据格式有误 |
| NldPayContant.ErrorCode.PARAM\_LATUTUDE\_VALUE\_NULL\_ERROR | 纬度数据格式有误 |
| NldPayContant.ErrorCode.GET\_CLIENT\_SIGN\_VALUE\_ERROR | 获取的客户端签名有误 |
| NldPayContant.ErrorCode.RESPONSE\_SIGN\_VALUE\_ERROR | 服务器响应签名有误 |
| NldPayContant.ErrorCode.NET\_IO\_ERROR | 网络异常 |
| NldPayContant.ErrorCode.NET\_SERVER\_ERROR | 服务器异常 |
| NldPayContant.ErrorCode.SERVER\_RETURN\_CODE | 服务器返回code码 |

## 设备类型

| 设备类型名 | 设备类型值 |
| :--- | :--- |
| 智能POS | NldPayConstant.TrmTyp.Type\_P |
| APP扫码 | NldPayConstant.TrmTyp.Type\_A |
| PC端 | NldPayConstant.TrmTyp.Type\_C |
| 台牌扫码 | NldPayConstant.TrmTyp.Type\_T |



