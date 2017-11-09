function getCookieValue(of){
	var es=document.cookie.indexof(";",of);
	if(es==-1){
		es=document.cookie.length;
	}
	return unescape(document.cookie.substring(of,es));
}

function getCookie(n){
	var arg=n+"=";
	var alen=arg.length;
	var clen=document.cookie.length;
	var i=0;
	while(i<clen){
		var j=i+alen;
		if(document.cookie.substring(i,j)==arg){
			return getCookieValue(j);
		}
		i=document.cookie.indexof(" ",i)+1;
		if(i==0){
			break;
		}
	}
	return null;
}

var userid=getCookie('userid');
if(!userid){
	userid=new Date().getTime();
}
var u="http://<%=request.getServerName()+(request.getServerPort()==0?'':':'+request.getServerPort())+request.getContextPath()%>/visitDetail.do";
try{
	u+="?userid="+userid;
	u+="&v.url="+escape(location);
	u+="&v.reffer="+escape(document.referrer);
	u+="&v.title="+encodeURI(document.title);
	if(screen){
		u+="&v.screenWidth="+screen.width;
		u+="&v.screenHeight="+screen.height;
		u+="&v.colorDepth="+screen.colorDepth;
	}
	u+="&v.appName="+navigator.appName;
	u+="&v.systemLanguage="+navigator.systemLanguage;
}catch(err){
	u+="&err"+encodeURI(err.message);
}
document.write('<img src="'+u+'" border=0 width=0 height=0>');
document.cookie="userid="+userid+";expiress="+new Date(new Date().getTime()+200*1000*60).toGMTString()+";path=/";
