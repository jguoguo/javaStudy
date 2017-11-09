<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<script language="JavaScript" type="text/javascript" src="WdatePicker.js"></script>
	<style type="text/css">
*{ border:0px;}
*{ margin:0px; padding:0px;}
body{ font-size:12px; background:url(images/1_14.gif) repeat-y; text-align:left;}
.waps{ margin:opx auto; width:1264px; text-align:center;} 
.top{ margin-top:0px; background: #FFF ;text-align:center;}
.left{ margin:0px auto; padding:0px; float:left; width:230px; height:740px;} 
.leftsc{ margin-left:170px; margin-top:50px;}
.lefttjt{ margin-left:0; margin-top:100px;}
.lefttj{ background:url(images/images/101_02.gif); width:230px; height:150px; margin-top:2px; margin-right:20px;}
.leftdb{width:250px; height:200px;}
.center{ width:150px; margin-top:5px; text-align:center; padding:0px;}
.centerr{ margin-top:270px; margin-left:-970px;}
.centery{ margin-top:10px; margin-left:-970px;}
.centerf{ margin-top:10px; margin-left:-970px;}
.centerl{ margin-top:10px; margin-left:-970px;} 
.centert{ text-align:left; width:50px;}
.centerh{ margin-left:-449px; margin-top:-258px;}
.centerhm{ margin-left:-449px; margin-top:-322px}
.centeryh{margin-left:-449px; margin-top:0px;}
.right{ float:left;text-align:left; width:700px; height:100%;}
.rightty{ margin-left:100px; margin-top:-550px;}
.rightbt{ margin-left:75px; margin-top:135px; padding:0px; }
.p{ width:800px; text-align:right; margin-top:-40px;} 
.tablegd{width:740px;height:300px; overflow:scroll; border:3px solid; border-color:#FFF;  margin-top:30px; margin-left:80px;}<!--滚动条属性-->
.right_table{width:1000px; height:600px; background:#FFF;}
.right_db{width:200px; height:100px;}
.wt{margin-left:540px; margin-top:20px;}
.w{margin-left:580px; margin-top:-28px;}
.et{margin-left:700px; margin-top:-28px}
.e{margin-left:740px; margin-top:-28px;}
.ly{ margin-left:850px; margin-top:-370px;}
.wb{ background:url(images/_09_03_03.gif); margin-left:866px; margin-top:-116px; width:100px; height:70px;}
.syt{ margin-left:870px; margin-top:-10px;}
.xyt{margin-left:930px; margin-top:-15px;}
 

</style>
  </head>
  
  <body>
	<div class="waps">
<div> <!--头部开始-->
    	<div class="top" align="center"><a href="#"><img src="images/images/11_03.gif" align="right" /></a>尊敬的客户，上午好，今天天气<img src="images/images/taiyang_03.gif" />25度-到28度，感冒易发指数4，祝你工作愉快<img src="images/images/11_06.gif" class="top";/>
        </div>
	</div><!--头部结束-->
	<div class="left"><!--左边-->
        <div class="leftsc"><img src="images/images/11_10.gif" width="100"/>
        </div><!--xxlogo-->
        <div class="lefttjt"><img src="images/images/11_16.gif" />
        </div><!--统计图标-->
            
        <div class="lefttj" align="center" id="hjtj_div"><br />今日外呼量：dddddddddd<br />有效通话：681呼<br /> 无效通话：439呼<br /> 有效通话成功率：60%同比昨日：1.5%<br /> 潜在意向客户数：17位同比昨日1.2%<br />
        </div><!--统计层-->
            
           
		<div id="div1"></div>
	<script>
		WdatePicker({eCont:'div1',onpicked:function(dp){
			var xmlHttp;
			if(window.XMLHttpRequest){
				xmlHttp=new XMLHttpRequest();
			}else if(window.ActiveObject){
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			var url="servlet/HjxxServlet?date="+dp.cal.getDateStr()+"&time="+new Date().getTime()
			
			
			xmlHttp.open("GET", url, true);
				xmlHttp.onreadystatechange=function(){
					if(xmlHttp.readyState==4){
						if(xmlHttp.status==200){
						
							var doc=xmlHttp.responseXML;
							//今日呼叫量
							var jrhjl=doc.getElementsByTagName("jrhjl")[0].firstChild.nodeValue;
							//有效通话
							var yxth=doc.getElementsByTagName("yxth")[0].firstChild.nodeValue;
							//无效通话
							var wxth=doc.getElementsByTagName("wxth")[0].firstChild.nodeValue;
							//有效通话成功率
							var yxthcgl=doc.getElementsByTagName("yxthcgl")[0].firstChild.nodeValue;
							//有效通话成功率同比昨日
							//var yxthcgltbzr=doc.getElementsByTagName("yxthcgltbzr")[0].firstChild.nodeValue;
						
							document.getElementById("hjtj_div").innerHTML="<br/>今日外呼量："+jrhjl+"<br/>有效通话："+yxth+"<br/>无效通话："+wxth+"<br/>有效通话成功率："+yxthcgl+"%<br />";
							
							//取得明细
							var hjjl=doc.getElementsByTagName("hjjl");
							
							var s="<table border='2' width='750px;' height='300px' cellspacing='8px'>\n";
							s+="<tr align='center' gbcolor='#CCCCCC'>\n";
							s+="<th width='109'>原始号码</th>\n";
							s+="<th width='109'>呼叫情况</th>\n";
							s+="<th width='109'>姓名</th>\n";
							s+="</tr>\n";
							
							for(var i=0;i<hjjl.length;i++){
								
								var yshm=hjjl[i].childNodes[0].firstChild.nodeValue;
								
								var hjqk=hjjl[i].childNodes[1].firstChild.nodeValue;
								var xm=hjjl[i].childNodes[2].firstChild.nodeValue;
								s+="<tr bgcolor='#CCCCCC' align='center'>\n";
								s+="<td>"+yshm+"</td>\n";
								s+="<td>"+hjqk+"</td>\n";
								s+="<td>"+xm+"</td>\n";
								s+="</tr>\n";
							}
							s+="</table>";
							document.getElementById("hjmx_div").innerHTML=s;
						}else{
							//alert("请求失败,错误码=【"+xmlHttp.status+"】");
						}
					}
				};
				xmlHttp.send(null);
			}})
	</script>
	
		 	<div class="leftdb"><img src="images/images/11_56.gif"/>
        </div><!--左边底部-->
    </div><!--左边结束-->
    <div class="right"><!--右边-->
        <div class="tablegd"><!--滚动条-->
            <div class="right_table" id="hjmx_div">
            
        	</div>
        </div>
	</div><!--右边结束-->   
  </body>
</html>
