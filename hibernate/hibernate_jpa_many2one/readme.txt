hibernate jpa 多对一关联映射


采用@ManyToOne来映射多对一

关于关联对象在表中的维护，JPA会采用关联对象+"_"+"id"方式作为字段加入表中