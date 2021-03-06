# 附录

## MCC查询返回格式

```
返回参数格式 （mcc的返回）
{  "msg_cd": "000000", "msg_dat": "成功", "REC": [
        {
            "mcc_cd": "1520",
            "mcc_nm": "一般承包商－住宅与商业楼",
            "sup_mcc_cd": "2",
            "sup_mcc_nm": "房产汽车类",
            "mcc_typ": "07",
            "mcc_typ_nm": "房地产类"
        }
    ]
}
```

## 进件流程说明

![](/assets/mercRegistFlow.png)

### 查询

商户查询：查询商户的审核结果

Mcc查询：商户进件的时候商户类型（mcc码）

区域码查询：商户进件的时候商户归属的省市区域码

支行模糊查询：商户进件的时候选择开户行的银行

### 商户进件

商户进件—上传图片—商户提交

### 商户资料修改

商户修改申请—商户资料修改—（有图片修改调用图片上传接口）商户提交

### 新增门店

商户修改申请—门店新增—上传图片—商户提交

### 新增产品

商户修改申请—新增产品—上传图片—商户提交

### 商户进件过程中修改商户资料（此时商户状态为修改）

商户进件—商户资料修改/门店新增—上传图片—商户提交

### 驳回修改

商户审核结果为驳回时——商户资料修改—图片—商户提交

### 商户提交

提交走自动审核，返回审核结果（1-通过 2-驳回 3-转人工）

### 



