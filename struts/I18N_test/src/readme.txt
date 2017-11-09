1.缺省的Locale是由操作系统决定的
2.Locale是由语言和国际代码构成
3.国际化资源文件是由baseName+Locale构成，如：MessagesBundle_en_US.properties
4.缺省的国际化资源文件是baseName.properties格式命名，如MessagesBundle.properties
5.关于中文必须转换成unicode，可以采用JAVA_HOME/bin/native2ascii工具转换
     批量转换命令如下：
  native2ascii.ext o.properties MessagesBundle_zh_CN.properties

