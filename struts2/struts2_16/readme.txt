Struts2���쳣��֧�֣�����ʽ�쳣��

	�ֲ��쳣��
		<action name="login" class="com.bjpowernode.struts2.LoginAction">
			<!-- �ֲ��쳣 
			<exception-mapping result="error" exception="com.bjpowernode.struts2.ApplicationException"/>
			-->
			<result>/login_success.jsp</result>
			<result name="error">/login_error.jsp</result>
		</action>
		

	ȫ���쳣��
		<!-- ȫ�ֽ�� -->
		<global-results >
			<result name="global-error">/global_error.jsp</result>
		</global-results>
		
		<!-- ȫ���쳣 -->
		<global-exception-mappings>
			<exception-mapping result="global-error" exception="com.bjpowernode.struts2.ApplicationException" />
		</global-exception-mappings>
		
�ڽ��ҳ���п���ʹ��ELȡ���쳣��Ϣ��
	${exception.message }//��ȡ�쳣��Ϣ
	${exceptionStack }//��ȡ�쳣��ջ