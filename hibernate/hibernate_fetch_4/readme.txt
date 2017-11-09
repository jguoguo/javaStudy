hibernate抓取策略，集合代理的批量抓取


设置fetch="join"，如：
<set name="students" order-by="id" inverse="true" cascade="all" fetch="join">

fetch="join",hibernate会通过一个select语句连接（内联/外联）抓取其关联对象或集合

fetch="join",那么lazy失效

fetch="join",只影响get和load，对hql没有影响
