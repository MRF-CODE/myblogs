#### 监控文本框内容改变

```
$(function(){
    //监听input
    $('#CONFIRMEDINCOME').bind('input propertychange', function() {
    	// ...
    });
})
```

#### 保存前事件

```
formSave(isTransact)
```

#### 获取表单字段值

```
ui("NOWINVOICEAMOUNT")
```

#### 表单字段赋值

```
ui("NOWINVOICEAMOUNT"，"value")
```

#### 自定义弹出页面

```
var dlg = FrmDialog.open({
            width: 1000,
            height: 600,
            url: "./w?sid=@sid&cmd=com.awspaas.user.apps.customermanagement_toCustomerFromSkyPage",
            data: {crname:crname, type:type},
        });
```

#### AJAX访问后台

```
awsui.ajax.request({
            type: "POST",
            url: "./jd?sid=@sid&cmd=com.awspaas.user.apps.contract.manage_getLegalPerson",
            data: "uid=" + jsonVal['SALESMANID'],
            async: false,
            ok: function (r) {
                let dept = r.data;
                $("#OURMAINID").val(dept.DEPARTMENTNO);
                $("#OURMAIN").val(dept.DEPARTMENTNAME);
                bwb = dept.BWB;
            },
            err: function (r) {
            }
        });
```

