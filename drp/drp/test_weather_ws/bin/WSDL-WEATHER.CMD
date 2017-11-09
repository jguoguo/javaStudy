set AXIS_HOME=E:\course\JavaProjects\tool\webService\axis\WEB-INF
set CLASSPATH=.;%AXIS_HOME%\lib\axis.jar;%AXIS_HOME%\lib\axis-ant.jar;%AXIS_HOME%\lib\commons-discovery-0.2.jar;%AXIS_HOME%\lib\commons-logging-1.0.4.jar;%AXIS_HOME%\lib\jaxrpc.jar;%AXIS_HOME%\lib\log4j-1.2.8.jar;%AXIS_HOME%\lib\saaj.jar;%AXIS_HOME%\lib\wsdl4j-1.5.1.jar

rem java org.apache.axis.wsdl.WSDL2Java  -p com.bjpowernode.ws http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl

java org.apache.axis.wsdl.WSDL2Java  -p com.bjpowernode.ws Weather.xml
