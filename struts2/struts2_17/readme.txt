Struts2��������
1.struts2��������ֻ������Action����������AOP��һ��˼·������ʹ���ǵ�ϵͳ�ܹ�
	����ɢ����϶ȵͣ������Բ�Σ����׻������ڴ��벻�ı������£�����������ͻ�����
	��ʵ������OCP
	
2.���ʵ����������(����������������������ģʽ��FilterҲ������������ģʽ)�����ַ�ʽ
	*1.�̳�AbstractInterceptor(������ȱʡ����ģʽ)
	*2.ʵ��Interceptor�ӿ�
	
���ʵ�֣�
1.��д�࣬�̳�AbstractInterceptor�����磺LogInterceptor
2.��struts2.xml�ļ������Ӷ���������
	��package��ǩ���涨�壺
		<interceptors>
			<interceptor name="myLogInterceptor" class="com.bjpowernode.struts2.LogInterceptor"></interceptor>
		</interceptors>
	��action��ǩ��ʹ�ã�
	
		<!-- ����Struts2Ĭ�ϵ������� -->
		<interceptor-ref name="defaultStack"></interceptor-ref>
		<!-- ʹ����־��¼������  -->
		<interceptor-ref name="myLogInterceptor"></interceptor-ref>
		<!-- ʹ�ü�鰲ȫ�������� -->
		<interceptor-ref name="mySecurityInterceptor"></interceptor-ref>
	
	
	
���Էֱ���ÿ����������������Ҫ��ÿ��action�ж�Ҫд���Ƚ��鷳
���Խ����������õ�������ջ�У��Ƚϼ�
		<interceptors>
			<!-- �����¼��־������ -->
			<interceptor name="myLogInterceptor" class="com.bjpowernode.struts2.LogInterceptor"></interceptor>
			<!-- �����鰲ȫ�� -->
			<interceptor name="mySecurityInterceptor" class="com.bjpowernode.struts2.MySecurityInterceptor"></interceptor>
			
			<interceptor-stack name="myInterceptorStack">
				<interceptor-ref name="defaultStack"/>
				<interceptor-ref name="myLogInterceptor"/>
				<interceptor-ref name="mySecurityInterceptor"/>
			</interceptor-stack>
		</interceptors>
		<!-- ����ȱʡ�����������е�action����õ�ʹ�� -->
		<default-interceptor-ref name="myInterceptorStack"/>
		
		
��������ִ��ԭ����ActionInvocation����һ����Ա����Iterator�����Iterator�б��������е�������
ÿ�ζ���ȡ��Iterator����next������ҵ����������ͻ�ִ�У������ִ��action
��ִ�����ˣ�������Ҫ��ջ��
��������ջ����ʵ��ջ������������intercept��������ջ
