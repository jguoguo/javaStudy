spring��AOP��֧��

1.���Ŀ�����ʵ���˽ӿڣ���Ĭ������»ز���JDK�Ķ�̬����ʵ��AOP
2.���Ŀ�����ʵ���˽ӿڣ�Ҳ����ǿ��ʹ��CGLIB���ɴ���ʵ��AOP
3.���Ŀ�����û��ʵ�ֽӿڣ���ô��������CGLIB��sping����JDK�Ķ�̬�����CGLIB����֮���л�


���ǿ��ʹ��CGLIB���ɴ���
	*����CGLIB�⣬SPRING_HOME/lib/cglib/*.jar
	*�����������ã�ǿ��ʹ��CGLIB����
	<aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>
	
	
JDK��̬�����CGLIB���������
	*JDK��̬�����ʵ���˽ӿڵ�����д���
	*CGLIB������Զ��������Ҫ��ָ����������һ�����࣬��Ϊ�Ǽ̳�
	���ǵ�Ŀ����ò�Ҫ��ʹ��finally