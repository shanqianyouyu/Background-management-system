$.tableSupplier = {
    columns: suppliercolumns,
    ajax: ajaxSupplier,
    method: 'GET',
    sidePagination: 'client',
    search: true,
    searchOnEnterKey: false,
    pagination: true,
    pageNumber: 1,
    pageSize: 10,
    striped: true,
    pageList: "[10, 20]",
    showRefresh: true,
    toolbar: "#toolbarSupplier",
    showToggle: true,                    //是否显示详细视图和列表视图
    iconSize: 'outline',
    paginationPreText: "<<",
    paginationNextText: ">>",
    paginationFirstText: "First",
    paginationLastText: "Last",
    showColumns: true,
    detailView: false,                   //是否显示父子表
    locale: "zh-CN",
    paginationHAlign: "left",
    paginationDetailHAlign: "right",
    trimOnSearch: true,
    // 这里设置表头样式
    theadClasses: "thead-dark",
    rowAttributes: function (row, index) {
        return {
            'data-toggle': 'popover',
            'data-placement': 'bottom',
            'data-trigger': 'hover',
            'data-index': index,
            'title': ['Index: ' + index,
//                            'ID: ' + row.ProductName,
                '供应商编号:  ' + row.snum,
                '名字:  ' + row.sname,
                '所在地址:  ' + row.saddr,
                '创建日期:  ' + row.createdate,
                '联系电话:  ' + row.snumber].join(', ')
        }
    }
};

function ajaxSupplier(params) {
	console.log("供应商请求数据...");
    $.ajax({
        url: "/crmSys/supplier/suppliers",
        type: "GET",
        dataType: "json",
        success: function (rs) {
            var message = rs.array;
            params.success({ // 注意，必须返回参数 params
                total: rs.total,
                rows: message
            });
            // debugger;
        },
        error: function (rs) {
            console.log(rs)
        }
    });
}
