hibernate抓取策略，单端代理的批量抓取

设置fetch="join"，如：
<many-to-one name="classes" column="classesid" fetch="join"/>

fetch="join",hibernate会通过一个select语句连接（内联/外联）抓取其关联对象或集合

fetch="join",那么lazy失效

fetch="join",只影响get和load，对hql没有影响

<many-to-one>可能会出现N+1问题，
如：查询100个学生显示到列表中：
  * 首先会发出查询学生的sql语句	
  * 然后会发出根据班级id查询班级的sql语句
  这样就会导致N+1问题，也就是发出了N+1条语句，会严重影响性能
  
所以我们可以采用预先抓取的策略，如：
select s from Student s join fetch s.classes

  
  

