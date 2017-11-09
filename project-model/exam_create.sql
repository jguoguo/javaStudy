/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/4/2 21:21:05                            */
/*==============================================================*/


drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   user_id              varchar(10) not null,
   user_name            varchar(30) not null,
   password             varchar(30),
   contact_tel          varchar(30),
   email                varchar(30),
   create_date          timestamp,
   primary key (user_id)
);

