��һ��hibernate��Ŀ
1.����java��Ŀ
2.����User Library,����������
	*HIBERNATE_HOME/lib/*.jar
	*HIBERNATE_HOME/hibernate3.jar
	*�������ݿ�������mysql������
3.�ṩhibernate.cfg.xml�ļ�����ɻ���������
4.����ʵ����User.java
5.�ṩUser.hbm.xml�ļ������ʵ�����ӳ��
6.��User.hbm.xml�ļ����뵽hibernate.cfg.xml�ļ���
7.��д������ExoprtDB.java����hbm����ddl,Ҳ����hbm����ddl
8.�����ͻ�����Client,����û����ݵ�mysql
��ü����������ã�����۲�hibernate sql������
<property name="hibernate.show_sql">true</property>
���log4j�����ļ����������ļ�������src�£����ڳ���ĵ���