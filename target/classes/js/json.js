var admincolumns = [{
    checkbox: true
},{
    field: 'loginname',
    title: '登录名',
}, {
    field: 'password',
    title: '密码',
    visible: false,
}, {
    field: 'name',
    title: '姓名',
}, {
	field: 'createdate',
	title: '创建日期',
	valign:'middle'
},{
    field: 'phonenumber',
    title: '邮箱'
}, {
    field: 'identity',
    title: '身份',
    visible: false,
}, {
    field: 'identity',
    title: '身份',
    formatter: formatter
}];

var customercolumns = [{
    checkbox: true
}, {
    field: 'cnum',
    title: '客户编号',
    visible: false,
}, {
    field: 'cname',
    title: '姓名',
}, {
    field: 'cnumber',
    title: '手机号'
}, {
    field: 'caddr',
    title: '籍贯'
}, {
    field: 'createdate',
    title: '创建日期'
}, {
    field: 'cemail',
    title: '邮箱'
}, {
    field: 'crank',
    title: '级别'
}];

var suppliercolumns = [{
    checkbox: true
},  {
    field: 'snum',
    title: '供应商编号',
    visible: false,
}, {
    field: 'sname',
    title: '名字'
}, {
    field: 'saddr',
    title: '所在地址'
}, {
    field: 'createdate',
    title: '创建日期'
}, {
    field: 'snumber',
    title: '联系电话'
}];

var productcolumns = [{
	checkbox: true
}, {
	field: 'pnum',
	title: '产品编号',
    visible: false
}, {
	field: 'pname',
	title: '产品名字'
}, {
	field: 'sid',
	title: '供应商姓名',
//	visible: false
}, {
	field: 'pprice',
	title: '售价'
}, {
	field: 'createdate',
	title: '出售日期'
}, {
	field: 'pnumber',
	title: '销量'
}];
//活动表格
var activitycolumns = [{
	checkbox: true
}, {
	field: 'aitem',
	title: '活动'
}, {
	field: 'adetail',
	title: '活动细则'
}, {
	field: 'createdate',
	title: '活动日期',
	
}, {
	field: 'uid',
	title: 'Uid'
}, {
	field: 'cus',
	title: '参加人员'
}];
//服务信息表格
var feedbackcolumns = [{
	checkbox: true
}, {
	field: 'pid',
	title: '编号',
    visible: false
}, {
	field: 'fitem',
	title: '产品问题'
}, {
	field: 'cid',
	title: 'cid',
//	visible: false
}, {
	field: 'uid',
	title: 'uid',
//	visible: false
}, {
	field: 'createtime',
	title: '服务日期'
}, {
	field: 'period',
	title: '服务信息'
}];

function formatter(value, row, index) {
    if (row.identity == 1)
        return "超级管理员";
    if (row.identity == 2)
        return "普通管理员";
}