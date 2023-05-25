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
	<!-- row-fluid  第一个结束 -->
	
	<!-- row-fluid  第二个开始-->
	<div class="row-fluid">
		<div class="panel panel-default">
			<div class="panel-body">
				<table id="scoreDg"></table>
			</div>
		</div>
	</div>
<!-- row-fluid  第二个结束-->
</div>
<!--cantainer-fluid  结束 -->




<script type="text/javascript">

var stuId="";
//用户操作
var operation={
}

$(function(){
	$('#scoreDg').bootstrapTable({
		url:"score/findScore.htm",
		sidePagination:"server",
		queryParams:fmt.queryParams,
		/* pagination:true,
		pageNumber:1,
		pageSize:10,
		pageList:[10,25,50,100], */
		//search:true,
		clickToSelect:true,
		singleSelect:true,
		columns:score_columns,
	
	})
	
});

//表格格式化
var fmt = {
	queryParams:function(params){
		var temp = {};
		temp.stuId="${user.id}";
		return temp;
	},	
	setTime:function(value,row,index){
		if(value !=null && value!=""){
			return formatTimeYMD(value);  //转成年月日时分秒
		}
		
	},

}




var score_columns=[[
 	{field:'ck',width:'2%',checkbox:true,align:'center'},  
	{field:'id',title:'id',width:10,align:'center',visible:false},
	{field:'scoreTitle',title:'成绩标题',width:10,align:'center',visible:true},
	{field:'courseId',title:'课程',width:10,align:'center',visible:false},
	{field:'courseName',title:'课程',width:10,align:'center',visible:true},
	{field:'score',title:'分数',width:10,align:'center',visible:true},
	{field:'teaName',title:'老师',width:10,align:'center',visible:true},
	{field:'createDate',title:'录入时间',width:10,align:'center',visible:true,formatter:fmt.setTime},
]];














</script>



</body>
</html>

