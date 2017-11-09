hibernate抓取策略，单端代理的批量抓取

保持默认，同fetch="select"，如：
<many-to-one name="classes" column="classesid" fetch="select"/>

fetch="select",另外发送一条select语句加载当前对象的关联对象或集合

fetch为select或join不影响hql，它影响的是load，get方法

