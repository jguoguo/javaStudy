ʹ�������ļ�

1.spring������������
	*SPRING_HOME/dist/spring.jar
	*SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	*SPRING_HOME/lib/jakarta-commons/commons-logging.jar


2.����
	<aop:config>
		<aop:aspect id="secrityAspect" ref="securityHandle">
			<aop:pointcut id="addAddMethod" expression="execution(* add*(..))"/>
			<aop:before method="checkSecurity" pointcut-ref="addAddMethod"/>
		</aop:aspect>
	</aop:config>
	
3.�˽���ʽ�Ļ����﷨
	*ƥ�䷵��ֵ
	*ƥ���
	*ƥ�䷽��
	*ƥ�����