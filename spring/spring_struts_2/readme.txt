spring+struts(�ڶ��ַ���)
����ԭ����struts��action����spring����������ҵ���߼����󽫻ᱻע��
		�������������ң�

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
  
3.struts-config.xml�ļ��е�<action>��ǩ��type������Ҫ����Ϊspring�Ĵ���action��org.springframework.web.struts.DelegatingActionProxy
	����action�����ã�ȡ��BeanFactory,Ȼ��IoC�����н����������actionȡ��
4.��Action����spring��������������ҵ���߼���ע���Action
	<bean name="/login" class="com.bjpowernode.usermgr.web.actions.LoginAction">
     	<property name="userManager" ref="userManager"/>
     </bean>
     *����ʹ��name���ԣ�����name���Ե�ֵ�����struts-config.xml�ļ��е�<action>��ǩ��path����ֵһ��
     *��������ҵ���߼�����
     *���齫scope����Ϊprototype������struts�����̰߳�ȫ��
	