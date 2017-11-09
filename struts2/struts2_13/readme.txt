struts2的上传

1.struts2默认采用了Apache commons-fileupload

2.Strut2支持三种类型的上传组件

3.需要引入commons-fileupload相关依赖包
	*commons-io-1.3.2.jar
	*commons-fileupload-1.2.1.jar
	
4.表单中需要采用post提交方式，编码类型需要使用：multipart/form-data

5.Struts2的Action
	取得文件名称->>规则：输入域的名称+固定字符串FileName
	取得文件数据->>规则：File 输入域名称
	取得内容类型->>规则：输入域的名称+固定字符串ContentType

6.得到输入流，采用输入流写文件