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
						
						<label class="col-md-1 control-label" for = "termId">学期</label>
						<div class="col-md-2">
							<select class="selectpicker" id="termId2" name="termId" ></select>
						</div>
						<!-- <label class="col-md-1 control-label" for = "professionId">专业</label>
						<div class="col-md-2">
							<select class="selectpicker" id="professionId2" name="professionId" ></select>
						</div> -->
						<label class="col-md-1 control-label" for = "serieId">系</label>
						<div class="col-md-2">
							<select class="selectpicker" id="serieId2" name="serieId" ></select>
						</div>
						<label class="col-md-1 control-label" for = "classId">班级</label>
						<div class="col-md-2">
							<select class="selectpicker" id="classId2" name="classId" ></select>
						</div>
					</div>
					<div class="form-group">	
						<label class="col-md-1 control-label" for = "stuName">姓名</label>
						<div class="col-md-2">
							<input class="form-control" type="text" name="stuName">
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
				<table id="dg"></table>
			</div>
		</div>
	</div>
<!-- row-fluid  第二个结束-->


</div>
<!--cantainer-fluid  结束 -->


<script type="text/javascript">

//用户操作
var operation={
	searchForm:function(){
		$('#dg').bootstrapTable("refresh");
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
		url:"student/query.htm",
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
		temp.professionId="${user.professionId}"
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
	{field:'stuNo',title:'学号',width:10,align:'center',visible:true},
	{field:'stuName',title:'姓名',width:10,align:'center',visible:true},
	{field:'stuAge',title:'年龄',width:10,align:'center',visible:true},
	{field:'stuSex',title:'性别',width:10,align:'center',visible:true,formatter:fmt.setSex},
	{field:'phone',title:'电话',width:10,align:'center',visible:true},
	{field:'classId',title:'班级',width:10,align:'center',visible:false},
	{field:'className',title:'班级',width:10,align:'center',visible:true},
	{field:'serieId',title:'系',width:10,align:'center',visible:false},
	{field:'serieName',title:'系',width:10,align:'center',visible:true},
	{field:'professionId',title:'专业',width:10,align:'center',visible:false},
	{field:'professionName',title:'专业',width:10,align:'center',visible:true}, 
	{field:'termId',title:'学期',width:10,align:'center',visible:false},
	{field:'termName',title:'学期',width:10,align:'center',visible:true},
	{field:'enterSchool',title:'入学时间',width:10,align:'center',visible:true,formatter:fmt.setTime},
	
]];


$(function(){
	//班级
	$.post("tClass/findClass.htm" ,function(data) {
		var obj = eval('('+data+')');
		$('#classId').empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(obj,function(i,val){ 
			html+="<option value='"+val.id+"'>"+val.className+"</option>";
		});
		$('#classId').append(html);  
		$("#classId").selectpicker("refresh");
		$('#classId2').append(html);  
		$("#classId2").selectpicker("refresh");
	});
	
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
	
	//系
	$.post("serie/findSerie.htm" ,function(data) {
		var obj = eval('('+data+')');
		$('#serieId').empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(obj,function(i,val){ 
			html+="<option value='"+val.id+"'>"+val.serieName+"</option>";
		});
		$('#serieId').append(html);  
		$("#serieId").selectpicker("refresh");
		$('#serieId2').append(html);  
		$("#serieId2").selectpicker("refresh");
	});
	
	//学期
	$.post("term/findTerm.htm" ,function(data) {
		var obj = eval('('+data+')');
		$('#termId').empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(obj,function(i,val){ 
			html+="<option value='"+val.id+"'>"+val.termName+"</option>";
		});
		$('#termId').append(html);  
		$("#termId").selectpicker("refresh");
		$('#termId2').append(html);  
		$("#termId2").selectpicker("refresh");
	});
	

	
	
})





</script>



</body>
</html>

