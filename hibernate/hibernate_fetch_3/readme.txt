hibernate抓取策略，集合代理的批量抓取

保持默认，同fetch="select"，如：
<set name="students" order-by="id" inverse="true" cascade="all" fetch="select">

fetch="select",另外发送一条select语句加载当前对象的关联对象或集合