spring+struts(��һ�ַ���)
����ԭ����Action��ȡ��BeanFactory,ͨ��BeanFactoryȡ��ҵ���߼�����

1.spring��struts������������
	*struts
		--����struts��jstl��������
		--��web.xml�ļ�������ActionServlet
		--�ṩstruts-config.xml�ļ�
		--�ṩ���ʻ�֧��,�ṩȱʡ�Ĺ��ʻ���Դ�ļ�
	*spring
		--����spring���������
		--�ṩspring�������ļ�
		
2.��web.xml�ļ�������ContextLoaderListener����web Server��������ʱ��
	BeanFactory�ŵ�ServletContext��

  <context-param>
  	<param-name>contextConfigLocation</param-name>
  	<param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <listener>
  	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
  
 3.��Action�в���WebApplicationContextUtils.getRequiredWebApplicationContext()��ServletContext
 	��ȡ��BeanFactory
 	
 4.ͨ��BeanFactory��IoC������ȡ��ҵ���߼�����
 
 
 
 ���ַ�������ȱ�㣬
 	��ΪAction�г������������ң�����Action����spring��API
 	��һ���˽��������Һ�����ע�룬��ͬһ��JVM�п��Խ�������ע��