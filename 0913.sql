select * from all_tables;

select * from mem;
select * from post order by pdate asc;
SELECT * FROM POST WHERE ROWNUM <=2 ORDER BY PDATE deSC;
select * from mem;
drop table mem;

create table mem(
	mid varchar(15) primary key, --아이디
    name varchar(15), --이름
    mpw varchar(10) --패스워드
);
insert into mem values ('qwe','당근','1212');
insert into mem values ('asd','오이','1212');

create table post(
	pnum int primary key, --게시글 고유넘버
	mid varchar(15) not null, --아이디
	content varchar(100) not null, --내용
	favcnt int default 0, --좋아요
	-- comcnt int default 0, --댓글수
	pdate date default sysdate --작성일
);
insert into post values (1,'qwe','welcome welcome !',2,sysdate);
insert into post values (2,'asd','second post here',0,sysdate);
insert into post values (3,'qwe','today is 9/14',0,sysdate);
insert into post values (4,'asd','☁☁☁☁☁🌤☁☁',0,sysdate);
select * from post where rownum<=2 order by pnum desc;

create table comm(
	cnum int primary key, --댓글 고유넘버
	pnum int, --게시글 넘버
	mid varchar(15) not null, --아이디
	cdate date default sysdate, --작성일
	comm varchar(20) not null, --댓글내용
	constraint postcomm foreign key (pnum) references post (pnum) on delete cascade
);
insert into comm values (1,2,'qwe',sysdate,'hi!');
insert into comm values (2,1,'asd',sysdate,':)');
insert into comm values (3,3,'asd',sysdate,':)');
insert into comm values (4,3,'qwe',sysdate,'914!!');
insert into comm values (5,4,'qwe',sysdate,'☁☁');



