prompt Importing table T_ITEMS...
set feedback off
set define off
insert into T_ITEMS (ITEM_NO, ITEM_CATEGORY_ID, ITEM_UNIT_ID, ITEM_NAME, SPEC, PATTERN)
values ('a003', '300', '400', '�п�1', null, null);

insert into T_ITEMS (ITEM_NO, ITEM_CATEGORY_ID, ITEM_UNIT_ID, ITEM_NAME, SPEC, PATTERN)
values ('a002', '300', '400', 'ͷ��', '1.x', '3000');

insert into T_ITEMS (ITEM_NO, ITEM_CATEGORY_ID, ITEM_UNIT_ID, ITEM_NAME, SPEC, PATTERN)
values ('b001', '300', '400', '�п�2', null, null);

insert into T_ITEMS (ITEM_NO, ITEM_CATEGORY_ID, ITEM_UNIT_ID, ITEM_NAME, SPEC, PATTERN)
values ('a004', '301', '401', '�п�4', null, null);

prompt Done.
