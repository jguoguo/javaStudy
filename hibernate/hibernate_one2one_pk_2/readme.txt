hibernate 一对一主键关联映射（单向关联Person<--->IdCard）

需要在IdCard加入<one-to-one>标签，指示hibernate将关联对象Person根据主键加载上来

<one-to-one>不影响存储，只影响加载


