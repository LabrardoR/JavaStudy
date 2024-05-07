
create database if not exists blog_system charset=utf8;

use blog_system;

drop table if exists blog;
drop table if exists user;

create table blog (
    blogId int primary key auto_increment,
    title varchar(1024),
    content varchar(4096),
    postTime datetime,
    userId int
);

create table user (
    userId int primary key auto_increment,
    username varchar(100) unique,  -- 用户名要求不能重复
    password varchar(50)
);


-- 插入测试数据
insert into blog values(1,'这是第一篇博客','# 从今天开始我要写代码',now(),1);
insert into blog values(2,'这是第一篇博客','# 从昨天开始我要写代码',now(),1);
insert into blog values(3,'这是第一篇博客','# 从明天开始我要写代码',now(),1);

insert into user values(1,'head','123');
insert into user values(2,'hamburger','1233');
