/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/4/4 13:39:03                            */
/*==============================================================*/


drop table if exists t_data_dict;

drop table if exists t_items;

/*==============================================================*/
/* Table: t_data_dict                                           */
/*==============================================================*/
create table t_data_dict
(
   ID                   char(3) not null,
   NAME                 varchar(20) not null,
   CATEGORY             char(1) not null,
   primary key (ID)
);

/*==============================================================*/
/* Table: t_items                                               */
/*==============================================================*/
create table t_items
(
   ITEM_NO              varchar(10) not null,
   CATEGORY             char(3),
   UNIT                 char(3),
   ITEM_NAME            varchar(20) not null,
   SPEC                 varchar(30),
   PATTERN              varchar(30),
   UPLOAD_FILE_NAME     varchar(30),
   primary key (ITEM_NO)
);

alter table t_items add constraint FK_Reference_1 foreign key (CATEGORY)
      references t_data_dict (ID) on delete restrict on update restrict;

alter table t_items add constraint FK_Reference_2 foreign key (UNIT)
      references t_data_dict (ID) on delete restrict on update restrict;

