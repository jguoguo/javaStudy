spring��AOP��֧�֣�����Annotation��ʽ��


1.spring������������
	*SPRING_HOME/dist/spring.jar
	*SPRING_HOME/lib/log4j/log4j-1.2.14.jar
	*SPRING_HOME/lib/jakarta-commons/commons-logging.jar
	*SPRING_HOME/lib/aspectj/*.jar
	
2.�������Թ�ע��ģ�黯������SecurityHandle.java

3.����ע��ָ��SecurityHandleΪAspect

4.����ע�ⶨ��Advice��PointCut

5.��applicationContext.xml������AspectJ��Annotation��֧�֣����ҽ�Ŀ�����Aspect�����õ�IOC������

6.�ͻ��˱�д



AOP��Ҫ���	
Cross Cutting Concern
	��һ�ֶ�����������鲼��ϵͳ�Ĵ�������֮��
Aspect	
	�Ժ����Թ�ע���ģ�黯
Advice
	�Ժ����Թ�ע��ľ���ʵ��
Pointcut
	��������AdviceӦ�õ���ЩJoinPoint�ϣ���Spring��˵�Ƿ������á�
		
JoinPoint
Advice��Ӧ�ó�����ִ�еĵ��ʱ����Springֻ֧�ַ�����JoinPoint�������Ҳ����ʹ�����޸ģ��磺Aspecj����֧��
	
Weave
	��AdviceӦ�õ�Target Object�ϵĹ��̽�֯�룬Spring֧�ֵ��Ƕ�̬֯��
Target Object
	Advice��Ӧ�õĶ���
Proxy
	Spring AOPĬ��ʹ��JDK�Ķ�̬�������Ĵ���������ʱ������Ҳ����ʹ��CGLIB����
Introduction
	���Զ�̬��Ϊ����ӷ���