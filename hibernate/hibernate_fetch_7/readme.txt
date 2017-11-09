hibernate抓取策略,batch-size在集合上的应用

batch-size属性，可以批量加载实体类，参见Classes.hbm.xml
<set name="students" order-by="id" inverse="true" cascade="all" batch-size="3">