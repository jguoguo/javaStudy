/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/4/27 20:06:54                           */
/*==============================================================*/


drop view V_AIM_CLIENT;

drop table T_CLIENT cascade constraints;

drop table T_CLIENT_INV cascade constraints;

drop table T_DATA_DICT cascade constraints;

drop table T_FISCAL_YEAR_PERIOD cascade constraints;

drop table T_FLOW_CARD_DETAIL cascade constraints;

drop table T_FLOW_CARD_MASTER cascade constraints;

drop table T_ITEMS cascade constraints;

drop table T_TABLE_ID cascade constraints;

drop table T_TEMI_CLIENT cascade constraints;

drop table T_USER cascade constraints;

/*==============================================================*/
/* Table: T_CLIENT                                              */
/*==============================================================*/
create table T_CLIENT 
(
   ID                   NUMBER(10)           not null,
   PID                  NUMBER(10),
   CLIENT_LEVEL_ID      char(3),
   NAME                 VARCHAR2(30)         not null,
   CLIENT_ID            VARCHAR2(10),
   BANK_ACC_NO          VARCHAR2(40),
   CONTACT_TEL          VARCHAR2(30),
   ADDRESS              VARCHAR2(30),
   ZIP_CODE             VARCHAR2(10),
   IS_LEAF              CHAR(1)              default 'Y' not null,
   IS_CLIENT            CHAR(1)              not null,
   constraint PK_T_CLIENT primary key (ID)
);

comment on column T_CLIENT.IS_LEAF is
'Y:是叶子
N:不是叶子';

comment on column T_CLIENT.IS_CLIENT is
'Y:是分销商
N:不是分销商';

/*==============================================================*/
/* Table: T_CLIENT_INV                                          */
/*==============================================================*/
create table T_CLIENT_INV 
(
   FISCAL_ID            NUMBER(10)           not null,
   CLIENT_ID            NUMBER(10)           not null,
   ITEM_NO              VARCHAR2(10)         not null,
   INIT_QTY             number(12,2)         default 0,
   IN_QTY               number(12,2)         default 0,
   OUT_QTY              number(12,2)         default 0,
   constraint PK_T_CLIENT_INV primary key (FISCAL_ID, CLIENT_ID, ITEM_NO)
);

/*==============================================================*/
/* Table: T_DATA_DICT                                           */
/*==============================================================*/
create table T_DATA_DICT 
(
   ID                   char(3)              not null,
   NAME                 VARCHAR2(30)         not null,
   CATEGORY             char(1)              not null,
   constraint PK_T_DATA_DICT primary key (ID)
);

comment on column T_DATA_DICT.CATEGORY is
'A:分销商级别
B:终端客户类型
C:物料类别
D:物料计量单位';

/*==============================================================*/
/* Table: T_FISCAL_YEAR_PERIOD                                  */
/*==============================================================*/
create table T_FISCAL_YEAR_PERIOD 
(
   ID                   NUMBER(10)           not null,
   FISCAL_YEAR          NUMBER(4)            not null,
   FISCAL_PERIOD        NUMBER(4)            not null,
   BEGIN_DATE           date                 not null,
   END_DATE             date                 not null,
   PERIOD_STS           char(1)              not null,
   constraint PK_T_FISCAL_YEAR_PERIOD primary key (ID)
);

comment on column T_FISCAL_YEAR_PERIOD.PERIOD_STS is
'Y:可用
N:不可用';

/*==============================================================*/
/* Table: T_FLOW_CARD_DETAIL                                    */
/*==============================================================*/
create table T_FLOW_CARD_DETAIL 
(
   FLOW_CARD_NO         VARCHAR2(20)         not null,
   AIM_CLIENT_ID        number(10)           not null,
   ITEM_NO              VARCHAR2(10)         not null,
   OPT_QTY              number(12,2)         default 0,
   ADJUST_QTY           number(12,2)         default 0,
   ADJUST_REASON        varchar2(40),
   ADJUST_FLAG          char(1),
   constraint PK_T_FLOW_CARD_DETAIL primary key (FLOW_CARD_NO, ITEM_NO)
);

comment on column T_FLOW_CARD_DETAIL.ADJUST_FLAG is
'Y:调整
N:未调整';

/*==============================================================*/
/* Table: T_FLOW_CARD_MASTER                                    */
/*==============================================================*/
create table T_FLOW_CARD_MASTER 
(
   FLOW_CARD_NO         VARCHAR2(20)         not null,
   OPT_TYPE             char(1),
   FINCAL_YEAR_PERIOD_ID NUMBER(10)           not null,
   CLIENT_ID            NUMBER(10)           not null,
   RECORDER_ID          VARCHAR2(10)         not null,
   OPT_DATE             date                 not null,
   VOU_STS              char(1)              default 'N' not null,
   ADJUSTER_ID          VARCHAR2(10),
   ADJUST_DATE          date,
   SPOTTER_ID           VARCHAR2(10),
   SPOT_DATE            date,
   SPOT_DESC            VARCHAR2(40),
   CONFIRMER_ID         VARCHAR2(10),
   CONF_DATE            date,
   constraint PK_T_FLOW_CARD_MASTER primary key (FLOW_CARD_NO)
);

comment on column T_FLOW_CARD_MASTER.OPT_TYPE is
'A:流向单
B:盘点单';

comment on column T_FLOW_CARD_MASTER.VOU_STS is
'S:送审
N:录入';

/*==============================================================*/
/* Table: T_ITEMS                                               */
/*==============================================================*/
create table T_ITEMS 
(
   ITEM_NO              VARCHAR2(10)         not null,
   ITEM_CATEGORY_ID     char(3),
   ITEM_UNIT_ID         char(3),
   ITEM_NAME            VARCHAR2(20)         not null,
   SPEC                 VARCHAR2(20),
   PATTERN              VARCHAR2(20),
   constraint PK_T_ITEMS primary key (ITEM_NO)
);

/*==============================================================*/
/* Table: T_TABLE_ID                                            */
/*==============================================================*/
create table T_TABLE_ID 
(
   TABLE_NAME           VARCHAR2(30)         not null,
   VALUE                NUMBER(10),
   constraint PK_T_TABLE_ID primary key (TABLE_NAME)
);

/*==============================================================*/
/* Table: T_TEMI_CLIENT                                         */
/*==============================================================*/
create table T_TEMI_CLIENT 
(
   ID                   NUMBER(10)           not null,
   PID                  NUMBER(10),
   TEMI_CLIENT_LEVEL_ID char(3),
   NAME                 VARCHAR2(40)         not null,
   TEMI_CLIENT_ID       VARCHAR2(10),
   CONTACT_TEL          VARCHAR2(30),
   CONTACTOR            VARCHAR2(20),
   ADDRESS              VARCHAR2(30),
   ZIP_CODE             VARCHAR2(10),
   IS_LEAF              char(1)              not null,
   IS_TEMI_CLIENT       char(1)              not null,
   constraint PK_T_TEMI_CLIENT primary key (ID)
);

comment on column T_TEMI_CLIENT.IS_LEAF is
'Y:是叶子
N:不是叶子';

comment on column T_TEMI_CLIENT.IS_TEMI_CLIENT is
'Y:是终端
N:不是终端';

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
create table T_USER 
(
   USER_ID              VARCHAR2(10)         not null,
   USER_NAME            VARCHAR2(20)         not null,
   PASSWORD             VARCHAR2(30)         not null,
   CONTACT_TEL          VARCHAR2(30),
   EMAIL                VARCHAR2(30),
   CREATE_DATE          date,
   constraint PK_T_USER primary key (USER_ID)
);

/*==============================================================*/
/* View: V_AIM_CLIENT                                           */
/*==============================================================*/
create or replace view V_AIM_CLIENT as
select c.id,c.name,c.client_id as client_temi_id,c.client_level_id as client_temi_level_id,d.name as client_temi_level_name from t_client c join t_data_dict d on c.client_level_id=d.id where c.is_client='Y'
union
select t.id,t.name,t.temi_client_id as client_temi_id,t.TEMI_CLIENT_LEVEL_ID as client_temi_level_id,d.name as client_temi_level_name from T_TEMI_CLIENT t join t_data_dict d on t.TEMI_CLIENT_LEVEL_ID=d.id where t.is_temi_client='Y'
with read only;

