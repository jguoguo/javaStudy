1.��̬ActionForm
	��̬ActionForm���Լ��پ�̬ActionForm��������ʹ�ö�̬ActionForm��ȫ
	���Ի�ȡ��̬ActionForm���еĹ���
	*��struts-config.xml�ļ��ж��嶯̬ActionForm
	<form-beans>
		<form-bean name="dynaForm" type="org.apache.struts.action.DynaActionForm">
			<form-property name="username" type="java.lang.String"/>
			<form-property name="age" type="java.lang.Integer"/>
		</form-bean>
	</form-beans>
	*��Action��ʹ�ö�̬ActionForm���μ�DynaActionFormTestAction.java
		DynaActionForm daf=(DynaActionForm)form;
		String username=(String)daf.get("username");
		Integer age=(Integer)daf.get("age");
	*��̬ActionForm��ʵ�ǰ�ҳ���е�htmlԪ�ص����ֺ�ֵ�ŵ���map�У�����ͨ��get������ȡ������ֵ
	��̬ActionForm����EL���ʽ�������ʽ ${dynabean.map.prop}
	��̬Action����֤��ͨ��ʹ�ö�̬��֤���validator
3.����ActionForm���͵��Զ�ת����
	*boolean:yes,1,on,1,true����ת����True���ͣ����Һ��Դ�Сд,�������Ϊfalse
	*Date���͵�ת��
		*�����java.sql.Date,ҳ�����ڵĸ�ʽ������yyyy-mm-dd���ſ���ת��
		*�����java.util.Date,Ĭ�������structs�޷�ת��
		
	*�Զ���ת������ʵ�ֲ���
		*ʵ��converter�ӿڣ�ʵ��convert����
		*��ʵ�ֵ�converterע�ᣬͨ���������servletע��
		*����servletע����Ҫע���ǩ�����ã�<load-on-startup>10</load-on-startup>