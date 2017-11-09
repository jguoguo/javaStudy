/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/7/8 0:01:51                             */
/*==============================================================*/


alter table t_HJMXB
   drop constraint FK_T_HJMXB_REFERENCE_T_KHXXB;

drop table t_HJMXB cascade constraints;

drop table t_hjtjb cascade constraints;

drop table t_khxxb cascade constraints;

/*==============================================================*/
/* Table: t_HJMXB                                               */
/*==============================================================*/
create table t_HJMXB 
(
   "number"             number(10)           not null,
   dhhm                 varchar(30),
   "date"               char(10),
   hjqk                 varchar2(30),
   constraint PK_T_HJMXB primary key ("number")
);

comment on column t_HJMXB.hjqk is
'有效通话
无效通话';

/*==============================================================*/
/* Table: t_hjtjb                                               */
/*==============================================================*/
create table t_hjtjb 
(
   "date"               char(10)             not null,
   yxth                 number(10)           default 0,
   wxth                 number(10)           default 0,
   qzyxkh               number(10)           default 0,
   constraint PK_T_HJTJB primary key ("date")
);

/*==============================================================*/
/* Table: t_khxxb                                               */
/*==============================================================*/
create table t_khxxb 
(
   dhhm                 varchar(30)          not null,
   name                 varchar(20),
   constraint PK_T_KHXXB primary key (dhhm)
);

alter table t_HJMXB
   add constraint FK_T_HJMXB_REFERENCE_T_KHXXB foreign key (dhhm)
      references t_khxxb (dhhm);

