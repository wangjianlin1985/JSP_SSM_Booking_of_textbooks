<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title></title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<%@include file="common.jsp"%>


<style type="text/css">
			
body {
	
	background-color:#e6e8ea;
	padding-right:0px !important;
	    background-color: white;
	    height:100%;
}
.modal{
	overflow:auto !important;
	padding-right:0px !important;
}


</style>

</head>
<body >
<!--cantainer-fluid  开始 -->
<div class = "cantainer">
	<!-- row-fluid  第一个开始 -->
	<div class="row">
		<!-- col-md-12  第一个开始 -->
		<div class = "col-md-12">
			<!-- panel panel-default  第一个开始 -->
			<div class="panel panel-default">
				<div class="panel-body">
				<!-- 查询条件开始 -->
				<form id="searchForm" class="form-horizontal">
					<div class="form-group">
						<label class="col-md-1 control-label" for = "book">教材名称</label>
						<div class="col-md-2">
							<input class="form-control" type="text" name="book">
						</div>
						
						<div class="col-sm-6" align="left">
							<button type="button" class="btn btn-md btn-success" onclick = "operation.searchForm()">
								<span class="glyphicon glyphicon-search"></span>查询
							</button>
							<!-- <button type="button" class="btn btn-md btn-info" onclick="">
								<span class="glyphicon glyphicon-download"></span>导出
							</button> -->
						</div>
					</div>
				
				</form>
				<!-- 查询条件结束 -->
				</div>
			</div>
			<!-- panel panel-default  第一个开始 -->
		</div>
		<!-- col-md-12  第一个结束 -->	
	</div>
	<!-- row-fluid  第一个结束 -->
	<!-- row-fluid  第二个开始-->
	<div class="row-fluid">
		<div class="panel panel-default">
			<div class="panel-body">
				<!-- toolbar开始 -->
				<!-- <div id="toolbar" class="btn-toolbar" role="toolbar">
					<button id="add_btn" type="button" class="btn  btn-success btn-md" onclick = "operation.addWindow()">
						<span class="glyphicon glyphicon-plus"></span> 新增
					</button>
					<button id="edit_btn" type="button" class="btn  btn-info  btn_md" onclick="operation.editWindow()">
						<span class="glyphicon glyphicon-edit"></span> 编辑
					</button>
					<button id="delete_btn" type="button" class="btn  btn-danger btn-md" onclick="operation.deleteFrom()">
						<span class="glyphicon glyphicon-minus"></span> 删除
					</button>
				</div> -->
				<!-- toolbar结束 -->
				<table id="dg"></table>
			</div>
		</div>
	</div>
<!-- row-fluid  第二个结束-->

</div>
<script type="text/javascript">

//用户操作
var operation={
	searchForm:function(){
		$('#dg').bootstrapTable("refresh");
	},
	
	
}




$(function(){
	$('#dg').bootstrapTable({
		url:"receive/teaQuery.htm",
		sidePagination:"server",
		queryParams:fmt.queryParams,
		pagination:true,
		pageNumber:1,
		pageSize:10,
		pageList:[10,25,50,100],
		//search:true,
		clickToSelect:true,
		singleSelect:true,
		toolbar:'#toolbar',
		columns:columns,
	})
	
});

//表格格式化
var fmt = {
	queryParams:function(params){
		var temp = getFormJson("searchForm");
		temp.rows = params.limit;
		temp.currentPage = (params.offset/params.limit)+1;
		return temp;
		
	},	
	setTime:function(value,row,index){
		
		return formatTimeYMDhms(value);  //转成年月日时分秒
	},
	setRolId:function(value,row,index){
		var role = "学生";
		if(value==2){
			role = "老师";
		}
		return role;
	},
	setStatus:function(value,row,index){
		var role = "待审核";
		if(value==2){
			role = "审核通过";
		}
		if(value==3){
			role = "审核拒绝";
		}
		return role;
	}
		
}
var columns=[[
 	 {
		field:'ck',
		width:'2%',
		checkbox:true,
		align:'center',
		
	},  
	{
		field:'id',
		title:'id',
		width:10,
		align:'center',
		visible:false
	},
	{field:'book',title:'教材名称',width:10,align:'center',visible:true},
	{field:'typeName',title:'教材类型',width:10,align:'center',visible:true},
	{field:'amount',title:'领用数量',width:10,align:'center',visible:true},
	{field:'createTime',title:'领用时间',width:10,align:'center',visible:true},
	{field:'content',title:'领用说明',width:10,align:'center',visible:true},
	{field:'username',title:'领用人',width:10,align:'center',visible:true},
	{field:'rolId',title:'角色',width:10,align:'center',visible:true,formatter:fmt.setRolId},
	{field:'status',title:'审核状态',width:10,align:'center',visible:true,formatter:fmt.setStatus}
	
]];




</script>



</body>
</html>

