# 公共参数

公共参数是每个接口请求的时候都要传的，在SDK中把请求的公共参数封装在一个model中，即PaySDKModel

## 公共请求参数

| 元素名称 | 约束 | 类型 | 描述\(最大长度\) | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| latitude | 0 | String | 纬度值Max\(15\) |  |
| longitude | 0 | String | 经度值Max\(15\) |  |
| orgNo | 1 | String | 机构号Max\(15\) |  |
| mercId | 1 | String | 商户号Max\(15\) |  |
| trmNo | 1 | String | 设备号Max\(8\) |  |
| optId | 0 | String | 操作员号Max\(6\) |  |
| trmTyp | 0 | String | 设备类型 | 详情[附录](/iosSDK/appendix.md) |
| tradeNo | 1 | String | 商户单号Max\(64\) | 在商户端不重复\(说明建议使用规则：设备号+0+当前毫秒时间戳\) |

## 公共返回参数

| 元素名称 | 约束 | 类型 | 描述 | 备注 |
| :--- | :--- | :--- | :--- | :--- |
| tradeNo | 1 | String | 商户单号 | 在商户端不重复 |
| sysTime | 1 | String | 系统交易时间号 | 如：20170527153245 |
| message | 1 | String | 返回信息 |  |
| mercId | 1 | String | 商户号 |  |



