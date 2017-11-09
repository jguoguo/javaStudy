create table T_ITEMS 
(
   ITEM_NO              VARCHAR2(10)         not null,
   ITEM_CATEGORY_ID     char(3),
   ITEM_UNIT_ID         char(3),
   ITEM_NAME            VARCHAR2(20)         not null,
   SPEC                 VARCHAR2(20),
   PATTERN              VARCHAR2(20),
   FILE_NAME            VARCHAR2(50),
   constraint PK_T_ITEMS primary key (ITEM_NO)
);