﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
.bootstrap-select:not([class*=col-]):not([class*=form-control]):not(.input-group-btn) {
    width: 100%;
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
						
						<label class="col-md-1 control-label" for = "stuName">姓名</label>
						<div class="col-md-2">
							<input class="form-control" type="text" name="teaName">
						</div>
						<label class="col-md-1 control-label" for = "professionId">专业</label>
						<div class="col-md-2">
							<select class="selectpicker" id="professionId2" name="professionId" ></select>
						</div>
						<div class="col-sm-2" align="left">
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
				<div id="toolbar" class="btn-toolbar" role="toolbar">
					<button id="add_btn" type="button" class="btn  btn-success btn-md" onclick = "operation.addWindow()">
						<span class="glyphicon glyphicon-plus"></span> 新增
					</button>
					<button id="edit_btn" type="button" class="btn  btn-info  btn_md" onclick="operation.editWindow()">
						<span class="glyphicon glyphicon-edit"></span> 编辑
					</button>
					<button id="delete_btn" type="button" class="btn  btn-danger btn-md" onclick="operation.deleteFrom()">
						<span class="glyphicon glyphicon-minus"></span> 删除
					</button>
				</div>
				<!-- toolbar结束 -->
				<table id="dg"></table>
			</div>
		</div>
	</div>
<!-- row-fluid  第二个结束-->


</div>
<!--cantainer-fluid  结束 -->

<!-- 第一个model 开始 -->
<div id="setModal" class="modal fade" tabindex="-1" role="dialog" data-backdrop="static" data-keybord="false">
	<div class="modal-dialog" style="width:700px">
		<div class="modal-content">
			<div class="modal-header">
				编辑
			</div>
			<!-- modal-body 开始 -->
			<div class="modal-body">
				<form id="setForm" class="form-horizontal">
					<input type="hidden" name="id">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="teaNo">教师编号</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name = "teaNo" placeholder="请输入教师编号">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="teaName">教师姓名</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name = "teaName" placeholder="请输入>教师姓名">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="teaSex">性别</label>
						<div class="col-sm-6">
							<select class="selectpicker" name="teaSex" style="width:100%">
							    <option value="1">男</option>
							    <option value="2">女</option>
							                               
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="teaAge">年龄</label>
						<div class="col-sm-6">
							<input class="form-control" type="number" name = "teaAge" placeholder="请输入年龄">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label" for="teaPhone">联系电话</label>
						<div class="col-sm-6">
							<input class="form-control" type="text" name = "teaPhone" placeholder="请输入联系电话">
						</div>
					</div>
				
					<div class="form-group">
						<label class="col-sm-4 control-label" for="professionId">专业</label>
						<div class="col-sm-6">
							<select class="selectpicker" id="professionId" name="professionId" ></select>
						</div>
					</div>
				
					
					
				</form>	
			</div>
			<!-- modal-body 结束 -->
			<div class="modal-footer">
				<button id="add_save_btn" type="button" class="btn btn_success" onclick = "operation.addForm()">
					<span class="glyphicon glyphicon-ok"></span>保存
				</button>
				<button id="edit_save_btn" type="button" class="btn btn_info" onclick = "operation.editForm()">
					<span class="glyphicon glyphicon-ok"></span>保存
				</button>
				<button id="delete_save_btn" type="button" class="btn btn_warning" onclick = "operation.closeMoal()">
					<span class="glyphicon glyphicon-remove"></span>关闭
				</button>
			</div>
			
		</div>
	</div>



</div>
<!-- 第一个model 结束 -->

<script type="text/javascript">

//用户操作
var operation={
	searchForm:function(){
		$('#dg').bootstrapTable("refresh");
	},
	//弹出添加页面
	addWindow:function(){
		$('#setModal').modal('show');
		formObj.setBtnIsShow("add_save_btn","edit_save_btn",1);

	},
	//添加表单
	addForm:function(){
		$("#setForm").bootstrapValidator('validate');
		if($("#setForm").data("bootstrapValidator").isValid()){
			var temp = getFormJson("setForm");
			$.post("teacher/insertTeacher.htm", temp ,function(data) {
				var obj = eval('('+data+')');
				$("#dg").bootstrapTable("refresh");
				message.alert(obj.showInfo);
				$('#setForm').data('bootstrapValidator').resetForm(true);
				$('#setForm')[0].reset();
				$('#setModal').modal('hide');
			});
		}
		
	},
	//弹出修改页面
	editWindow:function(){
		var rows = $('#dg').bootstrapTable('getSelections');
		if(rows.length == 1  ){
			setForm("#setForm",rows[0]);
			$('#professionId').selectpicker('val', rows[0].professionId);
			$('#setModal').modal('show');
			formObj.setBtnIsShow("add_save_btn","edit_save_btn",0);
			
		}else{
			message.alert("请选择一条要修改的数据！");
			return;
		}
		
	},
	//修改表单
	editForm:function(){
		var validate = $("#setForm").bootstrapValidator('validate');
		if($("#setForm").data("bootstrapValidator").isValid()){
			var temp = getFormJson("setForm");
			$.post("teacher/updateTeacher.htm", temp ,function(data) {
				var obj = eval('('+data+')');
				$("#dg").bootstrapTable("refresh");
				message.alert(obj.showInfo);
				$('#setForm').data('bootstrapValidator').resetForm(true);
				$('#setForm')[0].reset();
				$('#setModal').modal('hide');
			});
		}
		
	},
	//删除表单
	deleteFrom:function(){
		var rows = $("#dg").bootstrapTable("getSelections");
		if(rows.length == 1  ){
			bootbox.confirm({
				size:"small",
				title:"提示",
				message:"确认删除这条数据吗？",
				callback:function(result){
					if(result){
						$.post("teacher/deleteTeacher.htm", {id:rows[0].id} ,function(data) {
							var obj = eval('('+data+')');
							$("#dg").bootstrapTable("refresh");
							message.alert(data.showInfo);
							
						});
						
					}
				}
			});
			
		}else{
			message.alert("请选择一条要删除的数据！");
			return;
		}
		
	},
	//关闭页面
	closeMoal:function(){
		$('#setForm').data('bootstrapValidator').resetForm(true);
		$('#setForm')[0].reset();
		$('#setModal').modal('hide');
	},
	//导出
	exportFile:function(){
		
		
	},
	//审核
	audit:function(){
		
		
	}
}




$(function(){
	$('#dg').bootstrapTable({
		url:"teacher/query.htm",
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
		if(value !=null && value!=""){
			return formatTimeYMD(value);  //转成年月日时分秒
		}
		
	},
	setSex:function(value,row,index){
		var sex="女";
		if(value==1){
			sex="男";
		}
		return sex;
	}
		
}
var columns=[[
 	{field:'ck',width:'2%',checkbox:true,align:'center'},  
	{field:'id',title:'id',width:10,align:'center',visible:false},
	{field:'teaNo',title:'教师编号',width:10,align:'center',visible:true},
	{field:'teaName',title:'姓名',width:10,align:'center',visible:true},
	{field:'teaAge',title:'年龄',width:10,align:'center',visible:true},
	{field:'teaSex',title:'性别',width:10,align:'center',visible:true,formatter:fmt.setSex},
	{field:'teaPhone',title:'电话',width:10,align:'center',visible:true},
	{field:'professionId',title:'专业',width:10,align:'center',visible:false},
	{field:'professionName',title:'专业',width:10,align:'center',visible:true}, 

]];


$(function(){

	
	//专业
	$.post("profession/findProfession.htm" ,function(data) {
		var obj = eval('('+data+')');
		$('#professionId').empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(obj,function(i,val){ 
			html+="<option value='"+val.id+"'>"+val.professionName+"</option>";
		});
		$('#professionId').append(html);  
		$("#professionId").selectpicker("refresh");
		$('#professionId2').append(html);  
		$("#professionId2").selectpicker("refresh");
	});
	

	
	
	$("#setForm").bootstrapValidator({
		live:'disabled',
		excluded:[':disabled',':hidden',':not(:visible)'],
		fields:{
			teaNo:{
				validators:{
					message:"请输入教师编号!",
				}
			},
			teaName:{
				validators:{
					message:"请输入教师姓名!",
				}
			},
			teaAge:{
				validators:{
					message:"请输入老师年龄!",
				}
			},
			teaPhone:{
				validators:{
					message:"请输入电话！",
				}
			},
		/* 	serieId:{
				validators:{
					message:"请选择系！",
				}
			},
			professionId:{
				validators:{
					message:"请选择专业！",
				}
			},
			classId:{
				validators:{
					message:"请选择班级！",
				}
			},
			termId:{
				validators:{
					message:"请选择学期！",
				}
			}, */
		}
		
	});
	
	
	
})





</script>



</body>
</html>

