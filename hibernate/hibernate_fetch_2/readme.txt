hibernateץȡ���ԣ����˴��������ץȡ

����fetch="join"���磺
<many-to-one name="classes" column="classesid" fetch="join"/>

fetch="join",hibernate��ͨ��һ��select������ӣ�����/������ץȡ���������򼯺�

fetch="join",��ôlazyʧЧ

fetch="join",ֻӰ��get��load����hqlû��Ӱ��

<many-to-one>���ܻ����N+1���⣬
�磺��ѯ100��ѧ����ʾ���б��У�
  * ���Ȼᷢ����ѯѧ����sql���	
  * Ȼ��ᷢ�����ݰ༶id��ѯ�༶��sql���
  �����ͻᵼ��N+1���⣬Ҳ���Ƿ�����N+1����䣬������Ӱ������
  
�������ǿ��Բ���Ԥ��ץȡ�Ĳ��ԣ��磺
select s from Student s join fetch s.classes

  
  

