hibernate抓取策略，集合代理的批量抓取


设置fetch="subselect"，如：
<set name="students" order-by="id" inverse="true" cascade="all" fetch="subselect">

fetch="subselect",另外发送一条select语句抓取在前面查询到的所有实体的关联集合

fetch="subselect",会影响hql查询