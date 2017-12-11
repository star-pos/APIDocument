# 微信公众号支付

## 流程图![](/assets/doc-pic4-9.png)

_**Tips:**_

> 必须先配置商户的微信公众号之后才能调试接口

> 软件合作商需单独申请公众号关注需提供：
>
> 营业执照，对公账户的开户许可证照片（彩色，清晰）。
>
> 进行开户，微信会进行打款验证，到时请软件合作商告知实际打款金额，完成相关验证。
>
> 同时银行接口支持公众号推荐以及公众号支付，新增以下参数：
>
> * 公众号APPID
> * 公众号APPIDKey
> * 推荐关注公众号
> * 支付授权目录\(必须是https\)

> 前期请审慎申请，若渠道非法交易过多，将会导致整个通道被关停等恶劣后果



> 调用微信公众号支付流程
>
> 1. 调用微信公众号查询\(pubSigQry\)接口获取appId和appIdKey
> 2. 通过查询到的appId,使用微信官方接口获取授权code
>    [详细code生成地址](https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842)
> 3. 通过code，使用微信公众号支付\(pubSigPay\)接口

## 公众号查询

### 请求地址

```
http://gateway.starpos.com.cn/adpweb/ehpspos3/pubSigQry.json
```

### 请求参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| orgNo | 1 | String | Max\(15\) | 机构号 |  |
| mercId | 1 | String | Max\(15\) | 商户号 |  |
| trmNo | 1 | String | Max\(8\) | 设备号 | 长度8位数字，进件生成终端号 |
| txnTime | 1 | String | Max\(14\) | 设备端交易时间 | 如：20170527153245 |
| signType | 1 | String | Max\(6\) | 签名方式 | MD5 |
| signValue | 1 | String | Max\(64\) | 签名域 | 详见[安全规范-数字签名](/scanAPI/safety-standard.md) |
| attach | 0 | String | Max\(256\) | 附加字段 | 版本号需上送V1.0.1 |
| version | 1 | String | Max\(10\) | 版本号 | 默认V1.0.0 |

### 返回参数

| **元素名称** | **约束** | **类型** | **最大长度** | **描述** | **说明** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| returnCode | 1 | String | Max\(10\) | 返回码 | 6位（返回时必输）000000表示成功 |
| sysTime | 1 | String | Max\(14\) | 系统交易时间 | 如：20170527153245 |
| message | 1 | String | Max\(100\) | 返回信息 |  |
| mercId | 1 | String | Max\(15\) | 商户号 |  |
| signValue | 1 | String | Max\(64\) | 签名域 | 详见[安全规范-数字签名](/scanAPI/safety-standard.md) |
| appId | 1 | String | Max\(32\) | 微信公众账号 |  |
| appIdKey | 1 | String | Max\(128\) | 微信公众号密钥 |  |
| attach | 0 | String | Max\(256\) | 附加字段 | 版本号需上送V1.0.1 |

## 公众号支付

### 请求地址

```
http://gateway.starpos.com.cn/adpweb/ehpspos3/pubSigPay.json
```

### 请求参数

| 元素名称 | 约束 | 类型 | 最大长度 | 描述 | 说明 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| orgNo | 1 | String | Max\(15\) | 机构号 |  |
| mercId | 1 | String | Max\(15\) | 商户号 |  |
| trmNo | 1 | String | Max\(8\) | 设备号 | 长度8位数字，进件生成终端号 |
| txnTime | 1 | String | Max\(14\) | 设备端交易时间 | 如：20170527153245 |
| version | 1 | String | Max\(10\) | 版本号 | 默认V1.0.0 |
| code | 1 | String | Max\(13\) | 授权code | 在授权回调页面中获取到的授权code |
| amount | 1 | String | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 1 | String | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| subject | 0 | String | Max\(256\) | 订单标题 |  |
| selOrderNo | 0 | String | Max\(50\) | 订单号 | 订货订单号 |
| goods\_tag | 0 | String | Max\(250\) | 订单优惠说明 |  |
| attach | 0 | String | Max\(256\) | 附加字段 | 版本号需上送V1.0.1 |

### 返回参数

| returnCode | 1 | String | Max\(10\) | 返回码 | 6位（返回时必输）000000表示成功 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| sysTime | 1 | String | Max\(14\) | 系统交易时间 | 如：20170527153245 |
| message | 1 | String | Max\(100\) | 返回信息 |  |
| mercId | 1 | String | Max\(15\) | 商户号 |  |
| logNo | 1 | String | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | String | Max\(1\) | 交易结查 | A-等待授权Z-交易未知 |
| orderNo | 1 | String | Max\(64\) | 支付渠道订单号 | 与用户支付订单中条码一致，可用于退货； |
| amount | 1 | String | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 1 | String | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| PrepayId | 1 | String | Max\(64\) | 预支付 ID |  |
| apiAppid | 1 | String | Max\(32\) | 支付公众号 ID |  |
| apiTimestamp | 1 | String | Max\(32\) | 支付时间戳 |  |
| apiNoncestr | 1 | String | Max\(32\) | 支付随机字符串 |  |
| apiPackage | 1 | String | Max\(128\) | 订单详情扩展字符串 |  |
| apiSigntype | 1 | String | Max\(32\) | 签名方式 |  |
| apiPaysign | 1 | String | Max\(64\) | 签名 |  |
| subject | 0 | String | Max\(256\) | 订单标题 |  |
| selOrderNo | 0 | String | Max\(50\) | 订单号 | 订货订单号 |
| goodsTag | 0 | String | Max\(250\) | 订单优惠说明 |  |
| attach | 0 | String | Max\(256\) | 附加字段 | 版本号需上送V1.0.1 |



