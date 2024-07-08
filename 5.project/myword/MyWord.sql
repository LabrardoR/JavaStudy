-- 用户表
create table user
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_name   varchar(20)                        null comment '姓名',
    account     varchar(20)                        null comment '账号',
    password    varchar(20)                        null comment '密码',
    phone       varchar(11)                        null comment '电话',
    gender      tinyint                            null comment '性别:0-女,1-男',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
    is_delete   tinyint  default 0                 null comment '逻辑删除',
    constraint user_pk
        unique (id),
    constraint user_pk_2
        unique (account)
)
    charset = utf8mb4;
-- 查询用户共有多少个单词要背
create table user_relate_word
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_id     bigint                             not null,
    word_id     bigint                             not null,
    level       tinyint  default 0                 not null comment '熟练度: 0-刚添加, 1-不认识, 2-认识, 3-基本熟悉, 4-熟悉, 5-完全掌握',
    create_time datetime default CURRENT_TIMESTAMP null,
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    is_delete   tinyint  default 0                 not null,
    constraint user_relate_word_pk
        unique (id)
)
    comment '关联表,将用户和词库建立联系',
    charset = utf8mb4;

-- 词库
create table word
(
    id          bigint auto_increment comment '主键'
        primary key,
    spell       varchar(30)                        not null comment '单词拼写',
    library     varchar(100)                       null comment '所属词库4(CET4), 6(CET6)',
    explanation varchar(200)                       null comment '基础释义',
    association varchar(200)                       null comment '联想',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
    is_delete   tinyint  default 0                 null comment '逻辑删除',
    constraint word_pk
        unique (spell),
    constraint word_pk_2
        unique (id),
    constraint word_pk_3
        unique (spell)
)
    charset = utf8mb4;

