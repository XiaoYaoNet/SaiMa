create role ����;                   /*���ݿ��ɫ����*/

create table userDate(              /*���ݿⴴ��*/
userName char(20) primary key,
password char(12) NOT NULL,
money1 INT CHECK(money1>0))



grant select,insert,update,delete     /*���ݿ���Ȩ*/
on  userDate
to ����;



SELECT * FROM userDate;              /*���ݿ��ѯ*/