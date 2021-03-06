# 接口说明

## 名词解析

| 名词 | 含义 |
| :--- | :--- |
| 商户主扫 | 商户扫描客户的付款二维码进行收款 |
| 客户主扫 | 客户扫描商家生产的二维码付款 |
| 退款 | 支付成功的订单才能进行退款 |
| 支付渠道订单号 | 支付宝微信返回的单号 |

## 通讯协议

| 传输方式 | 通讯采用HTTP方式 |
| :---: | :--- |
| 提交方式 | 采用POST请求 |
| 字符编码 | 请求交易报文中的编码方式为GBK |
| 报文格式 | 以json做为数据传输格式 注:“Content-Type","application/json” |
| 签名算法 | MD5,详情参考[安全规范](/scanAPI/safety-standard.md) |

## 接口约束

交易报文中的编码方式为GBK。对元素约束（出现次数）的表示方法请参见下表。

| 符号 | 含义 |
| :---: | :--- |
| ? | 0或1，可选项。 |
| \* | 0~n，可以没有，也可以有多项。 |
| + | 1~n，至少有1项，也可以有多项。 |
| 1 | 数字1，代表必须且只能填1项。 |

* 文档表格定义的字段，请准确写入请求参数中。
* 交易中某字段内容为空，请将节点写入，保证请求参数的完整性。



