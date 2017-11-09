/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/5/20 11:17:28                           */
/*==============================================================*/


drop table T_XML cascade constraints;

/*==============================================================*/
/* Table: T_XML                                                 */
/*==============================================================*/
create table T_XML 
(
   NUMERO               varchar2(30)         not null,
   REPOSICION           varchar2(30),
   NOMBER               varchar2(30),
   TURNOS               varchar2(100),
   constraint PK_T_XML primary key (NUMERO)
);

