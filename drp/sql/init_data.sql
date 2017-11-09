delete from t_user;
delete from t_data_dict;
delete from t_client;
delete from t_temi_client;
delete from t_table_id;

--初始系统管理员
insert into t_user(user_id,user_name,password) values('root','系统管理员','root123');

--初始化分销商级别
insert into t_data_dict (id,name,category) values('100','一级分销商','A');
insert into t_data_dict (id,name,category) values('101','二级分销商','A');
insert into t_data_dict (id,name,category) values('102','三级分销商','A');
insert into t_data_dict (id,name,category) values('103','四级分销商','A');

--初始化终端客户级别
insert into t_data_dict (id,name,category) values('200','甲级医院','B');
insert into t_data_dict (id,name,category) values('201','乙级医院','B');
insert into t_data_dict (id,name,category) values('202','丙级医院','B');
insert into t_data_dict (id,name,category) values('203','药店','B');
insert into t_data_dict (id,name,category) values('204','其他','B');

--初始化物料类别
insert into t_data_dict (id,name,category) values('300','医疗器械','C');
insert into t_data_dict (id,name,category) values('301','中成药','C');
insert into t_data_dict (id,name,category) values('302','西药','C');


--初始化计量单位
insert into t_data_dict (id,name,category) values('400','盒','D');
insert into t_data_dict (id,name,category) values('401','片','D');
insert into t_data_dict (id,name,category) values('402','箱','D');

--初始化分销商
insert into t_client (id,pid,name,is_leaf,is_client) values(10000,0,'所有分销商','N','N');
insert into t_client (id,pid,name,is_leaf,is_client) values(10001,10000,'华北区','N','N');
insert into t_client (id,pid,name,is_leaf,is_client) values(10002,10000,'东北区','Y','N');
insert into t_client (id,pid,name,is_leaf,is_client) values(10003,10000,'华南区','Y','N');
insert into t_client (id,pid,name,is_leaf,is_client) values(10004,10001,'北京市','N','N');
insert into t_client (id,pid,name,client_level_id,client_id,is_leaf,is_client) values(10005,10004,'北京医药股份有限公司','100','A0001','Y','Y');


--初始化终端客户
insert into t_temi_client (id,pid,name,is_leaf,is_temi_client) values(20000,0,'所有终端客户','N','N');
insert into t_temi_client (id,pid,name,is_leaf,is_temi_client) values(20001,20000,'华北区','N','N');
insert into t_temi_client (id,pid,name,is_leaf,is_temi_client) values(20002,20000,'东北区','Y','N');
insert into t_temi_client (id,pid,name,is_leaf,is_temi_client) values(20003,20000,'华南区','Y','N');
insert into t_temi_client (id,pid,name,is_leaf,is_temi_client) values(20004,20001,'北京市','N','N');
insert into t_temi_client (id,pid,name,temi_client_level_id,temi_client_id,is_leaf,is_temi_client) values(20005,20004,'北京中医医院','200','B0001','Y','Y');

--初始化主键维护表
insert into t_table_id(table_name,value) values('t_client',10005);
insert into t_table_id(table_name,value) values('t_temi_client',20005);
insert into t_table_id(table_name,value) values('t_fiscal_year_period',0);
commit;