window.onload = function() {
	$(function() {
		AdjustHeight();
		$('#asdasd').editable({
			type : "text", // 编辑框的类型。支持text|textarea|select|date|checklist等
			title : "用户名", // 编辑框的标题
			disabled : false, // 是否禁用编辑
			emptytext : "空文本", // 空值的默认文本
			mode : "popup", // 编辑框的模式：支持popup和inline两种模式，默认是popup
			validate : function(value) { // 字段验证
				if (!$.trim(value)) {
					return '不能为空';
				}
			}
		});
	});

	$(window).resize(function() {
		AdjustHeight();
	});

	function AdjustHeight() {
		var head = $('.head').height();
		var content = document.documentElement.clientHeight;

		$('.leftNav').css("height", parseInt(content) - parseInt(head));
		$('.context').css("height", parseInt(content) - parseInt(head));
	}

	// 初始化表格
	$('#adminTable').bootstrapTable(
			{
				columns : admincolumns,
				// editable: true, //是否开启编辑模式
				ajax : ajaxRequest,
				method : 'GET',
				showPaginationSwitch : true,
				sidePagination : 'client',
				search : true, // ******开启搜索框****//
				searchOnEnterKey : false, // ******回车后执行搜索****//
				pagination : true,// 开启分页
				clickToSelect : true,
				pageNumber : 1, // 当前地基页
				pageSize : 10, // 每页显示数据条数
				mode : "popup",
				smartDisplay : true,
				showExport : true, // 是否显示导出
				exportDataType : "basic",
				striped : true, // 是否显示行间隔色
				pageList : "[10, 20]",
				showRefresh : true,
				toolbar : "#toolbar",
				showToggle : true, // 是否显示详细视图和列表视图
				iconSize : 'outline',
				paginationPreText : "<",
				paginationNextText : ">",
				paginationFirstText : "First",
				paginationLastText : "Last",
				showColumns : true,
				detailView : false, // 是否显示父子表
				locale : "zh-CN",
				paginationHAlign : "left",
				paginationDetailHAlign : "right",
				trimOnSearch : true,
				// 这里设置表头样式
				theadClasses : "thead-dark",// 这里设置表头样式
				rowAttributes : function(row, index) {
					return {
						'data-toggle' : 'popover',
						'data-placement' : 'bottom',
						'data-trigger' : 'hover',
						'data-index' : index,
						'title' : [ 'Index: ' + index,
						// 'ID: ' + row.ProductName,
						'登录名:  ' + row.loginname, '密码:  ' + row.password,
								'姓名:  ' + row.name, '手机号:  ' + row.phonenumber,
								'身份:  ' + row.identity ].join(', ')
					}
				},
			});

	setTimeout(function() {
		console.log("执行了延时函数...");
		$('#customerClick').click(
				function() {
					$('#tableCustomer').bootstrapTable("destroy");
					$('#tableCustomer').bootstrapTable(
							{
								columns : customercolumns,
								toolbar : '#toolbarCustomer',
								showPaginationSwitch : true,
								// url: "json/demo1.json",
								ajax : ajaxCustomer,
								method : 'GET', // 数据请求方式
								sidePagination : 'client',// 设置服务器端分页*********************
								search : true, // ******开启搜索框****//
								searchOnEnterKey : false, // ******回车后执行搜索****//
								pagination : true,// 开启分页
								pageNumber : 1, // 当前地基页
								pageSize : 10, // 每页显示数据条数
								striped : true, // 是否显示行间隔色
								pageList : "[10, 20]",
								showRefresh : true,
								showToggle : true, // 是否显示详细视图和列表视图
								iconSize : 'outline',
								paginationPreText : "<",
								paginationNextText : ">",
								paginationFirstText : "First",
								paginationLastText : "Last",
								showColumns : true,
								detailView : false, // 是否显示父子表
								locale : "zh-CN",
								paginationHAlign : "left",
								paginationDetailHAlign : "right",
								trimOnSearch : true,
								// 这里设置表头样式
								theadClasses : "thead-dark",
								rowAttributes : function(row, index) {
									return {
										'data-toggle' : 'popover',
										'data-placement' : 'bottom',
										'data-trigger' : 'hover',
										'data-index' : index,
										'title' : [ 'Index: ' + index,
												'客户编号:  ' + row.Cnum,
												'姓名:  ' + row.Cname,
												'手机号:  ' + row.Cnumber,
												'籍贯:  ' + row.Caddr,
												'创建日期:  ' + row.createDate,
												'邮箱:  ' + row.Cemail,
												'级别:  ' + row.Crank ]
												.join(', ')
									}
								}
							});
				});
	}, 20);
	$('#supplierClick').click(function() {
		console.log("supplier...");
		// $('#tableSupplier').bootstrapTable("destroy");
		$("#tableSupplier").bootstrapTable($.tableSupplier);
	});

	$('#productClick').click(function() {
		console.log("procuct...");
		$("#tableProduct").bootstrapTable($.tableProduct);
	});

	$('#activityClick').click(function() {
		console.log("activity...");
		$("#tableActivity").bootstrapTable($.tabbleActivity);
	});

	$('#feedbackClick').click(function() {
		console.log("feedback...");
		$("#tableFeedback").bootstrapTable($.tabbleFeedback);
	});

	// 提交事件
	$(document).on(
			'click',
			'#commit',
			function() {
				alert("添加事件提交...");
				$('#adminLoginname').trigger("blur");
				if (usernamedRegular($('#adminLoginname').val()) !== true) {
					console.error("登录名错误!");
					return;
				}
				$('#adminPassword').trigger("blur");
				if (passwordRegular($('#adminPassword').val()) !== true) {
					console.error("密码格式错误!");
					return;
				}
				$('#adminName').trigger("blur");
				if (nameRegular($('#adminName').val()) !== true) {
					console.error("姓名错误!");
					return;
				}
				$('#adminPhoneNumber').trigger("blur");
				if (phoneNumberRegular($('#adminPhoneNumber').val()) !== true) {
					console.error("电话错误!");
					return;
				}
				// 提交点击请求
				addAdmin('#adminLoginname', '#adminPassword', '#adminName',
						'#adminIdentity', "#adminPhoneNumber");
				// 清空所有input框
				$("#layer-admin input").val("");
				$('#cancel').trigger("click");
				$table.bootstrapTable('refresh');
			});
	// 编辑提交
	$(document).on('click', '#commit2', function() {
		alert("编辑事件提交....");
		// 修改事件
		updateItem(JSON.stringify({
			loginname : $('#adminLoginname').val(),
			password : $('#adminPassword').val(),
			name : $('#adminName').val(),
			identity : $('#adminIdentity').val(),
			phonenumber : $('#adminPhoneNumber').val()
		}), "/crmSys/admin/update", "POST");
		$table.bootstrapTable('refresh');
		$('#cancel').trigger("click");
	});

	// logout
	$('#logout').click(function() {
		$.ajax({
			url : "/crmSys/admin/logout",
			type : "GET",
			dataType : "json",
			success : function(rs) {
				 window.location.href="/crmSys";   
			},
			error : function(rs) {
			}
		});
	});
};// load

// 自定义ajax方法
function ajaxRequest(params) {
	// debugger;
	$.ajax({
		url : "/crmSys/admin/admins",
		type : "GET",
		async : false,
		dataType : "json",
		success : function(rs) {
			var message = rs.array;
			params.success({ // 注意，必须返回参数 params
				total : rs.total,
				rows : message
			});
			// debugger;
		},
		error : function(rs) {
			console.log(rs)
		}
	});
}

var $table = $("#adminTable"), $add = $("#add"), $edit = $("#edit"), $look = $("#look"), $delete = $("#delete"), $refresh = $("#refresh");
// 按钮可用与否
$edit.prop('disabled', true);
$look.prop('disabled', true);
$delete.prop('disabled', true);
$table.on('check.bs.table uncheck.bs.table '
		+ 'check-all.bs.table uncheck-all.bs.table', function() {
	var bool = !($table.bootstrapTable('getSelections').length && $table
			.bootstrapTable('getSelections').length == 1);
	$edit.prop('disabled', bool);
	$look.prop('disabled', bool);
	$delete.prop('disabled', bool);
});

/**
 * 获得选中的数据，为一个对象数组
 */
function getSelections() {
	return $.map($table.bootstrapTable('getSelections'), function(row) {
		console.log("选中" + row);
		console.dir(row);
		return row;
	});
}

// 刷新
$refresh.on('click', function() {
	$table.bootstrapTable('refresh');
	$edit.prop('disabled', true);
	$look.prop('disabled', true);
	$delete.prop('disabled', true);
	// }
});

// 查看
$look.on('click', function() {
	var row = getSelections()[0];
	console.dir("row: " + row);
	layui.use('layer', function() {
		var index = layer.open({
			type : 1,
			title : '查看用户',
			shadeClose : true,
			shade : 0.8,
			area : [ '50%', '350px' ],
			content : $('#layer-admin'),
			success : function() {
				console.log("查看...");
				$('#adminLoginname').val(row.loginname);
				$('#adminPassword').val(row.password);
				$('#adminName').val(row.name);
				$('#adminIdentity').val(row.identity);
				$('#adminPhoneNumber').val(row.phonenumber);
				$('#adminLoginname').attr("disabled", true);
				$('#adminPassword').attr("disabled", true);
				$('#adminName').attr("disabled", true);
				$('#adminIdentity').attr("disabled", true);
				$('#adminPhoneNumber').attr("disabled", true);
				$('#commit').css("display", "none");
				$('#cancel').css("display", "none");
				$('#layer-admin').css("padding", "10px");
				$('#layer-admin > .input-group').css("padding", "10px");
			},
			// 关闭弹窗后执行
			end : function() {
				$('#adminLoginname').attr("disabled", false);
				$('#adminPassword').attr("disabled", false);
				$('#adminName').attr("disabled", false);
				$('#adminIdentity').attr("disabled", false);
				$('#adminPhoneNumber').attr("disabled", false);

				$('#adminLoginname').val("");
				$('#adminPassword').val("");
				$('#adminName').val("");
				$('#adminIdentity').val("");
				$('#adminPhoneNumber').val("");

				$('#commit').css("display", "inline-block");
				$('#cancel').css("display", "inline-block");
				console.log("查看用户...");
			},
			// 右上角关闭事件
			cancel : function() {
				$("#layer-admin input").val("");
			}
		});
	});
});

// 编辑
$edit.on('click', function() {
	var row = getSelections()[0];
	$('#commit2').css("display", "inline-block");
	layui.use('layer', function() {
		var index = layer.open({
			type : 1,
			title : '编辑商品',
			shadeClose : false,
			shade : 0.8,
			area : [ '50%', '60%' ],
			content : $('#layer-admin'),
			success : function() {
				$('#layer-admin').css("padding", "10px");
				$('#layer-admin > .input-group').css("padding", "10px");

				if (row == undefined) {
					layer.msg("未知错误Admin", {
						icon : 2,
						time : 1000
					// 1秒关闭（如果不配置，默认是3秒）
					});
					return;
				}
				$('#adminLoginname').val(row.loginname);
				$('#adminPassword').val(row.password);
				$('#adminName').val(row.name);
				$('#adminIdentity').val(row.identity);
				$('#adminPhoneNumber').val(row.phonenumber);

				$('#adminLoginname').attr("disabled", true);
				$('#commit').off();
			},
			end : function() { // 最后执行reload
				$('#adminLoginname').attr("disabled", false);
				$('#adminLoginname').val("");
				$('#adminPassword').val("");
				$('#adminName').val("");
				$('#adminIdentity').val("");
				$('#adminPhoneNumber').val("");
				$('#commit2').css("display", "none");
			}
		});
	})
});

// 删除
$delete.on('click', function() {
	var ids = getSelections();
	layui.use('layer', function() {
		layer.confirm('您是否要删除当前 ' + ids.length + '条数据？', {
			btn : [ '是', '否' ]
		}, function() {
			deleteItem(JSON.stringify({
				loginname : ids[0].loginname
			}), "/crmSys/admin/delete", "POST");
			delServer(ids);

			$table.bootstrapTable('refresh');
		});
	})
});

// 删除
function delServer(ids) {
	layui.use('layer', function() {
		layer.msg('删除成功', {
			icon : 1,
			time : 800
		// 2秒关闭（如果不配置，默认是3秒）
		}, function() {
		});
	})
}

// 添加
// layui.use( "layer", function () { $add.on('click',function () {
layui.use("layer", function() {
	$add.on('click', function() {
		$('#commit').css("display", "inline-block");
		console.log("123");
		var index = layer.open({
			type : 1,
			title : '添加用户',
			shadeClose : false,
			shade : 0.8,
			scrollbar : false,
			isOutAnim : true,
			anim : 2,
			area : [ '550px', '480px' ],
			content : $('#layer-admin'),
			success : function() {
				$('#layer-admin').css("padding", "10px");
				$('#layer-admin > .input-group').css("padding", "10px");
				// 显示结点
				$('#layer-admin').css("display", 'block');

				// 窗口关闭事件
				$(document).on('click', '#cancel', function() {
					layer.close(index);
				});
				// 判断登录名
				blurVerification('#adminLoginname');
				// 判断密码格式
				blurVerification('#adminPassword');
				// 判断用户名格式
				blurVerification("#adminName");
				// 判断admin电话
				blurVerification("#adminPhoneNumber");

				// 登录名查重
				$(document).on('blur', '#adminLoginname', function() {
					console.log("blur...");
					checkRepeat(JSON.stringify({
						loginname : $('#adminLoginname').val().trim()
					}), "/crmSys/admin/checkLoginName", 'POST', "登录名");
				});
			},
			// 关闭弹窗后执行
			end : function() {
				console.log("借书...");
				$('#commit').css("display", "none");
			},
			// 右上角关闭事件
			cancel : function() {
				// $(document).on( 'click', '#commit', function () {
				$("#layer-admin input").val("");
			}
		});
	});
});
