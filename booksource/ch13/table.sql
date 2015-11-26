create database booksourcedb
go

use booksourcedb
go

create table  book (
    bid		varchar(50)	primary key,
    kind		varchar(50)	not null,
    title		varchar(50)	not null,
    publisher	varchar(50)	not null,
    price		int		not null
)

create table author (
    aid		varchar(50)	primary key,
    name		varchar(50)	not null
)

create table bookauthor (
    bid		varchar(50)	references book(bid),
    aid		varchar(50)	references author(aid)
)
go

insert into book values('b1', '컴퓨터',  'XML 기초', '프리렉', 20000)
insert into book values('b2', '자연과학', '아름다운 자연', '자연출판사', 15000)
insert into book values('b3', '컴퓨터', 'XML 웹서비스', '프리렉', 30000)
insert into book values('b4', '소설', '성공의 열쇠', '성공문화사', 17000)
insert into book values('b5', '자연과학', '우주의 신비', '자연출판사', 50000)

insert into author values('a1', '신용권')
insert into author values('a2', '이자연')
insert into author values('a3', '신민규')
insert into author values('a4', '박소설')
insert into author values('a5', '최하얀')

insert into bookauthor values('b1', 'a1')
insert into bookauthor values('b2', 'a2')
insert into bookauthor values('b3', 'a1')
insert into bookauthor values('b3', 'a3')
insert into bookauthor values('b4', 'a4')
insert into bookauthor values('b5', 'a2')
insert into bookauthor values('b5', 'a5')















