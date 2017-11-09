/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/2/12 13:33:07                           */
/*==============================================================*/


drop table if exists CLASSES;

drop table if exists T_COURSE;

drop table if exists T_GRADE;

drop table if exists T_STUDENT;

/*==============================================================*/
/* Table: CLASSES                                               */
/*==============================================================*/
create table CLASSES
(
   CLASSES_ID           int(4) not null,
   PID                  int(4),
   CLASSES_NAME         varchar(30) not null,
   LEAF                 int(4) comment '1：是叶子
            0：非叶子',
   primary key (CLASSES_ID)
);

/*==============================================================*/
/* Table: T_COURSE                                              */
/*==============================================================*/
create table T_COURSE
(
   COURSE_ID            int(4) not null,
   COURSE_NAME          varchar(20) not null,
   primary key (COURSE_ID)
);

/*==============================================================*/
/* Table: T_GRADE                                               */
/*==============================================================*/
create table T_GRADE
(
   STUDENT_ID           int(10) not null,
   COURSE_ID            int(4) not null,
   GRADE                float(10,2) not null,
   primary key (STUDENT_ID, COURSE_ID)
);

/*==============================================================*/
/* Table: T_STUDENT                                             */
/*==============================================================*/
create table T_STUDENT
(
   STUDENT_ID           int(10) not null auto_increment,
   CLASSES_ID           int(4),
   STUDENT_NAME         varchar(30) not null,
   SEX                  char(2) not null,
   BIRTHDAY             date not null,
   CONTACT_TEL          varchar(40),
   ADDRESS              varchar(40),
   primary key (STUDENT_ID)
);

alter table CLASSES add constraint FK_REFERENCE_4 foreign key (PID)
      references CLASSES (CLASSES_ID) on delete restrict on update restrict;

alter table T_GRADE add constraint FK_REFERENCE_2 foreign key (STUDENT_ID)
      references T_STUDENT (STUDENT_ID) on delete restrict on update restrict;

alter table T_GRADE add constraint FK_REFERENCE_3 foreign key (COURSE_ID)
      references T_COURSE (COURSE_ID) on delete restrict on update restrict;

alter table T_STUDENT add constraint FK_REFERENCE_1 foreign key (CLASSES_ID)
      references CLASSES (CLASSES_ID) on delete restrict on update restrict;

