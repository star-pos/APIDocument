# 客户主扫

## 请求地址

```
测试环境请求地址：http://139.196.77.69:8280/adpweb/ehpspos3/sdkBarcodePosPay.json
生产环境请求地址：http://gateway.starpos.com.cn/adpweb/ehpspos3/sdkBarcodePosPay.json
```

## 请求参数

| 元素名称 | 约束 | 类型 | 最大长度 | 描述 | 说明 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| [公共请求参数](/scanAPI/public-parameter.md) |  |  |  |  |  |
| amount | 1 | String | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 1 | String | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| payChannel | 1 | String | Max\(20\) | 支付渠道 | 详见[附录](/scanAPI/appendix.md) |
| subject | 0 | String | Max\(512\) | 订单标题 |  |
| selOrderNo | 0 | String | Max\(50\) | 订单号 | 订货订单号 |
| goods\_tag | 0 | String | Max\(512\) | 订单优惠说明 |  |
| Attach | 0 | String | Max\(512\) | 附加数据 | 附加数据 |

## 返回参数

| 元素名称 | 约束 | 类型 | 最大长度 | 描述 | 说明 |
| :--- | :--- | :--- | :--- | :--- | :---: |
| [公共返回参数](/scanAPI/public-parameter.md) |  |  |  |  |  |
| logNo | 1 | String | Max\(20\) | 系统流水号 | 平台系统流水号 |
| result | 1 | String | Max\(1\) | 交易结查 | S-交易成功          F-交易失败         Z-交易未知 |
| payCode | 0 | String | Max\(256\) | 二维码地址 | 二维码生成地址字符串 |
| orderNo | 1 | String | Max\(64\) | 支付渠道订单号 |  |
| amount | 1 | String | Max\(13\) | 实付金额 | 以分为单位，如1元表示为100 |
| total\_amount | 1 | String | Max\(13\) | 订单总金额 | 以分为单位，如1元表示为100 |
| subject | 0 | String | Max\(512\) | 订单标题 |  |
| selOrderNo | 0 | String | Max\(50\) | 订单号 | 订货订单号 |
| goodsTag | 0 | String | Max\(512\) | 订单优惠说明 |  |
| attach | 0 | String | Max\(512\) | 附加数据 | 附加数据 |



