
create database if not exists message_wall charset=utf8;

use message_wall;

-- 删表是为了防止之前数据库里面有一样的表，对现有代码产生影响
drop table if exists message;
create table message (`from` varchar(1024), `to` varchar(1024), message varchar(1024));
