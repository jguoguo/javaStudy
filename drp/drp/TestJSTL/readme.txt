如果只是使用EL表达式，不需要引入任何jar包，只要jsp/serlvet容器实现了
J2EE1.4/Servlet2.4、JSP2.0规范就可以

JSTL标签的配置和使用
	配置：
		将jstl.jar和standard.jar拷贝到web/lib下
	使用：
		采用taglib指令引入标签库
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
		
自定义函数
	*定义类MyFunctions,方法必须为静态全局的
	*提供tld描述文件，将tld放到WEB-INF或WEB-INF下的任意目录中
	*在jsp中采用taglib进行引入
	*在EL表达式中采用前缀+冒号+函数名方式进行调用
	