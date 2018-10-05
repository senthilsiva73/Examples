create table clientinfo (clientid number(10) not null primary key, firstname varchar2(100), lastname varchar2(100), address varchar(200), city varchar2(100), state varchar(50), zip varchar(20), ssn varchar2(20), clienttype varchar2(20), businessname varchar2(100));

CREATE SEQUENCE clientinfo_seq
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 1
  INCREMENT BY 1;