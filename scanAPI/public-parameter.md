# 公共参数

## 公共请求参数头 {#公共请求参数头}

| 元素名称 | 约束 | 类型 | 最大长度 | 描述 | 说明 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| opSys | 1 | String | Max\(1\) | 操作系统 | 0:Android SDK  1:iOS SDK         2:windows SDK 3:直连 |
| characterSet | 1 | String | Max\(2\) | 字符集 | 默认00-GBK,01-UTF-8 |
| latitude | 0 | String | Max\(15\) | 经纬度 |  |
| longitude | 0 | String | Max\(15\) | 经度值 |  |
| orgNo | 1 | String | Max\(15\) | 机构号 |  |
| mercId | 1 | String | Max\(15\) | 商户号 |  |
| trmNo | 1 | String | Max\(8\) | 设备号 | 长度8位数字，进件生成终端号 |
| oprId | 0 | String | Max\(6\) | 操作员号 |  |
| trmTyp | 0 | String | Max\(2\) | 设备类型 | P-智能POS A- app扫码 C-PC端 T-台牌扫码 |
| tradeNo | 1 | String | Max\(64\) | 商户单号 | 在商户端不重复 |
| txnTime | 1 | String | Max\(14\) | 设备端交易时间 | 如：20170527153245 |
| signType | 1 | String | Max\(6\) | 签名方式 | MD5 |
| signValue | 1 | String | Max\(64\) | 签名域 | 详见[安全规范-数字签名](/scanAPI/safety-standard.md) |
| addField | 0 | String | Max\(256\) | 附加字段 | 版本号需上送V1.0.1 |
| version | 1 | String | Max\(10\) | 版本号 | 默认V1.0.0 |

## 公共返回参数头 {#公共返回参数头}

| 元素名称 | 约束 | 类型 | 最大长度 | 描述 | 说明 |
| :--- | :--- | :--- | :--- | :--- | :--- |
| tradeNo | 1 | String | Max\(64\) | 商户单号 | 在商户端不重复 |
| returnCode | 1 | String | Max\(10\) | 返回码 | 6位（返回时必输）000000表示成功 |
| sysTime | 1 | String | Max\(14\) | 系统交易时间 | 如：20170527153245 |
| message | 1 | String | Max\(100\) | 返回信息 |  |
| mercId | 1 | String | Max\(15\) | 商户号 |  |
| signValue | 1 | String | Max\(64\) | 签名域 | 详见[安全规范-数字签名](/scanAPI/safety-standard.md) |
| addField | 0 | String | Max\(256\) | 附加字段 | 版本号需上送V1.0.1 |



