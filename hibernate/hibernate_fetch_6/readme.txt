hibernate抓取策略,batch-size在<class>的应用

batch-size属性，可以批量加载实体类，参见Classes.hbm.xml
<class name="com.bjpowernode.hibernate.Classes" table="t_classes" batch-size="10">
