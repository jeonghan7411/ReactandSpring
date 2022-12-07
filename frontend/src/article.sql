create database article;

use article;

create table article(
  id bigint not null auto_increment primary key,
  subject varchar(255),
  writer varchar(30),
  content text,
  ref int,  --그룹명
  ref_step int, --누구 그룹에 속하는지
  ref_level int, --댓글,댓글댓글, 댓글댓글댓글
  ip varchar(255),
  regdate datetime
);


create table article(
  id bigint not null auto_increment primary key,
  subject varchar(255),
  writer varchar(30),
  content text,
  ref int,  
  ref_step int, 
  ref_level int, 
  ip varchar(255),
  regdate datetime
);


