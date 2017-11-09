<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	body, div, td, th {font-size: 12px; }
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		function toLeft(){//单击“<<”按钮时，将左边列表选中的数据删除
			var lineManagerList=document.getElementByName("lineManagerList")[0];//左边列表
			var lineManagerId=document.getElementByName("lineManagerId")[0];
			if(lineManagerId.selectedIndex<0){
				alert("从右边选择一个选项");
				return;
			}
			lineManagerId.options.remove(lineManagerId.options.selectedIndex);
		}
		function toRight(){//单击“>>”按钮时，将左边列表中选中的数据添加到右边列表
			var lineManagerList=document.getElementByName("lineManagerList")[0];//左边列表
			var lineManagerId=document.getElementByName("lineManagerId")[0];
			if(lineManagerId.selectedIndex<0){
				alert("请从左边选择一个员工");
				return;
			}
			for(var i=0;i<lineManagerList.option.length;i++){//遍历左边数据
				var option =lineManagerId.options[i];
				if(option.value==value){
					lineManagerId.selectedIndex=i;//如果已经存在了，则高亮选中即可
					return;
				}
			}
			lineManagerId.options.length=0;//否则，清空左边（因为只允许一个经理）
			var option=new Option(text,value);
			lineManagerId.options.add(option);//添加到左边列表
			lineManagerId.selectedIndex=lineManagerId.options.length-1;//高亮选中
		}
		
		function whetherEnter(){//如果是关键词，在输入框中直接输入回车，则查询
			try{
				if(event.keyCode==13){//Enter键
					query();//执行查询
					return false;
				}
			}catch(error){
				alert("error:"+error+".请单击查询");
				return false;
			}
		}
		function query(){//Ajax查询，主方法
			var key=$('#key')[0].value;//获取关键词，Jquery的方法
		}
	</script>
</head>
<body>
	<form action="DepartmentServlet" method="post"><!-- 部门表单 -->
		<input type="hidden" name="action" value="${action }"><!-- action参数 -->
		<input type="hidden" name="id" value="${id }"><!-- id参数 -->
		<fieldset>
			<legend>添加部门</legend>
			<table>
				<tr>
					<td>名称</td>
					<td><input type="text" name="name" value="${name }"></td>
				</tr>
				<tr>
					<td>经理</td>
					<td>
						<div>
							<input type="text" name="key" id="key" style="width:200px;">
							<input type="button" nae="btnQuery" class="button" value="查询">
						</div>
						<table>
							<tr>
								<td>
									<select name="lineManagerList" size="10" style="width:100px;">
										<option value="">
											输入姓名后查询
										</option>
									</select>
								</td>
								<td><!-- 选中查询结果，双击后移动到右边 -->
									<input type="button" name="btnToRight" value="&gt;&gt;"><br/><br/>
									<input type="button" name="btnToLeft" value="&lt;&lt;" class="button">
								</td>
								<td><!-- 部门经理 -->
									<select name="lineManagerId" size="10"></select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" class="button" value="提交"/></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>