create role 申六;                   /*数据库角色创建*/

create table userDate(              /*数据库创建*/
userName char(20) primary key,
password char(12) NOT NULL,
money1 INT CHECK(money1>0))



grant select,insert,update,delete     /*数据库授权*/
on  userDate
to 申六;



SELECT * FROM userDate;              /*数据库查询*/