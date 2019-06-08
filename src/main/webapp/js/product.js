$.tableProduct= {
    columns: productcolumns,
    ajax: ajaxProduct,
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
    toolbar: "#toolbarProduct",
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
                '产品编号:  ' + row.pnum,
                '产品名字:  ' + row.pname,
                '供应商姓名:  ' + row.sid,
                '进价:  ' + row.pprice,
                '出售日期:  ' + row.createdate,
                '零售价:  ' + row.pnumber].join(', ')
        }
    }
};

function ajaxProduct(params) {
    $.ajax({
        url: "/crmSys/product/products",
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
