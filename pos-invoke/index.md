# 收单应用调用

开发者开发应用程序，并上架于星POS的应用商城时需要接通支付通道，这时通过本接口实现。

主要是通过传入不同的参数调用到对应的支付界面。

## 交易类

| **域内容** | **数据类型** | **键（KEY）** | **请求值\(VALUE\)** | **返回值\(VALUE\)** | **备注** |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 报文类型 | String | msg\_tp | 0200 | 0210 | 固定值，只区分请求和应答． |
| 支付方式 | String | pay\_tp | “”-不限  0-银行卡  1-扫码  11-微信支付  12-支付宝支付 | 0-银行卡  1-微信  2-支付宝 | 用于第三方调用时指定支付渠道；可为空；不为空时要与交易处理码（proc\_cd）保持一致，例如：660000与1是一致的。（是否生效以交易商终开通的收款产品为准）\* |
| 交易类型 | String | proc\_tp | 00－消费类 |  | 考虑到各行业的不同需求，预留了交易类型域．一般都只填00 |
| 交易处理码 | String | proc\_cd | [交易处理码](#交易处理码) |  | 必填项非消费/扫码支付交易处理码，以该字段传入值为准调用交易；反之，则以传入的支付方式字段为准调用交易； |
| 凭证号 | String | systraceno | 非必填 |  | 消费撤销时，传入做撤销 |
| 交易金额 | String | amt | 消费、预授权、扫码支付时必填示例：100.01 |  | 用法一：消费、预授权、扫码支付传入交易金额用法二：扫码退货如该字段传入值为空，则默认全额退款。 |
| 订单号 | String | order\_no | 非必填第三方传入的订单号 | 与传过来的一致 | 用法一：消费、扫码支付时作为订单号传入做交易用法二：扫码撤销时与批次流水号任选其一传入做撤销（两者都不传入或无之前使用该订单号的本地交易数据，则调起收单扫码撤销页面） |
| 批次流水号 | String | batchbillno | 非必填第三方传入的批次号+流水号\(凭证号\) | 与传过来的一致 | 扫码撤销时与批次流水号任选其一传入做撤销（两者都不传入则调起收单扫码撤销页面） |
| 应用包名 | String | appid |  |  | 调用者应用包名 |
| 交易时间戳 | String | time\_stamp |  | 交易成功返回交易时间 | YYYYMMDDhhmmss |
| 打印信息 | String | print\_info | 非必填 |  | 行业应用需要打印的备注信息\(100汉字以内） |
| 失败原因 | String | reason |  |  | 仅在调用返回失败时存在 |
| 交易详情 | String | txndetail |  | 交易详情 | json字符串（结构参照附录B） |
| 银行卡类型 | String | cardtype |  | 00:借记卡 01:贷记卡  02:准贷记卡  03:预付卡  04:其他 | 该字段仅在返回数据中，请求数据不需要 |
| 原交易凭证号 | String | sysoldtraceno |  |  | 该字段仅在返回数据中，请求数据不需要 |
| 原交易参考号 | String | sysoldreferno |  |  | 该字段仅在返回数据中，请求数据不需要 |
| 原交易日期 | String | sysolddate |  |  | 该字段仅在返回数据中，请求数据不需要 |
| 操作员 | String | oprId |  |  | 该字段仅在返回数据中，请求数据不需要 |

## 查询类

| **域内容** | **数据类型** | **键（KEY）** | **请求值\(VALUE\)** | **返回值\(VALUE\)** | **备注** |
| :--- | :--- | :--- | :---: | :--- | :--- |
| 报文类型 | String | msg\_tp | 0300 | 0310 | 固定值，只区分请求和应答． |
| 支付方式 | String | pay\_tp | 0－银行卡 \| 1-扫码 \| 2-商户信息 |  |  |
| 订单号 | String | order\_no | 第三方传入的订单号 | 与传过来的一致 | 用作订单查询 |
| 批次流水号 | String | batchbillno | 第三方传入的批次号+流水号\(凭证号\) | 与传过来的一致 |  |
| 应用包名 | String | appid |  |  | 调用者应用包名 |
| 失败原因 | String | reason |  |  | 仅在调用返回失败时存在 |
| 交易详情 | String | txndetail |  | 交易详情 | json字符串（结构参照附录B） |

## 调用样例

### 调用者启用收单支付应用支付功能组件

```
try {
    ComponentName component = new ComponentName("com.newland.caishen", "com.newland.caishen.ui.activity.MainActivity");
    Intent intent = new Intent();
    intent.setComponent(component);

    Bundle bundle = new Bundle();
    bundle.putString("msg_tp",  "0200");
    bundle.putString("pay_tp",  "0");
    bundle.putString("proc_tp",  "00");
    bundle.putString("proc_cd", "000000");
    bundle.putString("amt",     "100.01");
    bundle.putString("order_no",     "xxxxxxxxxxx");
    bundle.putString("appid",     "com.nld.trafficmanage");
    bundle.putString("time_stamp", "20150930035201");
    bundle.putString("print_info", "订单商品明细单价等xxxxxx");
    intent.putExtras(bundle);
    this.startActivityForResult(intent, 1);
} catch(ActivityNotFoundException e) {
    //TODO:
} catch(Exception e) {
    //TODO:
}
```

### 调用者处理支付功能组件返回结果

```
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);
Bundle bundle = data.getExtras();
if (requestCode == 1&&bundle != null) {
switch (resultCode) {
 // 支付成功
  case Activity.RESULT_OK:
       String msgTp = bundle.getString("msg_tp");
   if (TextUtils.equals(msgTp, "0210")) {
   // TODO: 
 }
    break;
// 支付取消
 case Activity.RESULT_CANCELED:
 String reason = bundle.getString("reason");
if (reason != null) {
 // TODO:
}
break;

        default:
        // TODO:
    break;
        }
}
}
```

## 附录

### 交易详情JSON结构

| **字段** | **字段类型** | **字段名称** | **备注** |
| :--- | :---: | :--- | :--- |
| mername | String | 商户名称 | 交易类和查询类交易返回 |
| merid | String | 商户号 | 交易类和查询类交易返回 |
| termid | String | 终端号 | 交易类和查询类交易返回 |
| acqno | String | 收单行 |  |
| iisno | String | 发卡行 |  |
| expdate | String | 有效期 |  |
| batchno | String | 批次号 |  |
| systraceno | String | 凭证号 |  |
| authcode | String | 授权号 |  |
| orderid\_scan | String | 订单号 |  |
| translocaltime | String | 交易时间 |  |
| translocaldate | String | 交易日期 |  |
| transamount | String | 交易金额 |  |
| priaccount | String | 卡号 |  |
| refernumber | String | 系统参考号 |  |
| pay\_tp | String | 交易类型 | 查询类交易返回 |

### 交易处理码 {#交易处理码}

000000-消费, 200000-消费撤销, 300000-预授权, 330000-预授权完成, 400000-预授权撤销, 440000-预授权完成撤销, 500000-联机退货, 660000-扫码支付, 680000-扫码撤销, 700000-扫码补单, 900000-结算
