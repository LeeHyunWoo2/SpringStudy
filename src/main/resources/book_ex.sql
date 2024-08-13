-- 프로젝트에 ojdbc8.jar 연결 한 후에 진행한다.
-- 프로젝트 우클릭 -> Build Path -> config build path -> Libraries 탭 -> Classpath에 삽입 -> apply
-- Deployment Assembly -> java build path -> ojdbc8.jar 추가 -> apply
-- 결과 Referenced Libararies에 ojdbc8.jar 보이면 성공 (책 80페이지)

drop table tbl_board;
drop sequence seq_board;

create sequence seq_board; -- 자동 번호 객체 생성

create table tbl_board(
	bno number(10,0),
	title varchar2 (200) not null,
	content varchar2 (2000) not null,
	writer varchar2 (50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
) -- tbl_board 테이블 생성(번호, 제목, 내용, 작성자, 작성일, 수정일)

alter table tbl_board add constraint pk_board primary key (bno);

select * from TBL_BOARD;

insert into TBL_BOARD (bno, title, content, writer) values(seq_board.nextval, '테스트 제1목', '테스트 내1용', '1kkw');
insert into TBL_BOARD (bno, title, content, writer) values(seq_board.nextval, '테스트 제2목', '테스트 내2용', '2kkw');
insert into TBL_BOARD (bno, title, content, writer) values(seq_board.nextval, '테스트 제3목', '테스트 내3용', '3kkw');
insert into TBL_BOARD (bno, title, content, writer) values(seq_board.nextval, '테스트 제4목', '테스트 내4용', '4kkw');
insert into TBL_BOARD (bno, title, content, writer) values(seq_board.nextval, '테스트 제5목', '테스트 내5용', '5kkw');

insert into TBL_BOARD (bno, title, content, writer) (select seq_board.nextval, title, content, writer from tbl_board);
-- 글 복사용 재귀함수 (지가 본걸 그대로 다시씀)

select count(*)from tbl_board;
select * from TBL_BOARD order by bno desc;


select /*+index_desc (tbl_board pk_board) */* from tbl_board;

select bno, title, content, writer, regdate, updatedate
from(select /*+index_desc(tbl_board pk_board)*/ rownum rn, bno, title, content, writer, regdate, updatedate
from tbl_board where rownum <= 20) where rn >10;

create table tbl_member(
	id varchar2(50),
	pw varchar2(100),
	name varchar2(100),
	mDate date default sysdate
)

select * from tbl_member;

insert into tbl_member(id, pw, name) values('asd1', 'asd', '조건재');
insert into tbl_member(id, pw, name) values('asd2', 'asd', '건조재');
insert into tbl_member(id, pw, name) values('asd3', 'asd', '조재건');
insert into tbl_member(id, pw, name) values('asd4', 'asd', '건재조');
insert into tbl_member(id, pw, name) values('asd5', 'asd', '재건조');
insert into tbl_member(id, pw, name) values('asd6', 'asd', '가나다');
update tbl_member set pw='asd', name='조재건' where id='asd3';


