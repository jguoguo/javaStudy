spring��hibernate�ļ̳У����ʽ����

1.openSession��getCurrentSession������
	*openSession����رգ�CurrentSession������������Զ��ر�
	*openSessionû�к͵�ǰ�̰߳󶨣�CurrentSession�͵�ǰ�̰߳�
	
2.���ʹ��currentSession��Ҫ��hibernate.cfg.xml�ļ��н�������
	*����Ǳ�������jdbc����
		<property name="hibernate.current_session_context_class">thread</property>
	*�����ȫ������jta����
		<property name="hibernate.current_session_context_class">jta</property>