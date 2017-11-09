hibernate 一对一唯一外键关联映射（单向关联Person--->IdCard）

一对一唯一外键关联映射其实是多对一的特例

采用<many-to-one>标签来映射，指定多的一端unique为true，这样就限制了多的一端的多重性为一


