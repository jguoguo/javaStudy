/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/2/15 10:18:35                           */
/*==============================================================*/



-- Type package declaration
create or replace package PDTypes  
as
    TYPE ref_cursor IS REF CURSOR;
end;

-- Integrity package declaration
create or replace package IntegrityPackage AS
 procedure InitNestLevel;
 function GetNestLevel return number;
 procedure NextNestLevel;
 procedure PreviousNestLevel;
 end IntegrityPackage;
/

-- Integrity package definition
create or replace package body IntegrityPackage AS
 NestLevel number;

-- Procedure to initialize the trigger nest level
 procedure InitNestLevel is
 begin
 NestLevel := 0;
 end;


-- Function to return the trigger nest level
 function GetNestLevel return number is
 begin
 if NestLevel is null then
     NestLevel := 0;
 end if;
 return(NestLevel);
 end;

-- Procedure to increase the trigger nest level
 procedure NextNestLevel is
 begin
 if NestLevel is null then
     NestLevel := 0;
 end if;
 NestLevel := NestLevel + 1;
 end;

-- Procedure to decrease the trigger nest level
 procedure PreviousNestLevel is
 begin
 NestLevel := NestLevel - 1;
 end;

 end IntegrityPackage;
/


drop trigger TIB_T_CLASSES
/

drop trigger TIB_T_COURSE
/

drop trigger TIB_T_STUDENT
/

drop table T_CLASSES cascade constraints
/

drop table T_COURSE cascade constraints
/

drop table T_GRADE cascade constraints
/

drop table T_STUDENT cascade constraints
/

drop sequence SEQ_CLASSES_ID
/

drop sequence SEQ_COURSE_ID
/

drop sequence SEQ_STUDENT_ID
/

create sequence SEQ_CLASSES_ID
start with 1
increment by 1
/

create sequence SEQ_COURSE_ID
start with 1
increment by 1
/

create sequence SEQ_STUDENT_ID
increment by 1
start with 10000
/

/*==============================================================*/
/* Table: T_CLASSES                                             */
/*==============================================================*/
create table T_CLASSES 
(
   CLASSES_ID           NUMBER(4)            not null,
   PID                  NUMBER(4),
   CLASSES_NAME         VARCHAR2(40)         not null,
   LEAF                 NUMBER(1)            default 1,
   constraint PK_T_CLASSES primary key (CLASSES_ID)
)
/

comment on column T_CLASSES.LEAF is
'1：是叶子
0：不是叶子'
/

/*==============================================================*/
/* Table: T_COURSE                                              */
/*==============================================================*/
create table T_COURSE 
(
   COURSE_ID            NUMBER(4)            not null,
   COURSE_NAME          VARCHAR2(40 )        not null,
   constraint PK_T_COURSE primary key (COURSE_ID)
)
/

/*==============================================================*/
/* Table: T_GRADE                                               */
/*==============================================================*/
create table T_GRADE 
(
   STUDENT_ID           NUMBER(10)           not null,
   COURSE_ID            NUMBER(4)            not null,
   GRADE                NUMBER(10,2)         default 0 not null,
   constraint PK_T_GRADE primary key (STUDENT_ID, COURSE_ID)
)
/

/*==============================================================*/
/* Table: T_STUDENT                                             */
/*==============================================================*/
create table T_STUDENT 
(
   STUDENT_ID           NUMBER(10)           not null,
   CLASSES_ID           NUMBER(4),
   STUDENT_NAME         VARCHAR2(30)         not null,
   SEX                  CHAR(2 )             not null,
   BIRTHDAY             DATE,
   CONTACT_TEL          VARCHAR2(30),
   ADDRESS              VARCHAR2(40),
   constraint PK_T_STUDENT primary key (STUDENT_ID)
)
/


create trigger TIB_T_CLASSES before insert
on T_CLASSES for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "CLASSES_ID" uses sequence SEQ_CLASSES_ID
    select SEQ_CLASSES_ID.NEXTVAL INTO :new.CLASSES_ID from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger TIB_T_COURSE before insert
on T_COURSE for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "COURSE_ID" uses sequence SEQ_COURSE_ID
    select SEQ_COURSE_ID.NEXTVAL INTO :new.COURSE_ID from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/


create trigger TIB_T_STUDENT before insert
on T_STUDENT for each row
declare
    integrity_error  exception;
    errno            integer;
    errmsg           char(200);
    dummy            integer;
    found            boolean;

begin
    --  Column "STUDENT_ID" uses sequence SEQ_STUDENT_ID
    select SEQ_STUDENT_ID.NEXTVAL INTO :new.STUDENT_ID from dual;

--  Errors handling
exception
    when integrity_error then
       raise_application_error(errno, errmsg);
end;
/

