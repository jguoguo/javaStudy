hibernate��������


�������棬Ҳ��Ϊ���̼��Ļ����SessionFactory���Ļ��棬����������Ա����е�session����
����������������ں�SessionFactory����������һ�£�SessionFactory���Թ����������

������������ú�ʹ�ã�
	1.����jar��
	2.��ehcache.xml�ļ�������src��
	3.��hibernate.cfg.xml�ļ��м��뻺���Ʒ�ṩ��
	<property name="hibernate.cache.provider_class">org.hibernate.cache.EhCacheProvider</property>
	4.���ö������棬��Ҳ������Ĭ������
	<property name="hibernate.cache.use_second_level_cache">true</property>
	5.ָ����Щʵ����ʹ�ö�������
	������ÿ�����ӳ���ļ��У�����<cache>��ǩָ����������hibernate.cfg.xml�ļ���ͳһָ��
	ע��ʹ�õĲ��ԣ�ͨ������read-only��read-write
	����ԭ��ͨ����ԶԶ����д�����ݽ��л���
	
	
����������Ҫ�ǻ���ʵ������
�˽�һ������Ͷ�������Ľ���

ע�⣺���������ݸ���ʱ����������˶������潨�����һ������Ͷ�������Ľ���